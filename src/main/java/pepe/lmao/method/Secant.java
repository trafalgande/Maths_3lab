package pepe.lmao.method;

import java.util.ArrayList;

public class Secant {
    Function function = new Function();
    ArrayList<Double> x = new ArrayList<>();
    int n = 0;
    StringBuilder stringBuilder = new StringBuilder();

    public String result(double lower, double upper, double eps, boolean way) {
        if (function.derivative("''", lower) * function.f(lower) > 0)
            x.add(0, lower);
        else
            x.add(0, upper);
        x.add(1, x.get(0) - x.get(0) / 10);
        int i = 1;
        while (Math.abs(x.get(i - 1) - x.get(i)) > eps) {
            x.add(i + 1, x.get(i) - (x.get(i) - x.get(i - 1)) / (function.f(x.get(i)) - function.f(x.get(i - 1))) * function.f(x.get(i)));
            i++;
            n++;
        }
        if (way) {
            System.out.println("-->Secant Method: ");
            System.out.println(" x = " + x.get(x.size() - 1) + "\n f(x) = " + function.f(x.get(x.size() - 1)) + "\n Iterations: " + n + "\n");
            return "Done";
        } else {
            stringBuilder.append("\n-->Secant Method: \n");
            stringBuilder.append(" x = ").append(x.get(x.size() - 1)).append("\n f(x) = ").append(function.f(x.get(x.size() - 1))).append("\n Iterations: ").append(n).append("\n");
            return stringBuilder.toString();
        }

    }


}
