package pepe.lmao.chart;

import pepe.lmao.method.Function;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class XYChart {
    Function function = new Function();

    final TreeMap<Integer, Double> set = new TreeMap<>();
    public void plot(double lower, double upper) throws IOException {
        for (int i = (int) lower; i < upper; i++) {
            set.put(i, function.f(i));
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Double> entry : set.entrySet()) {
            sb.append(entry.getKey()).append(",").append(entry.getValue()).append(" ");
        }
        String script = "python plot.py " + sb.toString();
        File file = new File("script.sh");
        Files.write(Paths.get(String.valueOf(file)), script.getBytes());
        ProcessBuilder builder = new ProcessBuilder().command("sh ./script.sh".split(" "));
        try {
            Process process = builder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
