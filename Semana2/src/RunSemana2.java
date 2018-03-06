import java.util.Vector;

public class RunSemana2 {

    public static void main(String[] args) {

        System.out.println(GCD(20, 10));
    }

    public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
}
