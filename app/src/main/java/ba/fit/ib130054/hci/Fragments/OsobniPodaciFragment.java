package ba.fit.ib130054.hci.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Korisnici;
import ba.fit.ib130054.hci.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class OsobniPodaciFragment extends Fragment {

    int userID;

    View view;


    TextView korisnikID;
    TextView ime;
    TextView prezime;
    TextView mail;
    TextView adresa;
    TextView grad;

    public OsobniPodaciFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_osobni_podaci, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
        korisnikID = (TextView) view.findViewById(R.id.textViewOsobniKorisnikIDValue);
        ime = (TextView) view.findViewById(R.id.textViewOsobniImeValue);
        prezime = (TextView) view.findViewById(R.id.textViewOsobniPrezimeValue);
        mail = (TextView) view.findViewById(R.id.textViewOsobniMailValue);
        adresa = (TextView) view.findViewById(R.id.textViewOsobniAdresaValue);
        grad = (TextView) view.findViewById(R.id.textViewOsobniGradValue);
        userID = getArguments().getInt("userID");
        napuniFragemnt(userID);
        return view;
    }


    public void napuniFragemnt(int id) {
        API api = API.Factory.getInstance(getActivity());
        api.getKorisnik(id).enqueue(new Callback<Korisnici>() {
            @Override
            public void onResponse(Call<Korisnici> call, Response<Korisnici> response) {

                if (response.isSuccessful()) {
                    Korisnici korisnici = response.body();
                    korisnikID.setText(Integer.toString(korisnici.korisnikID));
                    ime.setText(korisnici.ime);
                    prezime.setText(korisnici.prezime);
                    mail.setText(korisnici.mail);
                    adresa.setText(korisnici.adresa);
                    grad.setText(korisnici.grad);
                } else {
                    String poruka = "Greska";
                    korisnikID.setText(poruka);
                    ime.setText(poruka);
                    prezime.setText(poruka);
                    mail.setText(poruka);
                    adresa.setText(poruka);
                    grad.setText(poruka);
                }
            }

            @Override
            public void onFailure(Call<Korisnici> call, Throwable t) {

            }
        });

    }

}
