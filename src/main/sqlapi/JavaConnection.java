import java.sql.*;

public class JavaConnection
{
  public static void main(String[] args)
  {
    try
    {
      Connection sqlCon = DriverManager.getConnection("jdbc:sqlserver://localhost:1433/SaferRideSQL" , "sa" , "asdfghjkl2");
      //Statement statement = sqlCon.createStatement();
      
      sqlCon.close();
    }
    catch(Exception ex)
    {
      System.out.println(ex);
    }
  }
}
