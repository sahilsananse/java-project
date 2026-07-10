public class Transaction {

    private int id;
    private int accountNo;
    private String type;
    private double amount;

    public Transaction(int id, int accountNo, String type, double amount) {

        this.id = id;
        this.accountNo = accountNo;
        this.type = type;
        this.amount = amount;
    }

}
