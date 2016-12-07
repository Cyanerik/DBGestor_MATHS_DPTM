package db_gestor_gui;

import auxPackage.Definitions;
import database_package.*;

import javax.swing.*;


public class DBGTable extends JTable{
    
    private String[] columnNames;
    private int sizeNames;
    
    private Object[][] data;

    
    
    public DBGTable()
    {
        super.setFillsViewportHeight(true);
    }
    
    public DBGTable(int data)
    {
        super.setFillsViewportHeight(true);
        switch(data)
        {
            case(Definitions.DBG_FAMILY_DATA):
            {
                 fill(new String[]{"id", "name", "surname", "e_mail", "country", "university"}, "family", "");
            }break;
            case(Definitions.DBG_JOURNAL_DATA):
            {
               // fill("");  
            }break;
            default:{}break;
        }
    }
    
    public void fill(String[] fields, String from, String where)
    {
        dbDriver.getInstance().executeSelect(fields, from, where);
    }
}
