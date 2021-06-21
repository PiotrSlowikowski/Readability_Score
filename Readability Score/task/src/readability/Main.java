package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.appInit();


    }

    private void appInit() {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int averageWordsQuantity = countWordsInSentenceAverage(text);
        System.out.println(estimateLevel(averageWordsQuantity));

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
