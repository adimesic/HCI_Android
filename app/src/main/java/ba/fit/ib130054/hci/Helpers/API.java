package ba.fit.ib130054.hci.Helpers;

import android.content.Context;
import android.support.graphics.drawable.BuildConfig;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ba.fit.ib130054.hci.Models.*;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Adi on 05-Aug-16.
 */
public interface API {
    String BASE_URL = "http://5.189.152.86/plesk-site-preview/bp.si112.app.fit.ba/5.189.152.86/api/";

    @GET("Adrese")
    Call<List<Adrese>> getAdrese();

    @GET("Adrese/{id}")
    Call<Adrese>getAdreseByID(@Path("id") int id);


    @GET("Korisnici/provjera?")
    Call<KorisniciProvjera> provjera(@Query("email") String email, @Query("password") String password);

    @GET("Korisnici/{id}")
    Call<Korisnici> getKorisnikByID(@Path("id") int id);

    @GET("Posiljke/posiljkaByKorisnik/{id}")
    Call<ArrayList<Posiljke>> getPosiljkeByKorisnikID(@Path("id") int id);


    @GET("Posiljke/posiljkaByPrimaoc/{id}")
    Call<ArrayList<Posiljke>> getPosiljkeByPrimaocID(@Path("id") int id);

    @GET("Firme")
    Call<ArrayList<Kompanije>> getKompanije();

    @GET("posiljke/getPrimaocibyKorisnik/{id}")
    Call<ArrayList<Primaoci>> getPrimaociByKorisnik(@Path("id") int id);

    @GET("korisnici/{id}")
    Call<Korisnici> getKorisnik(@Path("id") int id);




    class Factory {
        private static API service;

        public static API getInstance(Context context) {
            if (service == null) {
                OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                builder.readTimeout(15, TimeUnit.SECONDS);
                builder.connectTimeout(15, TimeUnit.SECONDS);
                builder.writeTimeout(15, TimeUnit.SECONDS);


                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                    builder.addInterceptor(interceptor);
                }

                int cacheSize = 10 * 1024 * 1024;
                Cache cache = new Cache(context.getCacheDir(), cacheSize);
                builder.cache(cache);

                Retrofit retrofit = new Retrofit.Builder().client(builder.build())
                        .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();

                service = retrofit.create(API.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
