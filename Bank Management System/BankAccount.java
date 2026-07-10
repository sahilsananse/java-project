public class BankAccount {

    private int accountNo;
    private String name;
    private String mobile;
    private double balance;

    public BankAccount(int accountNo, String name, String mobile, double balance) {

        this.accountNo = accountNo;
        this.name = name;
        this.mobile = mobile;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public double getBalance() {
        return balance;
    }

}
