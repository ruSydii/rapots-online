/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import RapotsApi.Ipivot;
import RapotsApi.PivotClass;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Owner
 */
public class pivot  extends UnicastRemoteObject implements Ipivot{

    Koneksi obj_koneksi = new Koneksi();
    
     public pivot() throws RemoteException {};
   
    
    @Override
    public void setPivot(PivotClass pivot) throws RemoteException {
        try
        {
            obj_koneksi.openConnection();
            PreparedStatement ps = obj_koneksi.con.prepareStatement("select count(*) from pivot_kelas where nis = ?");
            ResultSet rs = ps.executeQuery();
            if(rs.getInt(1) > 0)
                return;
            else
            {
                rs.close();
                ps = obj_koneksi.con.prepareStatement("insert into pivot_kelas values (?, ?, ?, ?, ?, ?)");
                ps.setString(1, pivot.getIdPivot());
                ps.setString(2, pivot.getKodeKelas());
                ps.setString(3, pivot.getNis());
                ps.setString(4, pivot.getTahun_ajaran());
                ps.setString(5, pivot.getKeterangan());
                ps.setString(6, pivot.getRataRata());
                ps.execute();
            
            }
        }
        catch(Exception ex)
        {
            System.out.println("Ada kesalahan dalam set pivot di server:\n" + ex.toString());
        }
    }
    @Override
    public PivotClass getPivot(String nis) throws RemoteException {
     
         try
        {
            obj_koneksi.openConnection();
            PreparedStatement ps = obj_koneksi.con.prepareStatement("select * from pivot_kelas where nis=?");
            ps.setString(1, nis);
            ResultSet rs = ps.executeQuery();
            Boolean ada = rs.next();
            if(ada)
            {
                PivotClass pivotClass = new PivotClass(rs.getString(1), rs.getString(2), 
                    rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                return pivotClass;
            }  
            
            else
            {
                  return null;
                /*  rs.close();
                ps = obj_koneksi.con.prepareStatement("select * from nilai where nis=?");
                ps.setString(1, nis);
                rs = ps.executeQuery();
                ada = rs.next();
                if(ada)
                {
                    int rataRata = (rs.getInt("nilai_harian") + rs.getInt("nilai_UAS") + rs.getInt("nilai_UTS")) / 3;
                    PivotClass pivotClass = new PivotClass(rs.getString(1), rs.getString(2), 
                        rs.getString(3), rs.getString(4), rs.getString(5));
                    return pivotClass;
                }
                else
                {
                    
                }
                //return null;*/
            }
        
        }
        catch(Exception ex)
        {
            System.out.println("Ada kesalahan dalam get pivot di server:\n" + ex.toString());
            return null;
        }
    }
    
    
    
}
