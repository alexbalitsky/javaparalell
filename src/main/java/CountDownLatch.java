import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 16.03.2017.
 */
public class CountDownLatch implements CalculationTask, Runnable {
    private Data.Function function;
    private java.util.concurrent.CountDownLatch countDownLatch;

    public CountDownLatch(Data.Function function) {
        this.function = function;
    }

    public CountDownLatch(Data.Function function, java.util.concurrent.CountDownLatch countDownLatch) {
        this.function = function;
        this.countDownLatch = countDownLatch;
    }

    public CountDownLatch() {
    }

    public void run() {
        System.out.println(function.calculate());
        if (countDownLatch != null){
            countDownLatch.countDown();
        }
    }

    public void calculate() {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(2);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new CountDownLatch(new Data.FirstFunction(), countDownLatch));
        executorService.execute(new CountDownLatch(new Data.SecondFunction(), countDownLatch));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.execute(new CountDownLatch(new Data.ThirdFunction()));
        executorService.execute(new CountDownLatch(new Data.FourthFunction()));
        executorService.shutdown();
    }

}
