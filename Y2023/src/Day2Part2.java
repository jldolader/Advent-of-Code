import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2Part2 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day2.txt";
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

        System.out.println("The result is: " + result);
    }
}
