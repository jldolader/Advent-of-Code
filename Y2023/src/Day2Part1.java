import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2Part1 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day2.txt";
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

            System.out.println("The result is: " + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
