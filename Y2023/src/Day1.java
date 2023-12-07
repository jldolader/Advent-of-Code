import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day1.txt";

        System.out.println(partOne(filePath));
        System.out.println(partTwo(filePath));
    }

    private static String partOne(String filePath) {
        String line;
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[a-z]", "");
                sum += Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 1 - The sum of all calibration values is: %d", sum);
    }

    private static String partTwo(String filePath) {
        Map<String, String> digitMap = Map.of("one", "o1e", "two", "t2o",
                "three", "t3e", "four", "f4r", "five", "f5e",
                "six", "s6x", "seven", "s7n", "eight", "e8t",
                "nine", "n9e");
        String line;
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                for (Map.Entry<String, String> entry : digitMap.entrySet()) {
                    line = line.replaceAll(entry.getKey(), entry.getValue());
                }

                line = line.replaceAll("[a-z]", "");
                sum += Integer.parseInt(line.charAt(0) + "" + line.charAt(line.length() - 1));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 2 - The sum of all calibration values is: %d", sum);
    }
}
