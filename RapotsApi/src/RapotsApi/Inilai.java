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
public interface Inilai extends Remote{
    
     public void setnis(int nis) throws Exception;;
    public int getnis() throws Exception;;
    public void setkode_pelajaran (String kode_pelajaran) throws Exception;;
    public String getkode_pelajaran() throws Exception;;
    public void setkode_kelas (String kode_kelas) throws Exception;;
    public String getkode_kelas() throws Exception;;
    public void setid_pivot (String id_pivot) throws Exception;;
    public String getid_pivot() throws Exception;;
    public void settahun_ajaran (String tahun_ajaran) throws Exception;;
    public String gettahun_ajaran() throws Exception;;
    public void setnilai_harian(int nilai_harian) throws Exception;;
    public int getnilai_harian() throws Exception;;
    public void setnilai_UTS(int nilai_UTS) throws Exception;;
    public int getnilai_UTS() throws Exception;;
    public void setnilai_UAS(int nilai_UAS) throws Exception;;
    public int getnilai_UAS() throws Exception;;
    public ArrayList<String> search(int nis) throws RemoteException;;
    
}
