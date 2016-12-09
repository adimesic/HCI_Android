package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class KorisniciProvjera {
    @SerializedName("KorisnikID")
    @Expose
    public int korisnikID;
    @SerializedName("Mail")
    @Expose
    public String mail;
    @SerializedName("Password")
    @Expose
    public String password;

    @Override
    public String toString() {
        return "KorisniciProvjera{" +
                "korisnikID=" + korisnikID +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
