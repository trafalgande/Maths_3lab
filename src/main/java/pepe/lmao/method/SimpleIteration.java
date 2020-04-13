package pepe.lmao.method;

import java.util.ArrayList;

public class SimpleIteration {
    Function function = new Function();
    ArrayList<Double> x = new ArrayList<>();
    int n = 0;

    StringBuilder stringBuilder = new StringBuilder();

    public String result(double lower, double upper, double eps, boolean way) {
        double lambda = -1 / Math.max(function.derivative("'", lower), function.derivative("'", upper));
        if (function.derivative("'", lower) > function.derivative("'", upper))
            x.add(0, lower);
        else
            x.add(0, upper);

        x.add(1, x.get(0) + lambda * (function.f(x.get(0))));
        int i = 1;
        while (Math.abs(x.get(i) - x.get(i - 1)) > eps) {
            x.add(i + 1, x.get(i) + (lambda * function.f(x.get(i))));
            n++;
            i++;
        }
        if (way) {
            System.out.println("-->Simple Iteration Method: ");
            System.out.println(" x = " + x.get(x.size() - 1) + "\n f(x) = " + function.f(x.get(x.size() - 1)) + "\n Iterations: " + n + "\n");
            return "Done";
        } else {
            stringBuilder.append("\n-->Simple Iteration Method: \n");
            stringBuilder.append(" x = ").append(x.get(x.size() - 1)).append("\n f(x) = ").append(function.f(x.get(x.size() - 1))).append("\n Iterations: ").append(n).append("\n");
            return stringBuilder.toString();
        }

    }
}
