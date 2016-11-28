package db_gestor;

import database_package.*;
import java.sql.ResultSet;

/**
 *
 * @author Erik Tordera Bermejo (@Cyanerik on GitHub @Cianerik on twitter)
 */
public class DB_GESTOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dbDriver driver = dbDriver.getInstance();
        ResultSet testSet = driver.exectuteStatement("SELECT * FROM family;");
        if(testSet != null)
        {
            try{
                while(testSet.next())
                {
                    System.out.println(testSet.getString("name") + "          " + testSet.getString("surname") + "\n");
                }
            }catch(Exception e){}
        }
        
    }
    
}
