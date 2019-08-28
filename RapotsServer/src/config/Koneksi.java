/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Owner
 */
public class Koneksi {
     public Connection con;

    //method
    public void openConnection() {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=rapot";
             con = DriverManager.getConnection(url,"sa","123456789");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
