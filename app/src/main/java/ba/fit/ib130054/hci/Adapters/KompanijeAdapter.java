package ba.fit.ib130054.hci.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ba.fit.ib130054.hci.Models.Kompanije;
import ba.fit.ib130054.hci.Models.Posiljke;
import ba.fit.ib130054.hci.R;

/**
 * Created by Adi on 12-Aug-16.
 */
public class KompanijeAdapter extends ArrayAdapter<Kompanije> {


    public KompanijeAdapter (Context context, ArrayList<Kompanije> kompanije) {

        super(context, 0, kompanije);
    }


    public View getView(int position, View view, ViewGroup parent) {

        Kompanije kompanije = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_kompanije, parent, false);
        }

        TextView KompanijaID = (TextView)view.findViewById(R.id.textViewKompanijIDValue);
        TextView Naziv = (TextView)view.findViewById(R.id.textViewNazivValue);
        TextView IDBroj = (TextView)view.findViewById(R.id.textViewIDBrojValue);
        TextView OdgovornaOsoba = (TextView)view.findViewById(R.id.textViewOdgovornaOsobaValue);
        TextView Email = (TextView)view.findViewById(R.id.textViewEMailValues);
        TextView Telefon = (TextView)view.findViewById(R.id.textViewTelefonValue);
        TextView Faks = (TextView) view.findViewById(R.id.textViewFaksValues);
        TextView Adresa = (TextView)view.findViewById(R.id.textViewAdresaValue);
        TextView Grad = (TextView)view.findViewById(R.id.textViewGradValue);

        KompanijaID.setText(Integer.toString(kompanije.firmaID));
        Naziv.setText(kompanije.naziv);
        IDBroj.setText(kompanije.iDBroj);
        OdgovornaOsoba.setText(kompanije.odgovornaOsoba);
        Email.setText(kompanije.mail);
        Telefon.setText(kompanije.telefon);
        Faks.setText(kompanije.faks);
        Adresa.setText(kompanije.adresa);
        Grad.setText(kompanije.grad);


        return view;
    }

}