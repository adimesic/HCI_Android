package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Favoriti {


    @SerializedName("FavoritiID")
    @Expose
    public int favoritiID;
    @SerializedName("KorisnikID")
    @Expose
    public int korisnikID;
    @SerializedName("PrimaocID")
    @Expose
    public int primaocID;
    @SerializedName("Ime")
    @Expose
    public String ime;
    @SerializedName("Prezime")
    @Expose
    public String prezime;
    @SerializedName("Adresa")
    @Expose
    public String adresa;
    @SerializedName("Grad")
    @Expose
    public String grad;
    @SerializedName("Telefon")
    @Expose
    public String telefon;

    @Override
    public String toString() {
        return "Favoriti{" +
                "favoritiID=" + favoritiID +
                ", korisnikID=" + korisnikID +
                ", primaocID=" + primaocID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
