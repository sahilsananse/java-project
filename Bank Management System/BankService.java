import java.sql.*;

public class BankService {

    Connection con = DBConnection.getConnection();

    public void createAccount(String name, String mobile, double balance) {

        try {

            String sql = "insert into accounts(name,mobile,balance) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setDouble(3, balance);

            ps.executeUpdate();

            System.out.println("Account Created Successfully.");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void deposit(int accountNo, double amount) {

        try {

            String sql = "update accounts set balance=balance+? where account_no=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accountNo);

            ps.executeUpdate();

            addTransaction(accountNo, "Deposit", amount);

            System.out.println("Money Deposited.");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void withdraw(int accountNo, double amount) {

        try {

            String check = "select balance from accounts where account_no=?";

            PreparedStatement ps = con.prepareStatement(check);

            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double bal = rs.getDouble("balance");

                if (bal >= amount) {

                    String sql = "update accounts set balance=balance-? where account_no=?";

                    PreparedStatement ps2 = con.prepareStatement(sql);

                    ps2.setDouble(1, amount);

                    ps2.setInt(2, accountNo);

                    ps2.executeUpdate();

                    addTransaction(accountNo, "Withdraw", amount);

                    System.out.println("Money Withdrawn");

                } else {

                    System.out.println("Insufficient Balance");

                }

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void balance(int accountNo) {

        try {

            String sql = "select * from accounts where account_no=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Account : " + rs.getInt("account_no"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Balance : " + rs.getDouble("balance"));

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void history(int accountNo) {

        try {

            String sql = "select * from transactions where account_no=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountNo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("type") + "  " +
                                rs.getDouble("amount") + "  " +
                                rs.getTimestamp("date"));

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    private void addTransaction(int accountNo, String type, double amount) {

        try {

            String sql = "insert into transactions(account_no,type,amount) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountNo);

            ps.setString(2, type);

            ps.setDouble(3, amount);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
