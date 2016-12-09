package ba.fit.ib130054.hci.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ba.fit.ib130054.hci.Adapters.PrimaociAdapter;
import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Primaoci;
import ba.fit.ib130054.hci.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimaociFragment extends Fragment {

    View view;
    int userID;
    ArrayList<Primaoci> primaoci = null;

    public PrimaociFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        userID = getArguments().getInt("userID");

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_primaoci, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        getPrimaoci(userID);


        return view;
    }

    private void getPrimaoci(int id) {
        API api = API.Factory.getInstance(getActivity());
        api.getPrimaociByKorisnik(id).enqueue(new Callback<ArrayList<Primaoci>>() {
            @Override
            public void onResponse(Call<ArrayList<Primaoci>> call, Response<ArrayList<Primaoci>> response) {
                primaoci = new ArrayList<Primaoci>();
                primaoci=response.body();
                if(primaoci!=null) {

                    PrimaociAdapter primaociAdapter = new PrimaociAdapter(getActivity(),primaoci);
                    ListView listView = (ListView)view.findViewById(R.id.listPrimaoci);
                    listView.setAdapter(primaociAdapter);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Primaoci>> call, Throwable t) {

            }
        });
    }
}


