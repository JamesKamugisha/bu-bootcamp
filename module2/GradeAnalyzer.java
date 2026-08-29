import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    static int InvalidLines = 0;

    public static void main(String[] args) {

        ArrayList<Integer> scores = readScores("scores.txt");
        // Step 1: read scores from file

        // Step 2: calculate statistics
        // Step 3: write and print report
        int highestValue = Integer.MIN_VALUE;
        int lowestValue = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highestValue) {
                highestValue = score;
            }
            if (score < lowestValue) {
                lowestValue = score;
            }
        }
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        double average = calculateAverage(scores);
        writeReport(scores, average, highestValue, lowestValue, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                if (trimmed.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(trimmed);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    InvalidLines++;
                    System.out.println("Warning: skipped an invalid line: " + trimmed);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        return (double) total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile) {
        // your code here

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("=== Grade Analysis Report ===");
            writer.newLine();
            System.out.println("=== Grade Analysis Report ===");

            writer.write(String.format("Total scores processed: %d", scores.size()));
            writer.newLine();
            System.out.println(String.format("Total scores processed: %d", scores.size()));

            writer.write(String.format("Invalid lines skipped: %d", InvalidLines));
            writer.newLine();
            System.out.println(String.format("Invalid lines skipped: %d", InvalidLines));

            writer.write(String.format("Average score: %.2f", avg));
            writer.newLine();
            System.out.println(String.format("Average score: %.2f", avg));

            writer.write(String.format("Highest score: %d", high));
            writer.newLine();
            System.out.println(String.format("Highest score: %d", high));

            writer.write(String.format("Lowest score: %d", low));
            writer.newLine();
            System.out.println(String.format("Lowest score: %d", low));

            writer.write("Grade distribution:");
            writer.newLine();
            System.out.println("Grade distribution:");

            writer.write(String.format(" A(90-100): %d", countA));
            writer.newLine();
            System.out.println(String.format(" A(90-100): %d", countA));

            writer.write(String.format(" B(80-89): %d", countB));
            writer.newLine();
            System.out.println(String.format(" B(80-89): %d", countB));

            writer.write(String.format(" C(70-79): %d", countC));
            writer.newLine();
            System.out.println(String.format(" C(70-79): %d", countC));

            writer.write(String.format(" D(60-69): %d", countD));
            writer.newLine();
            System.out.println(String.format(" D(60-69): %d", countD));

            writer.write(String.format(" F(<60): %d", countF));
            writer.newLine();
            System.out.println(String.format(" F(<60): %d", countF));

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}