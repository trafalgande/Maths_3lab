package pepe.lmao.method;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Function {


    public void solve(double lower, double upper, double eps) {

        if (f(lower) * f(upper) <= 0) {
            HalfSeparation halfSeparation = new HalfSeparation();
            halfSeparation.result(lower, upper, eps, true);
        } else {
            System.out.println("-->Half Separation Method Exception:\n Invalid bounds\n");
        }

        if (f(lower) * f(upper) <= 0) {
            Secant secant = new Secant();
            secant.result(lower, upper, eps, true);
        } else {
            System.out.println("-->Secant Method Exception:\n Invalid bounds\n");
        }

        if (Math.abs(Math.max(derivative("'", lower), derivative("'", upper))) >= 1) {
            SimpleIteration simpleIteration = new SimpleIteration();
            simpleIteration.result(lower, upper, eps, true);
        } else {
            System.out.println("-->Simple Iteration Method Exception:\n Invalid bounds\n");
        }
    }

    public String solveToFile(double lower, double upper, double eps) {
        StringBuilder stringBuilder = new StringBuilder();
        if (f(lower) * f(upper) <= 0) {
            HalfSeparation halfSeparation = new HalfSeparation();
            stringBuilder.append(halfSeparation.result(lower, upper, eps, false));

        } else {
            stringBuilder.append("-->Half Separation Method Exception:\n Invalid bounds\n");
        }

        if (f(lower) * f(upper) <= 0) {
            Secant secant = new Secant();
            stringBuilder.append(secant.result(lower, upper, eps, false));

        } else {
            stringBuilder.append("-->Secant Method Exception:\n Invalid bounds\n");
        }

        if (Math.abs(Math.max(derivative("'", lower), derivative("'", upper))) >= 1) {
            SimpleIteration simpleIteration = new SimpleIteration();
            stringBuilder.append(simpleIteration.result(lower, upper, eps, false));
        } else {
            stringBuilder.append("-->Simple Iteration Method Exception:\n Invalid bounds\n");
        }
        return stringBuilder.toString();
    }

    public double f(double x) {
        return Math.pow(x, 3) - 3.78 * Math.pow(x, 2) + 1.25 * x + 3.49;
    }

    public double derivative(String n, double x) {
        double res;
        switch (n) {
            case "'":
                res = 3 * Math.pow(x, 2) - 7.56 * x + 1.25;
            case "''":
                res = 6 * x - 7.56;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
        return res;
    }
}
