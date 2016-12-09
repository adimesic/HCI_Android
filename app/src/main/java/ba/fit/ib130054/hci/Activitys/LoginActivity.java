package ba.fit.ib130054.hci.Activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ba.fit.ib130054.hci.Helpers.API;
import ba.fit.ib130054.hci.Models.Adrese;
import ba.fit.ib130054.hci.Models.KorisniciProvjera;
import ba.fit.ib130054.hci.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.email_sign_in_button)
    Button btnSignIn;
    Context mContext;
    int profileID;
    @BindView(R.id.login_progress)
    ProgressBar progressBar;
    @BindView(R.id.login_progress_text)
    TextView textViewLoginProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext = this;

    }

    @OnClick(R.id.email_sign_in_button)
    public void prijava() {
        progressBar.setVisibility(View.VISIBLE);
        textViewLoginProgress.setText("Prijava na servis...");
        API api = API.Factory.getInstance(mContext);
        api.provjera(mEmail.getText().toString(), mPassword.getText().toString())
                .enqueue(new Callback<KorisniciProvjera>() {
                    @Override
                    public void onResponse(Call<KorisniciProvjera> call, Response<KorisniciProvjera> response) {
                        if (response.isSuccessful()) {
                            KorisniciProvjera korisniciProvjera = response.body();
                            profileID = korisniciProvjera.korisnikID;
                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.putExtra("userID", profileID);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(mContext, "Neuspjesna prijava", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                            textViewLoginProgress.setText("");
                        }
                    }

                    @Override
                    public void onFailure(Call<KorisniciProvjera> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        textViewLoginProgress.setText("");
                    }
                });
    }

}

