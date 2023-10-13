import java.util.Scanner;

class ATMmachine {

    account acc = new account(1200);
    int amount;
    Scanner input = new Scanner(System.in);

    public void ask() {
        System.out.println("------WELCOME TO ATM MACHINE------");
        System.out.println(
                "Press 1 to withdraw amount \nPress 2 to deposit amount \nPress 3 to checkBalance \nPress 4 to exit");
        int number;

        do {
            number = input.nextInt();
            if (number == 1) {
                System.out.println("Enter amount to withdraw");
                amount = input.nextInt();
                acc.withdraw(amount);
            } else if (number == 2) {
                System.out.println("Enter amount to deposit");
                amount = input.nextInt();
                acc.deposit(amount);
            } else if (number == 3) {
                acc.checkBalance();
            } else if (number == 4) {
                System.out.println("You exit");
                break;
            }
        } while (number != 4);

    }

}

class account {
    int balance = 1200;

    account(int amount) {
        balance = amount;
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Sorry, You cannot deposit this amount");
        } else {
            balance = balance + amount;
            System.out.println("Amount has been successfully deposited");
        }
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Sorry, you do not have enough balance");
        } else if (amount <= 0) {
            System.out.println("You cannot withdraw this amount");
        } else {
            balance = balance - amount;
            System.out.println("Amount has been successfully withdrawn");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        ATMmachine obj1 = new ATMmachine();
        obj1.ask();
    }
}
