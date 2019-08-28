/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RapotsApi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Owner
 */
public interface Ipivot  extends Remote{
    
     public void setPivot(PivotClass pivot) throws RemoteException;
    public PivotClass getPivot(String nis) throws RemoteException; 
}
