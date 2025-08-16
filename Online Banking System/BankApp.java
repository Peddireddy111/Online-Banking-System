import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to Online Banking System ===");

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // register user
                    break;
                case 2:
                    // login + show menu (deposit, withdraw, balance, txn history)
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
