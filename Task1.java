import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner inputt = new Scanner(System.in);
        Scanner inputtt = new Scanner(System.in);
        int low = 1;
        int high = 100;
        int attempts;
        int Tattempts = 0;
        int round = 0;
        boolean check = false;
        int score = 0;
        int i;
        char c = 'Y';
        while (c == 'Y' || c == 'y') {
            int rand = (int) (Math.random() * (high - low + 1) + low);
            System.out.println("Enter your guess");
            round++;
            attempts = 1;
            i = 0;
            while (i < 10) {

                int input = inputt.nextInt();
                if (input == rand) {
                    System.out.println("Congrats you have won");
                    System.out.println("Attempts you have taken in this round: " + attempts);
                    check = true;
                    Tattempts++;
                    score++;
                    break;
                } else if (input < rand) {
                    System.out.println("Your guess is too low, Try again");
                    attempts++;
                    Tattempts++;

                } else {
                    System.out.println("Your guess is too high, Try again");
                    attempts++;
                    Tattempts++;

                }
                i++;
                if (i == 10 && !check) {
                    System.out.println("You have taken all attempts,Play again");
                }

            }
            System.out.println("Do you want to play again, Type Y for yes or any other key to exit");
            String str = inputtt.nextLine();
            char ch = str.charAt(0);
            if (ch == 'Y' || ch == 'y') {
                c = ch;
            } else {
                break;
            }
        }
        System.out.println("Your score is: " + score + " \nRounds you played: " + round);
    }
}