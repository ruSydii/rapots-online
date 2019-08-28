/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import RapotsApi.OKelasAdm;

/**
 *
 * @author Owner
 */
public class KelasAdm extends UnicastRemoteObject implements OKelasAdm{

    private String Kode_Kelas, Kelas;
    private Koneksi obj_koneksi = new Koneksi();
    public KelasAdm() throws Exception
    {
        super();
    }
    
    @Override
    public String getKode_Kelas(){
        return Kode_Kelas;
    }

    @Override
    public void setKode_Kelas(String Kode_Kelas){
       this.Kode_Kelas = Kode_Kelas;
    }

    @Override
    public String getKelas(){
       return Kelas;
    }

    @Override
    public void setKelas(String Kelas){
        this.Kelas = Kelas;
    }
    
    public Koneksi getObj_koneksi() {
        return obj_koneksi;
    }

    public void setObj_koneksi(Koneksi obj_koneksi) {
        this.obj_koneksi = obj_koneksi;
    }

    @Override
    public int doInsert(){
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "insert into Kelas(kode_kelas,kelas) values(?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Kode_Kelas);
            pr.setString(2, Kelas);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    @Override
    public int doUpdate(){
         int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "update Kelas set kelas = ? where kode_kelas = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Kelas);
            pr.setString(2, Kode_Kelas);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    @Override
    public int doDelete(){
       int i = 0 ;
        try
        {
           obj_koneksi.openConnection();
           String str = "delete Kelas where kode_kelas = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, Kode_Kelas);
           i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }

    @Override
    public ArrayList display(){
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            Statement stmt = obj_koneksi.con.createStatement();
            String str = "select kode_kelas, kelas from Kelas";
            ResultSet rs = stmt.executeQuery(str);
            while(rs.next())
            {
                this.setKode_Kelas(rs.getString(1));
                this.setKelas(rs.getString(2));
                
                data.add(this.getKode_Kelas());
                data.add(this.getKelas());
                
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public ArrayList getRecord(){
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            String str = "select * from kelas where kode_kelas = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Kode_Kelas);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setKode_Kelas(rs.getString(1));
                this.setKelas(rs.getString(2));
                
                data.add(this.getKode_Kelas());
                data.add(this.getKelas());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    
}
