import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Enter 'text' to enter text or 'file' to provide a file path:");
        String inputChoice = scanner.nextLine();

        if (inputChoice.equalsIgnoreCase("text")) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (inputChoice.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            System.out.println("Invalid input choice.");
            return;
        }

        // Split text into words
        String[] words = text.split("[\\s,.!?]+");
        int wordCount = words.length;

        System.out.println("Total word count: " + wordCount);

        scanner.close();
    }
}