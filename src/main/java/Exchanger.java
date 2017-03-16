import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 16.03.2017.
 */
public class Exchanger implements CalculationTask, Runnable {
    private Data.Function function;
    private java.util.concurrent.Exchanger<Data.Function> exchanger;

    public Exchanger(Data.Function function) {
        this.function = function;
    }

    public Exchanger(Data.Function function, java.util.concurrent.Exchanger<Data.Function> exchanger) {
        this.function = function;
        this.exchanger = exchanger;
    }

    public Exchanger() {
    }

    public void run() {
        if (exchanger != null){
            try {
                function = exchanger.exchange(function);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (function != null) {
            System.out.println(function.calculate());
        }
    }

    public void calculate() {
        java.util.concurrent.Exchanger<Data.Function> exchanger = new java.util.concurrent.Exchanger<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Exchanger(new Data.FirstFunction(), exchanger));
        executorService.execute(new Exchanger(new Data.SecondFunction(), exchanger));
        executorService.execute(new Exchanger(new Data.ThirdFunction()));
        executorService.execute(new Exchanger(new Data.FourthFunction()));
        executorService.shutdown();
    }

}
