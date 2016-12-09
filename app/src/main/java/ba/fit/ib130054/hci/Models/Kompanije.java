package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Kompanije {
    @SerializedName("FirmaID")
    @Expose
    public Integer firmaID;
    @SerializedName("Naziv")
    @Expose
    public String naziv;
    @SerializedName("IDBroj")
    @Expose
    public String iDBroj;
    @SerializedName("OdgovornaOsoba")
    @Expose
    public String odgovornaOsoba;
    @SerializedName("Mail")
    @Expose
    public String mail;
    @SerializedName("Telefon")
    @Expose
    public String telefon;
    @SerializedName("Faks")
    @Expose
    public String faks;
    @SerializedName("Adresa")
    @Expose
    public String adresa;
    @SerializedName("Grad")
    @Expose
    public String grad;

    @Override
    public String toString() {
        return "Kompanije{" +
                "kompanijaID=" + firmaID +
                ", naziv='" + naziv + '\'' +
                ", iDBroj='" + iDBroj + '\'' +
                ", odgovornaOsoba='" + odgovornaOsoba + '\'' +
                ", mail='" + mail + '\'' +
                ", telefon='" + telefon + '\'' +
                ", faks='" + faks + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}