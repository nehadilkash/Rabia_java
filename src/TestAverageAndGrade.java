import java.util.Scanner;

public class TestAverageAndGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] scores = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter " + (i + 1) + " test score ");
            scores[i] = input.nextDouble();
        }

        double avg = calcAverage(scores);
        char grade = determineGrade(avg);

    }

    public static double calcAverage(double[] scores) {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        return sum / 5;
    }


    public static char determineGrade(double avg) {
        if (avg >= 90.0) {
            return 'A';
        } else if (avg >= 80.0) {
            return 'B';
        } else if (avg >= 70.0) {
            return 'C';
        } else if (avg >= 60.0) {
            return 'D';
        } else {
            return ' ';
        }
    }

}
