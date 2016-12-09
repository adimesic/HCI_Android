package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class PosiljkeDetalji {


    @SerializedName("PosiljkaDetaljiID")
    @Expose
    public int posiljkaDetaljiID;
    @SerializedName("Tezina")
    @Expose
    public float tezina;
    @SerializedName("Visina")
    @Expose
    public float visina;
    @SerializedName("Duzina")
    @Expose
    public float duzina;
    @SerializedName("Sirina")
    @Expose
    public float sirina;
    @SerializedName("Cijena")
    @Expose
    public float cijena;

    @Override
    public String toString() {
        return "PosiljkeDetalji{" +
                "posiljkaDetaljiID=" + posiljkaDetaljiID +
                ", tezina=" + tezina +
                ", visina=" + visina +
                ", duzina=" + duzina +
                ", sirina=" + sirina +
                ", cijena=" + cijena +
                '}';
    }
}
