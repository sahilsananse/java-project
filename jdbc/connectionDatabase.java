import java.sql.*;
//*import All
public class jdbc {

    private static final String url="jdbc:mysql://localhost:3306/mydb";
    //Mysql Workbanch and click local instance Mysql and right click then copy jdbc path
    private static final String Username="root";
    private static final String password="Mysql@2026#dev";
    public static void main(String[] args)
    {
        try {
            //load Drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e)
        {
            //e.fillInStackTrace();
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url,Username,password);
            //statement interface
            Statement statement = connection.createStatement();
            String quary =" select * from students;";
            //for data retrive
            ResultSet resultSet=statement.executeQuery(quary);
            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getNString("name");
                double marks=resultSet.getDouble("marks");
                System.out.println("ID:"+id);
                System.out.println("NAME:"+name);
                System.out.println("MARKS"+marks);
            }
        }catch (SQLException e)
        {
            //e.fillInStackTrace();
            System.out.println(e.getMessage());
        }
        
    }

}
