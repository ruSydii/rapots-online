/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import config.Koneksi;
import RapotsApi.OAutoNum;

/**
 *
 * @author Owner
 */
public class AutoNum extends UnicastRemoteObject implements OAutoNum{
    private Koneksi obj_koneksi = new Koneksi();
    public AutoNum() throws Exception
    {
        super();
    }
    public String NIS()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 nis from siswa order by nis desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String NIS = null;
            String num = null;
               
            if(rs.next())
            {
                NIS = rs.getString("nis");
                System.out.println("Test: " + NIS);
                String potong = NIS.substring(4, 8); //untung memotong id
                System.out.println("Test: " + potong);
                /*String subNISString = "";
                for(int i = 0; i )*/
                int subNIS = Integer.parseInt(potong) + 1;
                 if(subNIS<10)
                {
                    num = "4816000" + Integer.toString(subNIS);
                }
                else if(subNIS<100)
                {
                    num = "481600" + Integer.toString(subNIS);
                }
                else if(subNIS<1000)
                {
                    num = "48160" + Integer.toString(subNIS);
                }
                else if(subNIS<10000)
                {
                    num = "4816" + Integer.toString(subNIS);
                }
                
            }
            else
            {
                num = "48160001";
            }
            System.out.println("Hasil: " + num);
            return num;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String Kelas()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 kode_kelas from Kelas order by kode_kelas desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String Kode_Kelas = null;
            String num = null;
               
            if(rs.next())
            {
                Kode_Kelas = rs.getString("kode_kelas");
                System.out.println("Test: " + Kode_Kelas);
                String potong = Kode_Kelas.substring(1, 4); //untung memotong id
                System.out.println("Test: " + potong);
                /*String subNISString = "";
                for(int i = 0; i )*/
                int subNIS = Integer.parseInt(potong) + 1;
                 if(subNIS<10)
                {
                    num = "K00" + Integer.toString(subNIS);
                }
                else if(subNIS<100)
                {
                    num = "K0" + Integer.toString(subNIS);
                }
                else if(subNIS<1000)
                {
                    num = "K" + Integer.toString(subNIS);
                }
                
                
            }
            else
            {
                num = "K001";
            }
            System.out.println("Hasil: " + num);
            return num;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String Pivot()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 id_pivot from pivot_kelas order by id_pivot desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String Id_Pivot = null;
            String num = null;
               
            if(rs.next())
            {
                Id_Pivot = rs.getString("id_pivot");
                System.out.println("Test: " + Id_Pivot);
                String potong = Id_Pivot.substring(1, 4); //untung memotong id
                System.out.println("Test: " + potong);
                /*String subNISString = "";
                for(int i = 0; i )*/
                int subNIS = Integer.parseInt(potong) + 1;
                 if(subNIS<10)
                {
                    num = "P00" + Integer.toString(subNIS);
                }
                else if(subNIS<100)
                {
                    num = "P0" + Integer.toString(subNIS);
                }
                else if(subNIS<1000)
                {
                    num = "P" + Integer.toString(subNIS);
                }
                
                
            }
            else
            {
                num = "P001";
            }
            System.out.println("Hasil: " + num);
            return num;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String Guru()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 NIP from guru order by NIP desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String NIP = null;
            String num = null;
               
            if(rs.next())
            {
                NIP = rs.getString("nip");
                System.out.println("Test: " + NIP);
                String potong = NIP.substring(3, 6); //untung memotong id
                System.out.println("Test: " + potong);
                /*String subNISString = "";
                for(int i = 0; i )*/
                int subNIS = Integer.parseInt(potong) + 1;
                 if(subNIS<10)
                {
                    num = "G00200" + Integer.toString(subNIS);
                }
                else if(subNIS<100)
                {
                    num = "G0020" + Integer.toString(subNIS);
                }
                else if(subNIS<1000)
                {
                    num = "G00" + Integer.toString(subNIS);
                }
                
                
            }
            else
            {
                num = "G00201";
            }
            System.out.println("Hasil: " + num);
            return num;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String Matpel()
    {
        try 
        {
            obj_koneksi.openConnection();
            
            String sql = "select top 1 kode_pelajaran from mapel order by kode_pelajaran desc";
            
            Statement state = obj_koneksi.con.createStatement(); //karna tidak memakai parameter
            ResultSet rs = state.executeQuery(sql);
            
            String Kode_Pelajaran = null;
            String num = null;
               
            if(rs.next())
            {
                Kode_Pelajaran = rs.getString("kode_pelajaran");
                System.out.println("Test: " + Kode_Pelajaran);
                String potong = Kode_Pelajaran.substring(1, 4); //untung memotong id
                System.out.println("Test: " + potong);
                /*String subNISString = "";
                for(int i = 0; i )*/
                int subNIS = Integer.parseInt(potong) + 1;
                 if(subNIS<10)
                {
                    num = "M00" + Integer.toString(subNIS);
                }
                else if(subNIS<100)
                {
                    num = "M0" + Integer.toString(subNIS);
                }
                else if(subNIS<1000)
                {
                    num = "M" + Integer.toString(subNIS);
                }
                
                
            }
            else
            {
                num = "M001";
            }
            System.out.println("Hasil: " + num);
            return num;
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            return null;
        }
    }
}
