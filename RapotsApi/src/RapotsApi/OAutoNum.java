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
 *///Client
public interface OAutoNum extends Remote{
    public String NIS() throws RemoteException;;
    public String Kelas() throws RemoteException;;
    public String Pivot() throws RemoteException;;
    public String Guru() throws RemoteException;;
    public String Matpel() throws RemoteException;;
}

