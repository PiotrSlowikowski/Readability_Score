package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        String pathToFile = "C:\\Users\\Piotrek\\Desktop\\Nowy folder\\Java1modul\\Readability Score\\Readability Score\\task\\src\\readability\\" + args[0];
        main.appInit(pathToFile);


    }

    private void appInit(String pathToFile) {
        Main main = new Main();
        String fileContent = main.getText(pathToFile);
        printStatistics(fileContent);

    }

    private String getText(String pathToFile) {
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
        double charactersQuantity = main.countCharacters(text);
        double wordsQuantity = main.countWords(text);
        double sentencesQuantity = main.countSentences(text);
        double score = main.calculateScore(charactersQuantity, wordsQuantity, sentencesQuantity);
        System.out.println();
        System.out.println("Words: " + (int) wordsQuantity);
        System.out.println("Sentences: " + (int) sentencesQuantity);
        System.out.println("Characters: " + (int) charactersQuantity);
        System.out.format("The score is: %.2f", score);
        System.out.println();
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

    private double countCharacters(String text) {
        int charactersQuantity = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                charactersQuantity++;
            }
        }
        return charactersQuantity;
    }

    private double countSentences(String text) {
        return text.split("[!?.]").length;
    }

    private double countWords(String text) {
        return text.split(" ").length;
    }


    private String estimateLevel(int averageWordsQuantity) {
        if (averageWordsQuantity <= 10) {
            return "EASY";
        } else {
            return "HARD";
        }
    }


}
