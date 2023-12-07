import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day2.txt";

        System.out.println(partOne(filePath));
        System.out.println(partTwo(filePath));
    }

    private static String partOne(String filePath) {
        int result = 0;
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                index += 1;
                int sIndex = 2;
                String[] tokens = line.split(" ");
                boolean good = true;

                while (sIndex < tokens.length) {
                    int amt = Integer.parseInt(tokens[sIndex++]);
                    String color = tokens[sIndex++];
                    if (color.charAt(0) == 'r' && amt > 12) {
                        good = false;
                    }
                    if (color.charAt(0) == 'g' && amt > 13) {
                        good = false;
                    }
                    if (color.charAt(0) == 'b' && amt > 14) {
                        good = false;
                    }
                }

                if (good) {
                    result += index;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 1 - The result is: %d", result);
    }

    private static String partTwo(String filePath) {
        int result = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                int sIndex = 2;
                String[] tokens = line.split(" ");
                int red = 0;
                int green = 0;
                int blue = 0;
                while (sIndex < tokens.length) {
                    int amt = Integer.parseInt(tokens[sIndex++]);
                    String color = tokens[sIndex++];
                    if (color.charAt(0) == 'r') {
                        red = Math.max(red, amt);
                    }
                    if (color.charAt(0) == 'g') {
                        green = Math.max(green, amt);
                    }
                    if (color.charAt(0) == 'b') {
                        blue = Math.max(blue, amt);
                    }
                }
                result += red * green * blue;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 2 - The result is: %d", result);
    }

}
