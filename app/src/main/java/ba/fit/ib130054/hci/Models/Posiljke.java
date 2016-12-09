package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Adi on 06-Aug-16.
 */
public class Posiljke {
    @SerializedName("PosiljkaID")
    @Expose
    public int posiljkaID;
    @SerializedName("Posiljatelj")
    @Expose
    public String posiljatelj;
    @SerializedName("Primaoc")
    @Expose
    public String primaoc;
    @SerializedName("Vozac")
    @Expose
    public String vozac;
    @SerializedName("Kompanija")
    @Expose
    public String kompanija;
    @SerializedName("DatumPreuzimanja")
    @Expose
    public String datumPreuzimanja;
    @SerializedName("DatumDostave")
    @Expose
    public String datumDostave;


    public int getPosiljkaID() {
        return posiljkaID;
    }

    public void setPosiljkaID(int posiljkaID) {
        this.posiljkaID = posiljkaID;
    }

    public String getPosiljatelj() {
        return posiljatelj;
    }

    public void setPosiljatelj(String posiljatelj) {
        this.posiljatelj = posiljatelj;
    }

    public String getPrimaoc() {
        return primaoc;
    }

    public void setPrimaoc(String primaoc) {
        this.primaoc = primaoc;
    }

    public String getVozac() {
        return vozac;
    }

    public void setVozac(String vozac) {
        this.vozac = vozac;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public String getDatumPreuzimanja() {
        return datumPreuzimanja;
    }

    public void setDatumPreuzimanja(String datumPreuzimanja) {
        this.datumPreuzimanja = datumPreuzimanja;
    }

    public String getDatumDostave() {
        return datumDostave;
    }

    public void setDatumDostave(String datumDostave) {
        this.datumDostave = datumDostave;
    }

    @Override
    public String toString() {
        return "Posiljke{" +
                "posiljkaID=" + posiljkaID +
                ", posiljatelj='" + posiljatelj + '\'' +
                ", primaoc='" + primaoc + '\'' +
                ", vozac='" + vozac + '\'' +
                ", kompanija='" + kompanija + '\'' +
                ", datumPreuzimanja='" + datumPreuzimanja + '\'' +
                ", datumDostave='" + datumDostave + '\'' +
                '}';
    }
}
