import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day4 {

    public static void main(String[] args) {
        String filePath = "Y2023/resources/Day4.txt";

        System.out.println(partOne(filePath));
        System.out.println(partTwo(filePath));
    }

    private static String partOne(String filePath) {
        int result = 0;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));
            for (String s : input) {
                String[] l = s.split("\\s+");
                Set<Integer> winners = new HashSet<>();
                boolean isWinner = true;
                int amt = 0;
                for (int sidx = 2; sidx < l.length; sidx++) {
                    if (l[sidx].isEmpty()) {
                        continue;
                    }

                    if (l[sidx].equals("|")) {
                        isWinner = false;
                    } else {
                        if (isWinner) {
                            winners.add(Integer.parseInt(l[sidx]));
                        } else {
                            if (winners.contains(Integer.parseInt(l[sidx]))) {
                                amt++;
                            }
                        }
                    }
                }

                if (amt > 0) {
                    result += 1 << (amt - 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 1 - The result is: %d", result);
    }

    private static String partTwo(String filePath) {
        int result;

        try {
            List<String> input = Files.readAllLines(Paths.get(filePath));
            List<Integer> cards = new ArrayList<>(Collections.nCopies(input.size(), 1));

            for (int i = 0; i < input.size(); i++) {
                String str = input.get(i);
                String[] line = str.split("\\s+");
                List<Integer> winners = new ArrayList<>();
                boolean isWinner = true;
                int amt = 0;

                for (int sIndex = 2; sIndex < line.length; sIndex++) {
                    if (line[sIndex].equals("|")) {
                        isWinner = false;
                    } else {
                        if (isWinner) {
                            winners.add(Integer.parseInt(line[sIndex]));
                        } else {
                            if (winners.contains(Integer.parseInt(line[sIndex]))) {
                                amt++;
                            }
                        }
                    }
                }

                for (int j = 0; j < amt; j++) {
                    cards.set(i + j + 1, cards.get(i + j + 1) + cards.get(i));
                }
            }

            result = cards.stream().mapToInt(Integer::intValue).sum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return String.format("> PART 2 - The result is: %d", result);
    }
}
