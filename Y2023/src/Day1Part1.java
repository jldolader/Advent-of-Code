import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1Part1 {
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
            throw new RuntimeException(e);
        }
    }

    private static Integer treatLine(String line) {
        line = line.replaceAll("[a-z]", "");
        return Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
    }
}
