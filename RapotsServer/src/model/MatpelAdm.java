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
import RapotsApi.OMatpelAdm;
/**
 *
 * @author Owner
 */
public class MatpelAdm extends UnicastRemoteObject implements OMatpelAdm{
    
    private String Kode_Pelajaran, NIP, Nama_Pelajaran;
    private Koneksi obj_koneksi = new Koneksi();
    public MatpelAdm() throws Exception
    {
        super();
    }

    @Override
    public String getKode_Pelajaran(){
        return Kode_Pelajaran;
    }

    @Override
    public void setKode_Pelajaran(String Kode_Pelajaran){
        this.Kode_Pelajaran = Kode_Pelajaran;
    }

    @Override
    public String getNIP() {
        return NIP;
    }

    @Override
    public void setNIP(String NIP){
        this.NIP = NIP;
    }

    @Override
    public String getNama_Pelajaran(){
        return Nama_Pelajaran;
    }

    @Override
    public void setNama_Pelajaran(String Nama_Pelajaran) {
       this.Nama_Pelajaran = Nama_Pelajaran;
    }

    @Override
    public int doInsert() {
       int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "insert into mapel(kode_pelajaran,nip,nama_pelajaran) values(?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Kode_Pelajaran);
            pr.setString(2, NIP);
            pr.setString(3, Nama_Pelajaran);
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
            String str = "update mapel set nip = ?, nama_pelajaran = ? where kode_pelajaran = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, NIP);
            pr.setString(2, Nama_Pelajaran);
            pr.setString(3, Kode_Pelajaran);
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
           String str = "delete mapel where kode_pelajaran = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, Kode_Pelajaran);
           i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
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
            String str = "select kode_pelajaran, nip, nama_pelajaran from mapel";
            ResultSet rs = stmt.executeQuery(str);
            while(rs.next())
            {
                this.setKode_Pelajaran(rs.getString(1));
                this.setNIP(rs.getString(2));
                this.setNama_Pelajaran(rs.getString(3));
                
                data.add(this.getKode_Pelajaran());
                data.add(this.getNIP());
                data.add(this.getNama_Pelajaran());
                
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    @Override
    public ArrayList getRecord() {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            String str = "select * from mapel where kode_pelajaran = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Kode_Pelajaran);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setKode_Pelajaran(rs.getString(1));
                this.setNIP(rs.getString(2));
                this.setNama_Pelajaran(rs.getString(3));
                
                data.add(this.getKode_Pelajaran());
                data.add(this.getNIP());
                data.add(this.getNama_Pelajaran());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    
}
