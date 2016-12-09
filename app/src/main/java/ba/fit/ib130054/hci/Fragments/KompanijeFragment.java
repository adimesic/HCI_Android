package ba.fit.ib130054.hci.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import ba.fit.ib130054.hci.Adapters.KompanijeAdapter;
import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Kompanije;
import ba.fit.ib130054.hci.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class KompanijeFragment extends Fragment {

    View view;
    ArrayList<Kompanije> kompanije = null;

    public KompanijeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_kompanije, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        getKompanije();


        return view;
    }

    private void getKompanije() {
        API api = API.Factory.getInstance(getActivity());
        api.getKompanije().enqueue(new Callback<ArrayList<Kompanije>>() {
            @Override
            public void onResponse(Call<ArrayList<Kompanije>> call, Response<ArrayList<Kompanije>> response) {

                kompanije = new ArrayList<Kompanije>();
                kompanije = response.body();

                if (kompanije != null) {
                    KompanijeAdapter kompanijeAdapter = new KompanijeAdapter(getActivity(), kompanije);
                    ListView listView = (ListView) view.findViewById(R.id.listKompanije);
                    listView.setAdapter(kompanijeAdapter);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Kompanije>> call, Throwable t) {

            }
        });


    }

}
