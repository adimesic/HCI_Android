package ba.fit.ib130054.hci.Fragments;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import ba.fit.ib130054.hci.Adapters.PosiljkeDolazneAdapter;
import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Adrese;
import ba.fit.ib130054.hci.Models.Korisnici;
import ba.fit.ib130054.hci.Models.Posiljke;
import ba.fit.ib130054.hci.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DolaznePosiljkeFragment extends Fragment {

    View view;
    public int userID;
    ArrayList<Posiljke> posiljke;

    public DolaznePosiljkeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        userID = getArguments().getInt("userID");
        posiljke= new ArrayList<Posiljke>();


        if (view == null) {
            view = inflater.inflate(R.layout.fragment_dolazne_posiljke, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        getDolaznePosiljke(userID);

        PosiljkeDolazneAdapter adapter = new PosiljkeDolazneAdapter(getActivity(),posiljke);
        ListView listView = (ListView)view.findViewById(R.id.listDolaznePosiljke);
        listView.setAdapter(adapter);
        //Toast.makeText(getContext(),Integer.toString(posiljke.size()),Toast.LENGTH_LONG).show();
        return view;
    }

    public void getDolaznePosiljke(int id) {

        API api = API.Factory.getInstance(getActivity());
        api.getPosiljkeByPrimaocID(id).enqueue(new Callback<ArrayList<Posiljke>>() {
            @Override
            public void onResponse(Call<ArrayList<Posiljke>> call, Response<ArrayList<Posiljke>> response) {
                posiljke=new ArrayList<Posiljke>();
                posiljke=response.body();

                PosiljkeDolazneAdapter adapter = new PosiljkeDolazneAdapter(getActivity(),posiljke);
                ListView listView = (ListView)view.findViewById(R.id.listDolaznePosiljke);
                listView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<ArrayList<Posiljke>> call, Throwable t) {

            }
        });

    }

}
