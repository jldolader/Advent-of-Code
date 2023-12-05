import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day1Part2 {

    // Replaces number with digits but maintain 1-letter overlap
    private static final Map<String, String> digitMap = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    );

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int sum = 0;

            while ((line = br.readLine()) != null) {
                sum += treatLine(line);
            }

            System.out.println("The sum of all calibration values is: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer treatLine(String line) {
        for (Map.Entry<String, String> entry : digitMap.entrySet()) {
            line = line.replaceAll(entry.getKey(), entry.getValue());
        }


        line = line.replaceAll("[a-z]", "");
        return Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
    }
}
