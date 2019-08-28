/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
public class InPivot extends UnicastRemoteObject implements OPivotAdm{

    private String Id_Pivot;
    private String Kode_Kelas;
    private String NIS;
    private String Tahun_Ajaran;
    private String Ket;
    private String Rata;
    Koneksi obj_koneksi = new Koneksi();
    
    
    public InPivot()throws Exception
    {
        super();
    }
    @Override
    public String getId_Pivot() throws RemoteException {
        return Id_Pivot;
    }

    @Override
    public void setId_Pivot(String Id_Pivot){
        this.Id_Pivot = Id_Pivot;
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
    public String getNIS(){
       return NIS;
    }

    @Override
    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

    @Override
    public String getTahun_Ajaran() {
        return Tahun_Ajaran;
    }

    @Override
    public void setTahun_Ajaran(String Tahun_Ajaran){
        this.Tahun_Ajaran = Tahun_Ajaran;
    }

    @Override
    public String getKet() {
        return Ket;
    }

    @Override
    public void setKet(String Ket){
      this.Ket = Ket;
    }

    @Override
    public String getRata() {
        return Rata;
    }

    @Override
    public void setRata(String Rata){
        this.Rata = Rata;
    }

    @Override
    public int doInsert()  {
        int i = 0 ; 
        try {
            obj_koneksi.openConnection();
         String str = "insert into pivot_kelas(id_pivot,kode_kelas,nis,tahun_ajaran,Keterangan,rata_rata) values (?,?,?,?,?,?)";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Id_Pivot);
            pr.setString(2, Kode_Kelas);
            pr.setString(3, NIS);
            pr.setString(4, Tahun_Ajaran);  
            pr.setString(5, Ket);
            pr.setString(6, Rata); 
             i = pr.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(InPivot.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return i;
    }

    @Override
    public int doUpdate() {
        int i = 0;
        try
        { 
           obj_koneksi.openConnection();
           String str = "UPDATE pivot_kelas SET kode_kelas = ?, nis = ?, tahun_ajaran = ?, Keterangan = ?, rata_rata = ? WHERE id_pivot = ?";
           PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
           pr.setString(1, Kode_Kelas);
           pr.setString(2, NIS);
           pr.setString(3, Tahun_Ajaran);
           pr.setString(4, Ket);
           pr.setString(5, Rata);
           pr.setString(6, Id_Pivot);
           pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InPivot.class.getName()).log(Level.SEVERE, null, ex);
        }
       return i;
    }

    @Override
    public int doDelete() {
        int i = 0;
        try
        {
            obj_koneksi.openConnection();
            String str ="Delete pivot_kelas where id_pivot=?";
            PreparedStatement pr = obj_koneksi.con.prepareStatement(str);
            pr.setString(1, Id_Pivot);
            i = pr.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InPivot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    @Override
    public ArrayList display() throws RemoteException{
        ArrayList data = new ArrayList();
         try
         {
             obj_koneksi.openConnection();
             Statement stmt = obj_koneksi.con.createStatement();
             String str = "select id_pivot,kode_kelas,nis,tahun_ajaran,Keterangan,rata_rata from pivot_kelas";
             ResultSet rs = stmt.executeQuery(str);
             while(rs.next())
             {
                 this.setId_Pivot(rs.getString(1));
                 this.setKode_Kelas(rs.getString(2));
                 this.setNIS(rs.getString(3));
                 this.setTahun_Ajaran(rs.getString(4));
                 this.setKet(rs.getString(5));
                 this.setRata(rs.getString(6));
                 
                 data.add(this.getId_Pivot());
                 data.add(this.getKode_Kelas());
                 data.add(this.getNIS());
                 data.add(this.getTahun_Ajaran());
                 data.add(this.getKet());
                 data.add(this.getRata());
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
            String sql = "select * from pivot_kelas";
          PreparedStatement pr = obj_koneksi.con.prepareStatement(sql);
          pr.setString(1, Id_Pivot);
          ResultSet rs = pr.executeQuery();
          while(rs.next())
          {
              
                this.setId_Pivot(rs.getString(1));
                 this.setKode_Kelas(rs.getString(2));
                 this.setNIS(rs.getString(3));
                 this.setTahun_Ajaran(rs.getString(4));
                 this.setKet(rs.getString(5));
                 this.setRata(rs.getString(6));

                 data_user.add(this.Id_Pivot);
                data_user.add(this.Kode_Kelas); 
                data_user.add(this.NIS);
                data_user.add(this.Tahun_Ajaran);
                data_user.add(this.Ket);
                data_user.add(this.Rata);
                 
            }
             
         } 
         catch (SQLException ex) {
             System.out.println(ex.getMessage());
                     }
         return data_user;
    }
    
}
