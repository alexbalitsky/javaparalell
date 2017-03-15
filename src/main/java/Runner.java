/**
 * Created by obalitskiy on 3/15/17.
 */
public class Runner {
    public static void main(String[] args) {
        new Runner().calculate(new Runnable());
    }

    public void calculate(CalculationTask calculationTask){
        calculationTask.calculate();
    }
}
