package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Korisnici {

        @SerializedName("KorisnikID")
        @Expose
        public int korisnikID;
        @SerializedName("Ime")
        @Expose
        public String ime;
        @SerializedName("Prezime")
        @Expose
        public String prezime;
        @SerializedName("Mail")
        @Expose
        public String mail;

        @SerializedName("Adresa")
        @Expose
        public String adresa;
        @SerializedName("Grad")
        @Expose
        public String grad;

    @Override
    public String toString() {
        return "Korisnici{" +
                "korisnikID=" + korisnikID +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", mail='" + mail + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}

