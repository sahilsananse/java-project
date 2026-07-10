import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankService bank = new BankService();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:

                    sc.nextLine();

                    System.out.print("Name : ");

                    String name = sc.nextLine();

                    System.out.print("Mobile : ");

                    String mobile = sc.nextLine();

                    System.out.print("Opening Balance : ");

                    double bal = sc.nextDouble();

                    bank.createAccount(name, mobile, bal);

                    break;

                case 2:

                    System.out.print("Account No : ");

                    int a1 = sc.nextInt();

                    System.out.print("Amount : ");

                    double d = sc.nextDouble();

                    bank.deposit(a1, d);

                    break;

                case 3:

                    System.out.print("Account No : ");

                    int a2 = sc.nextInt();

                    System.out.print("Amount : ");

                    double w = sc.nextDouble();

                    bank.withdraw(a2, w);

                    break;

                case 4:

                    System.out.print("Account No : ");

                    int a3 = sc.nextInt();

                    bank.balance(a3);

                    break;

                case 5:

                    System.out.print("Account No : ");

                    int a4 = sc.nextInt();

                    bank.history(a4);

                    break;

                case 6:

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }

}
