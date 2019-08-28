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
import RapotsApi.OSiswaAdm;

/**
 *
 * @author Owner
 */
public class SiswaAdm extends UnicastRemoteObject implements OSiswaAdm{
    private String NIS, Nama_Siswa, Alamat;
    private Koneksi obj_koneksi = new Koneksi();
    public SiswaAdm() throws Exception
    {
        super();
    }
    public String getNIS() {
        return NIS;
    }
    
    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

    public String getNama_Siswa() {
        return Nama_Siswa;
    }

    public void setNama_Siswa(String Nama_Siswa) {
        this.Nama_Siswa = Nama_Siswa;
    }
    public String getAlamat(){
        return Alamat;
    }
    public void setAlamat(String Alamat){
        this.Alamat = Alamat;
    }

    public Koneksi getObj_koneksi() {
        return obj_koneksi;
    }

    public void setObj_koneksi(Koneksi obj_koneksi) {
        this.obj_koneksi = obj_koneksi;
    }
    public int doInsert()
    {
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str = "insert into siswa(nis,nama_siswa,alamat) values(?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, NIS);
            pr.setString(2, Nama_Siswa);
            pr.setString(3, Alamat);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public int doUpdate() throws RemoteException
    {
        int i = 0;
        try
        {
            //Jika Menggunakan Statement Baiasa
            /*obj_koneksi.openConnection();
            String str = "update siswa set nama_siswa ='"+ Nama_Siswa + "', Alamat ='" + Alamat + "' where nis ='"+ NIS + "'";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Nama_Siswa);
            pr.setString(2, Alamat);
            pr.setString(3, NIS);
            i = pr.executeUpdate();*/
            
            obj_koneksi.openConnection();
            String str = "update siswa set nama_siswa = ?, Alamat = ? where nis = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Nama_Siswa);
            pr.setString(2, Alamat);
            pr.setString(3, NIS);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public int doDelete()
    {
        int i = 0 ;
        try
        {
           obj_koneksi.openConnection();
           String str = "delete siswa where nis = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, NIS);
           i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public ArrayList display()
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            Statement stmt = obj_koneksi.con.createStatement();
            String str = "select nis, nama_siswa, alamat from siswa";
            ResultSet rs = stmt.executeQuery(str);
            while(rs.next())
            {
                this.setNIS(rs.getString(1));
                this.setNama_Siswa(rs.getString(2));
                this.setAlamat(rs.getString(3));
                data.add(this.getNIS());
                data.add(this.getNama_Siswa());
                data.add(this.getAlamat());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    
    public ArrayList getRecord()
    {
        ArrayList data = new ArrayList();
        try
        {
            obj_koneksi.openConnection();
            String str = "select * from siswa where nis = ?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, NIS);
            ResultSet rs = pr.executeQuery();
            while(rs.next())
            {
                this.setNIS(rs.getString(1));
                this.setNama_Siswa(rs.getString(2));
                this.setAlamat(rs.getString(3));
                data.add(this.getNIS());
                data.add(this.getNama_Siswa());
                data.add(this.getAlamat());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    
    
}
   

