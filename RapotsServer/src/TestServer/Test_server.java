/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.SiswaAdm;
import RapotsApi.OSiswaAdm;
import model.AutoNum;
import RapotsApi.OAutoNum;
import model.KelasAdm;
import RapotsApi.OKelasAdm;
import RapotsApi.OPivotAdm;
import model.InPivot;
import model.LoginAdm;
import RapotsApi.OLoginAdm;
import model.GuruAdm;
import RapotsApi.OGuruAdm;
import RapotsApi.Inilai;
import model.nilai;
import RapotsApi.Ipivot;
import model.InPivot;
import model.pivot;
import model.NilaiAdm;
import RapotsApi.ONilaiAdm;
import model.MatpelAdm;
import RapotsApi.OMatpelAdm;


/**
 *
 * @author Owner
 */

public class Test_server{
    
    public static void main(String[] args) throws Exception{
        try{
            Registry registry = LocateRegistry.createRegistry(2400);
            OSiswaAdm obj = new SiswaAdm();
            OAutoNum obj2 = new AutoNum();
            OKelasAdm obj3 = new KelasAdm();
            OLoginAdm obj5 = new LoginAdm();
            OGuruAdm obj6 = new GuruAdm();
            Inilai obj7 = new nilai();
            Ipivot obj8 = new pivot();
            OPivotAdm obj4 = new InPivot();
            ONilaiAdm obj9 = new NilaiAdm();
            OMatpelAdm obj10 = new MatpelAdm();
            
            registry.rebind("log10", obj10);
            registry.rebind("log9", obj9);
            registry.rebind("log4", obj4);
            registry.rebind("log8", obj8);
            registry.rebind("log7", obj7);
            registry.rebind("log6", obj6);
            registry.rebind("log5", obj5);
            registry.rebind("log3", obj3);
            registry.rebind("log2", obj2);
            registry.rebind("log", obj);
        }
        catch(RemoteException e){
            System.out.println("FileServer: " + e);
        }
    }
}

