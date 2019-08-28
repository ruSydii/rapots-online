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

public interface OKelasAdm extends Remote{
    public String getKode_Kelas() throws RemoteException;;
    public void setKode_Kelas(String Kode_Kelas) throws RemoteException;;
    public String getKelas() throws RemoteException;;
    public void setKelas(String Kelas) throws RemoteException;;   
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
}