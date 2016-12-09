package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 05-Aug-16.
 */
public class Adrese {

    @SerializedName("AdresaID")
    @Expose
    public int adresaID;
    @SerializedName("Naziv")
    @Expose
    public String naziv;
    @SerializedName("GradNaziv")
    @Expose
    public String gradNaziv;

    @Override
    public String toString() {
        return "Adrese{" +
                "adresaID=" + adresaID +
                ", naziv='" + naziv + '\'' +
                ", gradNaziv='" + gradNaziv + '\'' +
                '}';
    }
}
