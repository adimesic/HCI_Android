package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Vozaci {

    @SerializedName("VozacID")
    @Expose
    public int vozacID;
    @SerializedName("Ime")
    @Expose
    public String ime;
    @SerializedName("Prezime")
    @Expose
    public String prezime;
    @SerializedName("DatumRodjenja")
    @Expose
    public String datumRodjenja;
    @SerializedName("DatumZaposlenja")
    @Expose
    public String datumZaposlenja;
    @SerializedName("Telefon")
    @Expose
    public String telefon;
    @SerializedName("Adresa")
    @Expose
    public String adresa;
    @SerializedName("Grad")
    @Expose
    public String grad;
    @SerializedName("Kompanija")
    @Expose
    public String kompanija;

    @Override
    public String toString() {
        return "Vozaci{" +
                "vozacID=" + vozacID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRodjenja='" + datumRodjenja + '\'' +
                ", datumZaposlenja='" + datumZaposlenja + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", kompanija='" + kompanija + '\'' +
                '}';
    }
}
