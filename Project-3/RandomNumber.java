import java.util.Scanner;

class RandomNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        {
            int MyNumber = (int) (Math.random() * 100);
            // System.out.println(MyNumber);
            int UserNumber = 0;
            do {
                System.out.println("guess the number between 1 to 100 : ");
                int userNumber = sc.nextInt();
                if (userNumber > MyNumber) {
                    System.out.println("Your number is large");
                } else if (userNumber < MyNumber) {
                    System.out.println("your number is small");
                } else {
                    System.out.println("congratulations! you guessed the number");
                    break;
                }
            } while (true);
        }

    }
}
