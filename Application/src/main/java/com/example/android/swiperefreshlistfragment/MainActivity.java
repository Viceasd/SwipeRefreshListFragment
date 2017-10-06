/*
* Copyright 2013 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/


package com.example.android.swiperefreshlistfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ViewAnimator;
import com.example.android.common.activities.SampleActivityBase;
import com.example.android.common.logger.Log;
import com.example.android.common.logger.LogFragment;
import com.example.android.common.logger.LogWrapper;
import com.example.android.common.logger.MessageOnlyLogFilter;
import com.example.android.model.Data;
import com.example.android.model.Evento;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.UUID;


/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class MainActivity extends SampleActivityBase {

    public static final String TAG = "MainActivity";
    private final OkHttpClient client = new OkHttpClient();


    String token = "";
    public static String respuestaServer;

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("llamadoPrimerRest: ","sdfsdf");
        if (savedInstanceState == null) {
        }
        AccesoRemoto acceso= new AccesoRemoto();
        acceso.execute();

    }



    /** Create a chain of targets that will receive log data */




    private class AccesoRemoto extends AsyncTask<Void, Void, String> {

        protected String doInBackground(Void... argumentos) {

            UUID idOne = UUID.randomUUID();
            OkHttpClient client = new OkHttpClient();
            String respuesta = "";
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "\r\n\r\n{\r\n\"user\": {\r\n\"profile\": {\r\n\"language\": \"es\"\r\n}\r\n},\r\n\"device\": {\r\n\"deviceId\": \""+idOne.toString()+"\",\r\n\"name\": \"MyPhone\",\r\n\"version\": \"4.4.4\",\r\n\"width\": \"640\",\r\n\"heigth\": \"960\",\r\n\"model\": \"Awesome Model 6\",\r\n\"platform\": \"android\"\r\n},\r\n\"app\": {\r\n\"version\": \"1.0.0\"\r\n}\r\n}\r\n\r\n");
            Request request = new Request.Builder()
                    .url("http://fxservicesstaging.nunchee.com/api/1.0/auth/users/login/anonymous")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("authorization", "Basic cHJ1ZWJhc2RldjpwcnVlYmFzZGV2U2VjcmV0")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b44d8235-f790-a5a0-bfe8-524c5db1ca48")
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                respuesta = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return respuesta;

        }

        protected void onPostExecute(String mensaje) {


            try {
                JSONObject reader = new JSONObject(mensaje);
                JSONObject sys  = reader.getJSONObject("data");
                token = sys.getString("accessToken");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            DatosPartidos datos= new DatosPartidos();
            datos.execute();


        }

    }


    private class DatosPartidos extends AsyncTask<Void, Void, String> {

        protected String doInBackground(Void... argumentos) {

            OkHttpClient client = new OkHttpClient();
            String respuesta = "";
            System.out.println("token2: "+token);
            Request request = new Request.Builder()
                    .url("http://fxservicesstaging.nunchee.com/api/1.0/sport/events")
                    .get()
                    .addHeader("authorization", "Bearer "+token)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "fb2c7db2-0c19-1f98-7c6c-eab5ee5d9901")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                respuesta = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return respuesta;

        }

        protected void onPostExecute(String mensaje) {



            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SwipeRefreshListFragmentFragment fragment = new SwipeRefreshListFragmentFragment();

            Bundle bundle = new Bundle();
            bundle.putString("mensajeServidor", mensaje);
             // set Fragmentclass Arguments

            fragment.setArguments(bundle);
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();

        }

    }

}
