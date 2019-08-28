/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.server.UnicastRemoteObject;
import config.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import RapotsApi.OLoginAdm;

/**
 *
 * @author Owner
 */
public class LoginAdm extends UnicastRemoteObject implements OLoginAdm{

         Koneksi obj_koneksi = new Koneksi();
    
    
    public LoginAdm() throws RemoteException
   {
       super();
   }
    
    @Override
    public boolean Loginguru(String ussername, String passwords) 
    {
        try
        {
            obj_koneksi.openConnection();
            String query = "Select ussername,passwords from logins where ussername = ? and  passwords=? ";
            PreparedStatement pre = obj_koneksi.con.prepareStatement(query);
            pre.setString(1, ussername);
            pre.setString(2, passwords);
            ResultSet res = pre.executeQuery();
           if (res.next())
           {
               return true;
           }
           else
           {
               return false;
           }           
        } 
         catch (Exception e) 
       {
           JOptionPane.showMessageDialog(null, "Error: "+e);
       }
        
        return false;
    }
}
    
    

