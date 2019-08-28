/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import RapotsApi.ONilaiAdm;
import RapotsApi.OPivotAdm;
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
public class NilaiAdm extends UnicastRemoteObject implements ONilaiAdm{
    
    private String NIS;
    private String Kode_Pelajaran;
    private String Kode_Kelas;
    private String Id_Pivot;
    private String Tahun_Ajaran;
    private String Nilai_Harian;
    private String Nilai_UTS;
    private String Nilai_UAS;
    Koneksi obj_koneksi = new Koneksi();
    
    
    public NilaiAdm()throws Exception
    {
        super();
    }

    @Override
    public String getNIS() {
        return NIS;
    }

    @Override
    public void setNIS(String NIS){
        this.NIS = NIS;
    }

    @Override
    public String getKode_Pelajaran(){
        return Kode_Pelajaran;
    }

    @Override
    public void setKode_Pelajaran(String Kode_Pelajaran) {
        this.Kode_Pelajaran = Kode_Pelajaran;
    }

    @Override
    public String getKode_Kelas() {
        return Kode_Kelas;
    }

    @Override
    public void setKode_Kelas(String Kode_Kelas){
        this.Kode_Kelas = Kode_Kelas;
    }

    @Override
    public String getId_Pivot() {
        return Id_Pivot;
    }

    @Override
    public void setId_Pivot(String Id_Pivot) {
        this.Id_Pivot = Id_Pivot;
    }

    @Override
    public String getTahun_Ajaran(){
       return Tahun_Ajaran;
    }

    @Override
    public void setTahun_Ajaran(String Tahun_Ajaran){
        this.Tahun_Ajaran = Tahun_Ajaran;
    }

    @Override
    public String getNilai_Harian(){
        return Nilai_Harian;
    }

    @Override
    public void setNilai_Harian(String Nilai_Harian){
        this.Nilai_Harian = Nilai_Harian;
    }

    @Override
    public String getNilai_UTS() {
        return Nilai_UTS;
    }

    @Override
    public void setNilai_UTS(String Nilai_UTS){
        this.Nilai_UTS = Nilai_UTS;
    }

    @Override
    public String getNilai_UAS(){
       return Nilai_UAS;
    }

    @Override
    public void setNilai_UAS(String Nilai_UAS) {
        this.Nilai_UAS = Nilai_UAS;
    }

    @Override
    public int doInsert(){
        int i = 0 ; 
        try {
            obj_koneksi.openConnection();
         String str = "insert into nilai (nis,kode_pelajaran,kode_kelas,id_pivot,tahun_ajaran,nilai_harian,nilai_UTS,nilai_UAS) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, NIS);
            pr.setString(2, Kode_Pelajaran);
            pr.setString(3, Kode_Kelas);
            pr.setString(4, Id_Pivot);  
            pr.setString(5, Tahun_Ajaran);
            pr.setString(6, Nilai_Harian); 
            pr.setString(7, Nilai_UTS);
            pr.setString(8, Nilai_UAS);
             i = pr.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(NilaiAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return i;
    }

    @Override
    public int doUpdate() {
       int i = 0;
        try
        { 
           obj_koneksi.openConnection();
           String str = "UPDATE nilai SET kode_pelajaran = ?, kode_kelas = ?, id_pivot = ?, tahun_ajaran = ?, nilai_harian = ?, nilai_UTS = ?, nilai_UAS WHERE nis = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, Kode_Pelajaran);
           pr.setString(2, Kode_Kelas);
           pr.setString(3, Id_Pivot);
           pr.setString(4, Tahun_Ajaran);
           pr.setString(5, Nilai_Harian);
           pr.setString(4, Nilai_UTS);
           pr.setString(5, Nilai_UAS);
           pr.setString(6, NIS);
           pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NilaiAdm.class.getName()).log(Level.SEVERE, null, ex);
        }
       return i;
    }

    @Override
    public int doDelete(){
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str ="Delete nilai where nis=?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, NIS);
            i = pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NilaiAdm.class.getName()).log(Level.SEVERE, null, ex);
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
             String str = "select nis,kode_pelajaran,kode_kelas,id_pivot,tahun_ajaran,nilai_harian,nilai_UTS,nilai_UAS from nilai";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setNIS(rs.getString(1));
                 this.setKode_Pelajaran(rs.getString(2));
                 this.setKode_Kelas(rs.getString(3));
                 this.setId_Pivot(rs.getString(4));
                 this.setTahun_Ajaran(rs.getString(5));
                 this.setNilai_Harian(rs.getString(6));
                 this.setNilai_UTS(rs.getString(7));
                 this.setNilai_UAS(rs.getString(8));
                 
                 data.add(this.getNIS());
                 data.add(this.getKode_Pelajaran());
                 data.add(this.getKode_Kelas());
                 data.add(this.getId_Pivot());
                 data.add(this.getTahun_Ajaran());
                 data.add(this.getNilai_Harian());
                 data.add(this.getNilai_UTS());
                 data.add(this.getNilai_UAS());
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
        ArrayList data_user = new ArrayList();
         try{
          
            obj_koneksi.openConnection();
            String sql = "select * from nilai";
          PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
          pr.setString(1, NIS);
          ResultSet rs = pr.executeQuery();
          while(rs.next())
          {
              
                this.setNIS(rs.getString(1));
                 this.setKode_Pelajaran(rs.getString(2));
                 this.setKode_Kelas(rs.getString(3));
                 this.setId_Pivot(rs.getString(4));
                 this.setTahun_Ajaran(rs.getString(5));
                 this.setNilai_Harian(rs.getString(6));
                 this.setNilai_UTS(rs.getString(7));
                 this.setNilai_UAS(rs.getString(8));

                 data_user.add(this.getNIS());
                 data_user.add(this.getKode_Pelajaran());
                 data_user.add(this.getKode_Kelas());
                 data_user.add(this.getId_Pivot());
                 data_user.add(this.getTahun_Ajaran());
                 data_user.add(this.getNilai_Harian());
                 data_user.add(this.getNilai_UTS());
                 data_user.add(this.getNilai_UAS());
                 
            }
             
         } 
         catch (SQLException ex) {
             System.out.println(ex.getMessage());
                     }
         return data_user;
    }
    
}
