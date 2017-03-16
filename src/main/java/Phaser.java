import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 16.03.2017.
 */
public class Phaser implements CalculationTask, Runnable {

    private Data.Function function;
    private java.util.concurrent.Phaser phaser;

    public Phaser(Data.Function function) {
        this.function = function;
    }

    public Phaser(Data.Function function, java.util.concurrent.Phaser phaser) {
        this.function = function;
        this.phaser = phaser;
        phaser.register();
    }

    public Phaser() {
    }

    public void run() {

        System.out.println(Thread.currentThread().getName() + "arrived");

        if (phaser != null){
            phaser.arriveAndAwaitAdvance();
        }

        System.out.println(function.calculate());

        if (phaser != null){
            phaser.arriveAndDeregister();
        }

        System.out.println(Thread.currentThread().getName() + "in the end");
    }

    public void calculate() {
        java.util.concurrent.Phaser phaser = new java.util.concurrent.Phaser();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Phaser(new Data.FirstFunction(), phaser));
        executorService.execute(new Phaser(new Data.SecondFunction()));
        executorService.execute(new Phaser(new Data.ThirdFunction()));
        executorService.execute(new Phaser(new Data.FourthFunction(), phaser));
        executorService.shutdown();

    }
}
