import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day3.txt";

        System.out.println(partOne(filePath));
        System.out.println(partTwo(filePath));
    }

    private static String partOne(String filePath) {
        int result = 0;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));
            int size = input.size();
            int firstLength = input.getFirst().length();

            for (int i = 0; i < size; i++) {
                int j = 0;
                while (j < firstLength) {
                    if (!Character.isDigit(input.get(i).charAt(j))) {
                        j += 1;
                        continue;
                    }

                    int k = j;
                    int val = 0;

                    while (k < firstLength && Character.isDigit(input.get(i).charAt(k))) {
                        val = 10 * val + (input.get(i).charAt(k++) - '0');
                    }

                    boolean adj = false;

                    for (int a = Math.max(0, j - 1); a < Math.min(firstLength, k + 1); a++) {
                        if (i - 1 >= 0 && !Character.isDigit(input.get(i - 1).charAt(a)) && input.get(i - 1).charAt(a) != '.') {
                            adj = true;
                        }
                        if (!Character.isDigit(input.get(i).charAt(a)) && input.get(i).charAt(a) != '.') {
                            adj = true;
                        }
                        if (i + 1 < size && !Character.isDigit(input.get(i + 1).charAt(a)) && input.get(i + 1).charAt(a) != '.') {
                            adj = true;
                        }
                    }

                    if (adj) {
                        result += val;
                    }

                    j = k;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 1 - The result is: %d", result);
    }

    private static String partTwo(String filePath) {
        int result = 0;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));
            int size = input.size();
            int firstLength = input.getFirst().length();
            List<List<Integer>> adjs = new ArrayList<>();

            for (int i = 0; i < size * firstLength; i++) {
                adjs.add(new ArrayList<>());
            }

            for (int i = 0; i < size; i++) {
                int j = 0;
                while (j < firstLength) {
                    if (!Character.isDigit(input.get(i).charAt(j))) {
                        j += 1;
                        continue;
                    }

                    int k = j;
                    int val = 0;

                    while (k < firstLength && Character.isDigit(input.get(i).charAt(k))) {
                        val = 10 * val + (input.get(i).charAt(k++) - '0');
                    }

                    for (int a = Math.max(0, j - 1); a < Math.min(firstLength, k + 1); a++) {
                        if (i - 1 >= 0 && input.get(i - 1).charAt(a) == '*') {
                            adjs.get((i - 1) * firstLength + a).add(val);
                        }
                        if (input.get(i).charAt(a) == '*') {
                            adjs.get(i * firstLength + a).add(val);
                        }
                        if (i + 1 < size && input.get(i + 1).charAt(a) == '*') {
                            adjs.get((i + 1) * firstLength + a).add(val);
                        }
                    }
                    j = k;
                }
            }

            for (List<Integer> adj : adjs) {
                if (adj.size() == 2) {
                    result += adj.get(0) * adj.get(1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 2 - The result is: %d", result);
    }

}
