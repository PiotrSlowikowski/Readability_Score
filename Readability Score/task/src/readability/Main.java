package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
//        String argument = args[0];

        main.appInit();
    }

    private void appInit() {
        Main main = new Main();
        String fileContent = main.getText();
        printStatistics(fileContent);
    }

    private String getText() {
        String pathToFile = "C:\\Users\\Piotrek\\Desktop\\Nowy folder\\Java1modul\\Readability Score\\Readability Score\\task\\src\\readability\\in.txt";
        File file = new File(pathToFile);
        String text = "";

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                text = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + pathToFile);
        }
        return text;
    }

    private void printStatistics(String text) {
        Main main = new Main();
        System.out.println("The text is:\n" + text);
//        Quantities
        double charactersQuantity = text.replaceAll("\\s", "").length();
        double wordsQuantity = text.split("\\s+").length;
        double sentencesQuantity = text.split("[!?.]").length;
        double score = main.calculateScore(charactersQuantity, wordsQuantity, sentencesQuantity);
        double syllablesQuantity = text.split("[aeiouyAEIOUY]+").length;
        System.out.format("\nWords: %d%nSentences: %d%nCharacters: %d%nSyllables:%d%nThe score is: %.2f%n", (int) wordsQuantity, (int) sentencesQuantity, (int) charactersQuantity, (int) syllablesQuantity, score);
        printGradeLevel(score);
    }

    private void printGradeLevel(double score) {

        int value = (int) Math.ceil(score);

        List<String> list = List.of("5-6", "6-7", "7-9", "9-10", "10-11", "11-12",
                "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+");
        System.out.println("This text should be understood by " + list.get(value - 1) + " years olds.");
    }

    private double calculateScore(double charactersQuantity, double wordsQuantity, double sentencesQuantity) {
        return 4.71 * (charactersQuantity / wordsQuantity) + 0.5 * (wordsQuantity / sentencesQuantity) - 21.43;
    }

}
