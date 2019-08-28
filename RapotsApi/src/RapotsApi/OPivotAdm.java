/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RapotsApi;

/**
 *
 * @author Owner
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public interface OPivotAdm extends Remote{
    public String getId_Pivot() throws RemoteException;;
    public void setId_Pivot(String Id_Pivot) throws RemoteException;;
    public String getKode_Kelas() throws RemoteException;;
    public void setKode_Kelas(String Kode_Kelas) throws RemoteException;;
    public String getNIS() throws RemoteException;;
    public void setNIS(String NIS) throws RemoteException;;
    public String getTahun_Ajaran() throws RemoteException;;
    public void setTahun_Ajaran(String Tahun_Ajaran) throws RemoteException;; 
    public String getKet() throws RemoteException;;
    public void setKet(String Ket) throws RemoteException;;
    public String getRata() throws RemoteException;;
    public void setRata(String Rata) throws RemoteException;;
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    
}
