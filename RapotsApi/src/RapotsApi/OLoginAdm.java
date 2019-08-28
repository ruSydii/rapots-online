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
public interface OLoginAdm extends Remote{

    public boolean Loginguru (String ussername,String passwords) throws RemoteException;
    
}
