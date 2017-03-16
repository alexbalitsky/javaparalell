import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by mac on 16.03.2017.
 */
public class ForkJoin extends RecursiveAction implements CalculationTask {
    private List<Data.Function> functions;

    public ForkJoin(List<Data.Function> functions) {
        this.functions = functions;
    }

    public ForkJoin() {
    }


    @Override
    protected void compute() {
        List<ForkJoin> subTasks = new ArrayList<>();

        if (functions.size() > 1){
            for (Data.Function function : functions){
                ForkJoin task = new ForkJoin(Arrays.asList(function));
                task.fork();
                subTasks.add(task);
            }
        } else if (functions.size() == 1){
            for (Data.Function function : functions){
                System.out.println(function.calculate());
            }
            System.out.println();
        }

        for (ForkJoin subTask : subTasks){
            subTask.join();
        }
    }

    public void calculate() {
        List<Data.Function> functions = new ArrayList<>();
        functions.add(new Data.FirstFunction());
        functions.add(new Data.SecondFunction());
        functions.add(new Data.ThirdFunction());
        functions.add(new Data.FourthFunction());

        ForkJoin forkJoin = new ForkJoin(functions);
        new ForkJoinPool().invoke(forkJoin);
    }
}
