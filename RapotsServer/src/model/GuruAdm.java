/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import RapotsApi.OGuruAdm;
import config.Koneksi;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Owner
 */
public class GuruAdm extends UnicastRemoteObject implements OGuruAdm{
    
    private String nip;
    private String nama_guru;
    private String jenis_kelamin;
    private String alamat;
    Koneksi obj_koneksi = new Koneksi();
    
    public GuruAdm()throws Exception
    {
        super();
    }

    @Override
    public String getnip(){
        return nip;
    }

    @Override
    public void setnip(String nip){
        this.nip = nip;
    }

    @Override
    public String getnama_guru() {
        return nama_guru;
    }

    @Override
    public void setnama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    @Override
    public String getjenis_kelamin() {
        return jenis_kelamin;
    }

    @Override
    public void setjenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    @Override
    public String getalamat() {
        return alamat;
    }

    @Override
    public void setalamat(String alamat){
         this.alamat = alamat;
    }

    @Override
    public int doInsert(){
       int i = 0 ; 
        try {
            obj_koneksi.openConnection();
         String str = "insert into guru (nip,nama_guru,jenis_kelamin,alamat) values (?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, nip);
            pr.setString(2, nama_guru);
            pr.setString(3, jenis_kelamin);
            pr.setString(4, alamat);  
             i = pr.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GuruAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return i;
    }

    @Override
    public int doUpdate(){
       int i = 0;
        try
        { 
           obj_koneksi.openConnection();
           String str = "UPDATE guru SET nama_guru= ?, jenis_kelamin = ?, alamat = ? WHERE nip = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, nama_guru);
           pr.setString(2, jenis_kelamin);
           pr.setString(3, alamat);
           pr.setString(4, nip);
           pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GuruAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
       return i;
    }

    @Override
    public int doDelete() {
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str ="delete guru where nip=?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, nip);
            i = pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GuruAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public ArrayList display() {
        ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.openConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select nip,nama_guru,jenis_kelamin,alamat from guru";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setnip(rs.getString(1));
                 this.setnama_guru(rs.getString(2));
                 this.setjenis_kelamin(rs.getString(3));
                 this.setalamat(rs.getString(4));
                 
                 data.add(this.getnip());
                 data.add(this.getnama_guru());
                 data.add(this.getjenis_kelamin());
                 data.add(this.getalamat());
             }
         }
         catch(SQLException ex)
         {
             System.out.println(ex.getMessage());
         }
         return data;
    }

    @Override
    public ArrayList getRecord()  {
        ArrayList data_user = new ArrayList();
         try{
          
            obj_koneksi.openConnection();
            String sql = "select * from guru";
          PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
          pr.setString(1, nip);
          ResultSet rs = pr.executeQuery();
          while(rs.next())
          {
              
                this.setnip(rs.getString(1));
                this.setnama_guru(rs.getString(2));
                this.setjenis_kelamin(rs.getString(3));
                 this.setalamat(rs.getString(4));

                data_user.add(this.nip);
                data_user.add(this.nama_guru); 
                data_user.add(this.jenis_kelamin);
                data_user.add(this.alamat);
            }
             
         } 
         catch (SQLException ex) {
             System.out.println(ex.getMessage());
                     }
         return data_user;
    }

    @Override
    public int doLogin() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
