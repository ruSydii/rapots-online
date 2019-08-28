/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import RapotsApi.Inilai;
import RapotsApi.PivotClass;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class nilai extends UnicastRemoteObject implements Inilai{

   private int nis;
    private String kode_pelajaran;
    private String kode_kelas;
    private String id_pivot;
    private String tahun_ajaran;
    private int nilai_harian;
    private int nilai_UTS;
    private int nilai_UAS;
    Koneksi obj_koneksi = new Koneksi();
    ArrayList search = new ArrayList();
    ArrayList arjad = new ArrayList();
    
    public nilai ()throws Exception
    {
        super();
    }
 
    @Override
    public void setnis(int nis) 
    {
        this.nis = nis;
    }

    @Override
    public int getnis() 
    {
       return nis;
    }

    @Override
    public void setkode_pelajaran(String kode_pelajaran) 
    {
        this.kode_pelajaran = kode_pelajaran;
    }

    @Override
    public String getkode_pelajaran() 
    {
        return kode_pelajaran;
    }
    @Override
    public void setkode_kelas(String kode_kelas) 
    {
        this.kode_kelas = kode_kelas;
    }
    @Override
    public String getkode_kelas()
    {
        return kode_kelas;
    }
    
    @Override
    public void setid_pivot(String id_pivot) 
    {
        this.id_pivot = id_pivot;
    }
    @Override
    public String getid_pivot() 
    {
        return id_pivot;
    }

    @Override
    public void settahun_ajaran(String tahun_ajaran) 
    {
        this.tahun_ajaran = tahun_ajaran;
    }

    @Override
    public String gettahun_ajaran() 
    {
        return tahun_ajaran;
    }

    @Override
    public void setnilai_harian(int nilai_harian)
    {
        this.nilai_harian = nilai_harian;
    }

    @Override
    public int getnilai_harian() 
    {
        return nilai_harian;
    }

    @Override
    public void setnilai_UTS(int nilai_UTS) 
    {
        this.nilai_UTS = nilai_UTS;
    }

    @Override
    public int getnilai_UTS() 
    {
        return nilai_UTS;
    }

    @Override
    public void setnilai_UAS(int nilai_UAS)
    {
        this.nilai_UAS = nilai_UAS;
    }

    @Override
    public int getnilai_UAS() throws Exception
    {
        return nilai_UAS;
    }

     @Override
    public ArrayList<String> search(int nis) throws RemoteException {
        ArrayList<String> hasil = new ArrayList<String>();
        try
        {
           obj_koneksi.openConnection();
           
            String query = "select nis,kode_pelajaran,kode_kelas,id_pivot,tahun_ajaran,nilai_harian,nilai_UTS,nilai_UAS from nilai where nis = ?";
            PreparedStatement pre = obj_koneksi.con.prepareCall(query);
            pre.setInt(1, nis);
            
            //Get Data
            ResultSet res = pre.executeQuery();
            while(res.next())
            {
                
                nis= Integer.parseInt(res.getString(1));
                kode_pelajaran = res.getString(2);
                kode_kelas = res.getString(3);
                id_pivot= res.getString(4);
                tahun_ajaran = res.getString(5);
                nilai_harian = Integer.parseInt(res.getString(6));
                nilai_UTS =Integer.parseInt(res.getString(7));
                nilai_UAS = Integer.parseInt(res.getString(8));
                
                hasil.add(kode_pelajaran);
                hasil.add(kode_kelas);
                hasil.add(id_pivot);
                hasil.add(tahun_ajaran);
                hasil.add(String.valueOf(nilai_harian));
                hasil.add(String.valueOf(nilai_UTS));
                hasil.add(String.valueOf(nilai_UAS));

                for(int i = 0; i < arjad.size(); i++)
                {
                    System.out.println("Data NIS didapat: " + arjad.get(i).toString());
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Ada kesalahan dalam dapat nis di server: " + ex.toString());
        }
        
        System.out.println("ajkdsdlsad");
        return hasil;
    }
    
    
}
