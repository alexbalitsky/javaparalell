import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by obalitskiy on 3/15/17.
 */
public class Executor implements CalculationTask, java.lang.Runnable{
    private Data.Function function;

    public Executor(Data.Function function) {
        this.function = function;
    }

    public Executor() {
    }

    public void run() {
        System.out.println(function.calculate());
    }

    public void calculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Executor(new Data.FirstFunction()));
        executorService.execute(new Executor(new Data.SecondFunction()));
        executorService.execute(new Executor(new Data.ThirdFunction()));
        executorService.execute(new Executor(new Data.FourthFunction()));
        executorService.shutdown();
    }
}
