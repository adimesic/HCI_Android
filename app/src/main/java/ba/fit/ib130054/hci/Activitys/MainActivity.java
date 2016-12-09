package ba.fit.ib130054.hci.Activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import ba.fit.ib130054.hci.Fragments.DolaznePosiljkeFragment;
import ba.fit.ib130054.hci.Fragments.InfoFragment;
import ba.fit.ib130054.hci.Fragments.KompanijeFragment;
import ba.fit.ib130054.hci.Fragments.OdlaznePosiljkeFragment;
import ba.fit.ib130054.hci.Fragments.OsobniPodaciFragment;
import ba.fit.ib130054.hci.Fragments.PrimaociFragment;
import ba.fit.ib130054.hci.Models.Posiljke;
import ba.fit.ib130054.hci.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int userIDfromLoginActivity;
    Bundle bundle;

    List<Posiljke> posiljke;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        mContext = this;

        userIDfromLoginActivity = getIntent().getExtras().getInt("userID");


        //dohvatanje userID od loginActivity

        bundle = new Bundle();
        bundle.putInt("userID", userIDfromLoginActivity);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        InfoFragment infoFragment = new InfoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.layoutForFragments, infoFragment).commit();
        getSupportActionBar().setTitle("Info o aplikaciji");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_posiljke_dolazne) {


            DolaznePosiljkeFragment dolaznePosiljkeFragment = new DolaznePosiljkeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            dolaznePosiljkeFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.layoutForFragments, dolaznePosiljkeFragment).commit();
            getSupportActionBar().setTitle("Dolazne pošiljke");
        }

        else if (id==R.id.nav_posiljke_odlazne)
        {

            OdlaznePosiljkeFragment odlazneFragment= new OdlaznePosiljkeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            odlazneFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.layoutForFragments, odlazneFragment).commit();
            getSupportActionBar().setTitle("Odlazne pošiljke");

        }

        else if (id==R.id.nav_info)
        {
            InfoFragment infoFragment = new InfoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.layoutForFragments, infoFragment).commit();
            getSupportActionBar().setTitle("Info o aplikaciji");
        }

        else if (id == R.id.nav_kompanije) {
            KompanijeFragment kompanijeFragment = new KompanijeFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.lay outForFragments,kompanijeFragment).commit();
            getSupportActionBar().setTitle("Kompanije");


        } else if (id == R.id.nav_primaoci) {
            PrimaociFragment primaociFragment = new PrimaociFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            primaociFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.layoutForFragments,primaociFragment).commit();
            getSupportActionBar().setTitle("Primaoci");


        } else if (id == R.id.nav_profil) {

            OsobniPodaciFragment osobniPodaciFragment = new OsobniPodaciFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            osobniPodaciFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.layoutForFragments,osobniPodaciFragment).commit();
            getSupportActionBar().setTitle("Profil");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
