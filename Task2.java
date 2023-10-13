import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many Subjects you have? ");
        int sub = input.nextInt();
        int marks;
        double total = 0;
        System.out.println("Enter each subject marks out of 100: ");
        for (int i = 0; i < sub; i++) {
            marks = input.nextInt();
            if (marks < 0 || marks > 100) {
                while (marks > 100 || marks < 0) {
                    System.out.println("Enter marks only in range 0 to 100");
                    marks = input.nextInt();
                }
            }
            total = total + marks;
        }
        int TotalSubjectsMarks = sub * 100;
        double average = (total / TotalSubjectsMarks) * 100;
        System.out.println("Your Total marks: " + total + "\nAverage percentage is: " + average);

        if (average >= 90) {
            System.out.println("Your Grade is: A");
        } else if (average >= 80 && average < 90) {
            System.out.println("Your Grade is: B");
        } else if (average >= 70 && average < 80) {
            System.out.println("Your Grade is: C");
        } else if (average >= 60 && average < 70) {
            System.out.println("Your Grade is: D");
        } else if (average >= 50 && average < 60) {
            System.out.println("Your Grade is: E");
        } else {
            System.out.println("Your Grade is: F");
        }
    }
}
