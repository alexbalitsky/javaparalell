import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 16.03.2017.
 */
public class Threads implements CalculationTask, Runnable{
    private Data.Function function;

    public Threads(Data.Function function) {
        this.function = function;
    }

    public Threads() {
    }

    public void run() {
        System.out.println(function.calculate());
    }

    public void calculate() {
        new Thread(new Threads(new Data.FirstFunction())).start();
        new Thread(new Threads(new Data.SecondFunction())).start();
        new Thread(new Threads(new Data.ThirdFunction())).start();
        new Thread(new Threads(new Data.FourthFunction())).start();
    }
}
