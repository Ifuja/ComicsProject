package org.esiea.firmin_jacques_olivier_chamoinri_ifuja.comicsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonchoisirlescomics= findViewById(R.id.button_choisir_les_comics);

        String URL="https://comicvine.gamespot.com/api/volumes/?api_key=8687da03d4d13477b19303ae25f9c24c09b02467&format=json";

        RequestQueue requestQueue=Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest=new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            Log.e("Rest Response", response.toString()) ;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            Log.e("Rest Response", error.toString()) ;
                    }
                }
        );

        requestQueue.add(objectRequest);

    }

    public void page1(View view) {
        startActivity(new Intent(this, page_2.class));
    }
}
