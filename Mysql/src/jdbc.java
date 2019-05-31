import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "156292170");
        System.out.println(con);

        Statement stmt = con.createStatement();

        /*String sql = "insert into stu values(7,'niubi')";
        int r = stmt.executeUpdate(sql);
        System.out.println(r);
*/
        ResultSet result= stmt.executeQuery("select * from stu");
        while(result.next())
        {
            int id = result.getInt(1);
            String name = result.getString("name");
            System.out.println(id + ", "+ name);
        }

        result.close();
        stmt.close();
        con.close();
    }
}
