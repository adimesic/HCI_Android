package ba.fit.ib130054.hci.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ba.fit.ib130054.hci.Adapters.PosiljkeDolazneAdapter;
import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Posiljke;
import ba.fit.ib130054.hci.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class OdlaznePosiljkeFragment extends Fragment {


    View view;
    public int userID;
    ArrayList<Posiljke> posiljke;

    public OdlaznePosiljkeFragment() {
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
/*
        API api = API.Factory.getInstance(getActivity());
        api.getPosiljkeByPrimaocID(74).enqueue(new Callback<ArrayList<Posiljke>>() {
            @Override
            public void onResponse(Call<ArrayList<Posiljke>> call, Response<ArrayList<Posiljke>> response) {
                ArrayList<Posiljke> posiljke=new ArrayList<Posiljke>();
                posiljke=response.body();

                PosiljkeDolazneAdapter adapter = new PosiljkeDolazneAdapter(getActivity(),posiljke);
                ListView listView = (ListView)view.findViewById(R.id.listDolaznePosiljke);
                listView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<ArrayList<Posiljke>> call, Throwable t) {

            }
        });
*/

        PosiljkeDolazneAdapter adapter = new PosiljkeDolazneAdapter(getActivity(),posiljke);
        ListView listView = (ListView)view.findViewById(R.id.listDolaznePosiljke);
        listView.setAdapter(adapter);
        //Toast.makeText(getContext(),Integer.toString(posiljke.size()),Toast.LENGTH_LONG).show();
        return view;
    }

    public void getDolaznePosiljke(int id) {

        API api = API.Factory.getInstance(getActivity());
        api.getPosiljkeByKorisnikID(id).enqueue(new Callback<ArrayList<Posiljke>>() {
            @Override
            public void onResponse(Call<ArrayList<Posiljke>> call, Response<ArrayList<Posiljke>> response) {
                posiljke = new ArrayList<Posiljke>();
                posiljke = response.body();

                PosiljkeDolazneAdapter adapter = new PosiljkeDolazneAdapter(getActivity(), posiljke);
                ListView listView = (ListView) view.findViewById(R.id.listDolaznePosiljke);
                listView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<ArrayList<Posiljke>> call, Throwable t) {

            }
        });

    }}