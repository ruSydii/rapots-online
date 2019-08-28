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
public interface OSiswaAdm extends Remote{
    public String getNIS() throws RemoteException;;
    public void setNIS(String NIS) throws RemoteException;;
    public String getNama_Siswa() throws RemoteException;;
    public void setNama_Siswa(String Nama_Siswa) throws RemoteException;;  
    public String getAlamat() throws RemoteException;;
    public void setAlamat(String Alamat) throws RemoteException;; 
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
}
