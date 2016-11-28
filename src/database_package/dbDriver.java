package database_package;
import java.sql.*;


public class dbDriver {
    
    private static final dbDriver instance = new dbDriver();
    private Connection connection;
    
    ////////////////////////////////
    public static dbDriver getInstance()
    {
        return instance;
    }
    public ResultSet exectuteStatement(String statement)
    {
        try{
         Statement stat = connection.createStatement();
         ResultSet toRet = stat.executeQuery(statement);
         return toRet;
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private dbDriver()
    {
        try
        {
            String url = "jdbc:mysql://localhost:3306/journal_db";
            String user = "database_controller";
            String password = "12qwerty";
            connection = DriverManager.getConnection(url, user, password);
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
}
/*
Connection conn;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/journal_db" + "user=database_controller&password=12qwerty");
            Statement ste = conn.createStatement();
            ResultSet rs = ste.executeQuery("SHOW VARIABLES;");
            while(rs.next())
            {
                System.out.println(rs.getString("Variable_name") + "          " + rs.getString("Value") + "\n");
            }
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
*/
