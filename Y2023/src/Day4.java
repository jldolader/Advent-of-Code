import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day3.txt";

        System.out.println(partOne(filePath));
        System.out.println(partTwo(filePath));
    }

    private static String partOne(String filePath) {
        int result = 0;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 1 - The result is: %d", result);
    }

    private static String partTwo(String filePath) {
        int result = 0;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 2 - The result is: %d", result);
    }

}
