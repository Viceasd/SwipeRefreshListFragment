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
import android.widget.ViewAnimator;

import com.example.android.common.activities.SampleActivityBase;
import com.example.android.common.logger.Log;
import com.example.android.common.logger.LogFragment;
import com.example.android.common.logger.LogWrapper;
import com.example.android.common.logger.MessageOnlyLogFilter;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    String respuesta = "";

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("llamadoPrimerRest: ","sdfsdf");
        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SwipeRefreshListFragmentFragment fragment = new SwipeRefreshListFragmentFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
        AccesoRemoto acceso= new AccesoRemoto();
        acceso.execute();
        System.out.println("respuesta: "+respuesta);
         Log.d("llamadoPrimerRest: ","sdfsdf");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem logToggle = menu.findItem(R.id.menu_toggle_log);
        logToggle.setVisible(findViewById(R.id.sample_output) instanceof ViewAnimator);
        logToggle.setTitle(mLogShown ? R.string.sample_hide_log : R.string.sample_show_log);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_toggle_log:
                mLogShown = !mLogShown;
                ViewAnimator output = (ViewAnimator) findViewById(R.id.sample_output);
                if (mLogShown) {
                    output.setDisplayedChild(1);
                } else {
                    output.setDisplayedChild(0);
                }
                supportInvalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Create a chain of targets that will receive log data */
    @Override
    public void initializeLogging() {
        // Wraps Android's native log framework.
        LogWrapper logWrapper = new LogWrapper();
        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        Log.setLogNode(logWrapper);

        // Filter strips out everything except the message text.
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        // On screen logging via a fragment with a TextView.
        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
                .findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getLogView());

        Log.i(TAG, "Ready");
    }

    public String llamadoPrimerRest(){

        UUID idOne = UUID.randomUUID();
        OkHttpClient client = new OkHttpClient();

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


    private class AccesoRemoto extends AsyncTask<Void, Void, String> {

        protected String doInBackground(Void... argumentos) {

            StringBuffer bufferCadena = new StringBuffer("");

            UUID idOne = UUID.randomUUID();
            OkHttpClient client = new OkHttpClient();

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
                //respuesta = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //lee el resultado
            BufferedReader entrada = null;
            try {
                entrada = new BufferedReader(new InputStreamReader(
                        response.body().byteStream()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            String separador = "";
            String NL = System.getProperty("line.separator");
            //almacena el resultado en bufferCadena

            try {
                while ((separador = entrada.readLine()) != null) {
                    bufferCadena.append(separador + NL);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                entrada.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }


            return bufferCadena.toString();

        }
        protected void onPostExecute(String mensaje) {

             respuesta = mensaje;
            //Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();

        }
    }
}
