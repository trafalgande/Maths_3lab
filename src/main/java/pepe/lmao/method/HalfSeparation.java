package pepe.lmao.method;

public class HalfSeparation {
    Function function = new Function();
    double x = 0;
    int n = 0;
    StringBuilder stringBuilder = new StringBuilder();

    public String result(double lower, double upper, double eps, boolean way) {

        while (Math.abs(lower - upper) > eps) {
            x = (upper + lower) / 2;
            if (function.f(lower) * function.f(x) <= 0) {
                upper = x;
            } else {
                lower = x;
                x = (upper + lower) / 2;
            }
            ++n;
        }
        if (way) {
            System.out.println("-->Half Separation Method: ");
            System.out.println(" x = " + x + "\n f(x) = " + function.f(x) + "\n Iterations: " + n + "\n");
            return "Done";
        } else {
            stringBuilder.append("-->Half Separation Method: \n");
            stringBuilder.append(" x = ").append(x).append("\n f(x) = ").append(function.f(x)).append("\n Iterations: ").append(n).append("\n");
            return stringBuilder.toString();
        }
    }
}
