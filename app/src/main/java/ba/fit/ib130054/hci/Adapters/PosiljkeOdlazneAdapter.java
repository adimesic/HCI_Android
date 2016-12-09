package ba.fit.ib130054.hci.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ba.fit.ib130054.hci.Models.Posiljke;
import ba.fit.ib130054.hci.R;

/**
 * Created by Adi on 12-Aug-16.
 */
public class PosiljkeOdlazneAdapter extends ArrayAdapter<Posiljke>{


    public PosiljkeOdlazneAdapter (Context context, ArrayList<Posiljke> posiljke) {

        super(context, 0, posiljke);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Posiljke posiljke = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_dolazne_posiljke, parent, false);
        }

        TextView posiljkaID = (TextView) view.findViewById(R.id.textViewOdlaznaPosiljkaID);
        TextView primalac = (TextView) view.findViewById(R.id.textViewOdlaznaPrimaoc);
        TextView datumPreuzimanja = (TextView) view.findViewById(R.id.textViewOdlaznaDatumPreuzimanja);
        TextView datumDostave = (TextView) view.findViewById(R.id.textViewOdlaznaDatumDostave);
        TextView kompanija = (TextView) view.findViewById(R.id.textViewOdlaznaKompanija);
        TextView vozac = (TextView) view.findViewById(R.id.textViewVozac);

        posiljkaID.setText(Integer.toString(posiljke.posiljkaID));
        primalac.setText(posiljke.primaoc);
        datumDostave.setText(posiljke.datumDostave);
        datumPreuzimanja.setText(posiljke.datumPreuzimanja);
        kompanija.setText(posiljke.kompanija);
        vozac.setText(posiljke.vozac);


        return view;
    }
}
