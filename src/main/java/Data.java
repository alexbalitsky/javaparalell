import org.ejml.simple.*;

import java.util.Random;

/**
 * Created by obalitskiy on 3/15/17.
 */
public class Data {
    public static final SimpleMatrix MC;
    public static final SimpleMatrix MZ;
    public static final SimpleMatrix MM;
    public static final SimpleMatrix MA;
    public static final SimpleMatrix MB;
    public static final SimpleMatrix MO;
    public static final SimpleMatrix MX;
    public static final SimpleMatrix MT;
    public static final SimpleMatrix MD;


    public static final SimpleMatrix A;
    public static final SimpleMatrix B;
    public static final SimpleMatrix C;
    public static final SimpleMatrix D;
    public static final SimpleMatrix E;


    public static final double a;
    
    static {
        MC = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MZ = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MM = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MA = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MB = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MO = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MX = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MT = SimpleMatrix.random(10, 10, 1, 50, new Random(10));
        MD = SimpleMatrix.random(10, 10, 1, 50, new Random(10));

        A = SimpleMatrix.random(1, 10, 1, 50, new Random(10));
        B = SimpleMatrix.random(1, 10, 1, 50, new Random(10));
        C = SimpleMatrix.random(1, 10, 1, 50, new Random(10));
        D = SimpleMatrix.random(1, 10, 1, 50, new Random(10));
        E = SimpleMatrix.random(1, 10, 1, 50, new Random(10));

        a = 3.22242354523432423542234524234; //TODO
    }

    public interface Function{
        SimpleMatrix calculate();
    }

    public static class FirstFunction implements Function{
        public SimpleMatrix calculate(){
            return MA.plus(MZ);
        }
    }

    public static class SecondFunction implements Function{
        public SimpleMatrix calculate(){
            return B.mult(MC.plus(MZ)).plus(E.mult(MM));
        }
    }

    public static class ThirdFunction implements Function{
        public SimpleMatrix calculate(){
            return B.mult(MC.plus(MZ)).plus(E.mult(MM));
        }
    }

    public static class FourthFunction implements Function{
        public SimpleMatrix calculate(){
            return B.mult(MC.plus(MZ)).plus(E.mult(MM));
        }
    }
}
