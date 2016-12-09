package ba.fit.ib130054.hci.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import ba.fit.ib130054.hci.Models.Primaoci;
import ba.fit.ib130054.hci.R;


public class PrimaociAdapter extends ArrayAdapter<Primaoci> {

    public PrimaociAdapter (Context context, ArrayList<Primaoci> primaoci) {

        super(context, 0, primaoci);
    }

    public View getView(int position, View view, ViewGroup parent) {

        Primaoci primaoci = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_primaoci, parent, false);
        }

        TextView primaocID = (TextView)view.findViewById(R.id.textViewPrimaociIDValue);
        TextView ime = (TextView)view.findViewById(R.id.textViewPrimaociImeValue);
        TextView prezime = (TextView)view.findViewById(R.id.textViewPrimaociPrezimeValue);
        TextView telefon = (TextView)view.findViewById(R.id.textViewPrimaociTelefonValue);
        TextView adresa = (TextView) view.findViewById(R.id.textViewPrimaociAdresaValue);
        TextView grad = (TextView)view.findViewById(R.id.textViewPrimaociGradValue);

        primaocID.setText(Integer.toString(primaoci.primalacID));
        ime.setText(primaoci.ime);
        prezime.setText(primaoci.prezime);
        telefon.setText(primaoci.telefon);
        adresa.setText(primaoci.adresa);
        grad.setText(primaoci.grad);


        return view;
    }



}

