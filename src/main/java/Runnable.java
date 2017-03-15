import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by obalitskiy on 3/15/17.
 */
public class Runnable implements CalculationTask, java.lang.Runnable{
    private Data.Function function;

    public Runnable(Data.Function function) {
        this.function = function;
    }

    public Runnable() {
    }

    public void run() {
        System.out.println(function.calculate());
    }

    public void calculate() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Runnable(new Data.FirstFunction()));
        executorService.execute(new Runnable(new Data.SecondFunction()));
        executorService.execute(new Runnable(new Data.ThirdFunction()));
        executorService.execute(new Runnable(new Data.FourthFunction()));
        executorService.shutdown();
    }
}
