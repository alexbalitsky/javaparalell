/**
 * Created by obalitskiy on 3/15/17.
 */
public class Runner {
    public static void main(String[] args) {
        new Runner().calculate(new Executor());
        new Runner().calculate(new Threads());
        new Runner().calculate(new CountDownLatch());
        new Runner().calculate(new CyclicBarrier());
        new Runner().calculate(new Exchanger());
        new Runner().calculate(new Phaser());
        new Runner().calculate(new ForkJoin());
    }

    public void calculate(CalculationTask calculationTask){
        calculationTask.calculate();
    }
}
