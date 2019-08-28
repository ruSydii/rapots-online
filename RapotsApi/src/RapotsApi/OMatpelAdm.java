/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RapotsApi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public interface OMatpelAdm extends Remote{
    public String getKode_Pelajaran() throws RemoteException;;
    public void setKode_Pelajaran(String Kode_Pelajaran) throws RemoteException;;
    public String getNIP() throws RemoteException;;
    public void setNIP(String NIP) throws RemoteException;;  
    public String getNama_Pelajaran() throws RemoteException;;
    public void setNama_Pelajaran(String Nama_Pelajaran) throws RemoteException;; 
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;; 
    public int doDelete() throws RemoteException;; 
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
}
