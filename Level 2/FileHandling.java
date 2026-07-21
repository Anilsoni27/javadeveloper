import java.io.*;

public class FileHandling {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        int lineCount = 0;
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String[] words = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            writer.write("File Analysis Result");
            writer.newLine();
            writer.write("--------------------");
            writer.newLine();
            writer.write("Total Lines: " + lineCount);
            writer.newLine();
            writer.write("Total Words: " + wordCount);

            writer.close();

            System.out.println("Processing completed successfully!");
            System.out.println("Results written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found!");
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}