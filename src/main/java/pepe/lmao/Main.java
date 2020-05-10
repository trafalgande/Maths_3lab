package pepe.lmao;

import pepe.lmao.chart.XYChart;
import pepe.lmao.method.Function;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        int inputChosenOption;
        int outputChosenOption;

        double lower = 0;
        double upper = 0;
        double eps = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input data via:\n 1. File\n 2. Console");
        inputChosenOption = scanner.nextInt();

        System.out.println("Output result via:\n 1. File\n 2. Console");
        outputChosenOption = scanner.nextInt();

        Function function = new Function();
        switch (inputChosenOption) {
            case 1:
                String row;
                String[] data;
                BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                while ((row = reader.readLine()) != null) {
                    data = row.split(",");
                    lower = Double.parseDouble(data[0]);
                    upper = Double.parseDouble(data[1]);
                    eps = Double.parseDouble(data[2]);
                }
                break;
            case 2:
                System.out.println("Set lower bound: ");
                lower = scanner.nextDouble();
                System.out.println("Set upper bound: ");
                upper = scanner.nextDouble();
                System.out.println("Set accuracy: ");
                eps = scanner.nextDouble();
                break;
            default:
                System.out.println("Unexpected value: " + inputChosenOption);
                break;
        }
        switch (outputChosenOption) {
            case 1:
                writeUsingBufferedWriter(function.solveToFile(lower, upper, eps));
                System.out.println("-->Done! Check the file: " + filename);
                break;
            case 2:
                function.solve(lower, upper, eps);
                break;
            default:
                System.out.println("Unexpected value: " + outputChosenOption);
                break;
        }

        XYChart xyChart = new XYChart();
        xyChart.plot(lower, upper);


    }

    private static String filename = "";
    private static void writeUsingBufferedWriter(String data)
            throws IOException {
        Random random = new Random();
        filename = "output_" + Math.abs(random.nextInt()) + ".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(data);
        writer.close();
    }
}
