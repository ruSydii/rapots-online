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
public class PivotClass implements java.io.Serializable {
    private static final long serialVersionUID = 4565478567456876567L;
    private String idPivot;
    private String kodeKelas;
    private String nis;
    private String tahun_ajaran;
    private String keterangan;
    private String rataRata;
    
    
    
     public PivotClass(String idPivot, String kodeKelas, String nis, String Tahun_ajaran,String keterangan, String rataRata)
    {
        this.idPivot = idPivot;
        this.kodeKelas = kodeKelas;
        this.nis = nis;
        this.tahun_ajaran = Tahun_ajaran;
        this.keterangan = keterangan;
        this.rataRata = rataRata;
    }
    
    public String getIdPivot()
    {
        return idPivot;
    }
    
    public String getKodeKelas()
    {
        return kodeKelas;
    }
 
    public String getNis()
    {
        return nis;
    }
    
    public String getTahun_ajaran()
    {
        return tahun_ajaran;
    }
    
    public String getKeterangan()
    {
        return keterangan;
    }
    
    public String getRataRata()
    {
        return rataRata;
    }

    @Override
    public String toString()
    {
        return idPivot + " - " + kodeKelas + " - " + nis + " - " + tahun_ajaran + " - " + keterangan + " - " + rataRata;
    }
    
    public String[] toStringArray()
    {
        return new String[]{idPivot, kodeKelas, nis,tahun_ajaran, keterangan, rataRata};
    }
}

