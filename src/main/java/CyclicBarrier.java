import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 16.03.2017.
 */
public class CyclicBarrier implements CalculationTask, Runnable {

    private Data.Function function;
    private java.util.concurrent.CyclicBarrier cyclicBarrier;

    public CyclicBarrier(Data.Function function) {
        this.function = function;
    }

    public CyclicBarrier(Data.Function function, java.util.concurrent.CyclicBarrier cyclicBarrier) {
        this.function = function;
        this.cyclicBarrier = cyclicBarrier;
    }

    public CyclicBarrier() {
    }

    public void run() {
        if (cyclicBarrier != null){
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        System.out.println(function.calculate());
    }

    public void calculate() {
        java.util.concurrent.CyclicBarrier cyclicBarrier = new java.util.concurrent.CyclicBarrier(2, new CyclicBarrier(new Data.FirstFunction()));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new CyclicBarrier(new Data.SecondFunction(), cyclicBarrier));
        executorService.execute(new CyclicBarrier(new Data.ThirdFunction(), cyclicBarrier));
        executorService.execute(new CyclicBarrier(new Data.FourthFunction()));
        executorService.shutdown();
    }
}
