package readability;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.appInit();

//        System.out.println("The score is: " + main.calculateScore(580,108,6));
    }

    private void appInit() {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String text = "Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure";
        main.printStatistics(text);


    }

    private void printStatistics(String text) {
        Main main = new Main();
        double charactersQuantity = main.countCharacters(text);
        double wordsQuantity = main.countWords(text);
        double sentencesQuantity = main.countSentences(text);
        double score = main.calculateScore(charactersQuantity, wordsQuantity, sentencesQuantity);
        System.out.println("Sentences: " + wordsQuantity);
        System.out.println("Characters: " + sentencesQuantity);
        System.out.println("Words: " + charactersQuantity);
        System.out.format("The score is: %.2f",score);
    }

    private double calculateScore(double charactersQuantity, double wordsQuantity, double sentencesQuantity) {
        double score = 4.71 * (charactersQuantity / wordsQuantity) + 0.5 * (wordsQuantity / sentencesQuantity) - 21.43;
        return score;
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

    private int countWordsInSentenceAverage(String text) {
        int average;
        int wordsQuantity = 0;

        String[] textSplitted = text.split("[!?.]");
        int sentencesQuantity = textSplitted.length;

        for (int i = 0; i < textSplitted.length; i++) {
            wordsQuantity += textSplitted[i].split(" ").length;
        }

        average = wordsQuantity / sentencesQuantity;
        return average;
    }


}
