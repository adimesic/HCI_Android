package ba.fit.ib130054.hci.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gradovi {

    @SerializedName("GradID")
    @Expose
    public int gradID;
    @SerializedName("Naziv")
    @Expose
    public String naziv;
    @SerializedName("PostanskiBroj")
    @Expose
    public String postanskiBroj;

    @Override
    public String toString() {
        return "Gradovi{" +
                "gradID=" + gradID +
                ", naziv='" + naziv + '\'' +
                ", postanskiBroj='" + postanskiBroj + '\'' +
                '}';
    }


}