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
public interface OGuruAdm extends Remote{
    public String getnip() throws RemoteException;;
    public void setnip(String nip) throws RemoteException;;
    public String getnama_guru() throws RemoteException;;
    public void setnama_guru(String nama_guru) throws RemoteException;;
    public String getjenis_kelamin() throws RemoteException;;
    public void setjenis_kelamin(String jenis_kelamin) throws RemoteException;;
    public String getalamat() throws RemoteException;;
    public void setalamat(String alamat) throws RemoteException;; 
    public int doInsert() throws RemoteException;;
    public int doUpdate() throws RemoteException;;
    public int doDelete() throws RemoteException;;  
    public ArrayList display() throws RemoteException;;
    public ArrayList getRecord() throws RemoteException;;
    public int doLogin() throws RemoteException;;  
}
