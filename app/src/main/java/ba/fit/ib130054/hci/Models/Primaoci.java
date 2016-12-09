package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Primaoci {

    @SerializedName("PrimalacID")
    @Expose
    public int primalacID;
    @SerializedName("Ime")
    @Expose
    public String ime;
    @SerializedName("Prezime")
    @Expose
    public String prezime;
    @SerializedName("Telefon")
    @Expose
    public String telefon;
    @SerializedName("Adresa")
    @Expose
    public String adresa;
    @SerializedName("Grad")
    @Expose
    public String grad;

    @Override
    public String toString() {
        return "Primaoci{" +
                "primalacID=" + primalacID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}
