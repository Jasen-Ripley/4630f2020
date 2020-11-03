package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;
import com.example.myapplication.Retrofit.Example;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    PDFView pdfView;
    ImageView search;
    TextView temp, feelslike;
    EditText searchbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void randomfacts(View randomfacts){
        setContentView(R.layout.randomfacts);
    }
    public void facts(View facts){
        setContentView(R.layout.facts);
    }
    public void investment(View investment){
        setContentView(R.layout.investment);
        ListView listView;
        listView = (ListView)findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Jasen's Investments");
        arrayList.add("Savings - $10,000");
        arrayList.add("Checking - $500");
        arrayList.add("Stock Market - $7,000");
        arrayList.add("Bitcoin - $2,000");
        arrayList.add("");
        arrayList.add("Gayle's Investments");
        arrayList.add("Savings - $12,000");
        arrayList.add("Checking - $900");
        arrayList.add("Stock Market - $78,000");
        arrayList.add("Gold Bars - $7,000");
        arrayList.add("");
        arrayList.add("Chuck's Investments");
        arrayList.add("Savings - $31,000");
        arrayList.add("Checking - $1,000");
        arrayList.add("Stock Market - $21,000");
        arrayList.add("Bonds - $10,000");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

    }
    public void resume(View resume){
        setContentView(R.layout.resume);
        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("resume.pdf").load();
    }
    public void weather(View weather){
        setContentView(R.layout.weather);
        search = findViewById(R.id.search);
        temp = findViewById(R.id.temp);
        feelslike = findViewById(R.id.feelslike);
        searchbar = findViewById(R.id.searchbar);

        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getWeatherData(searchbar.getText().toString().trim());
            }
        });
    }
    private void getWeatherData(String name) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                try {
                    temp.setText("Temp" + " " + response.body().getMain().getTemp() + " F");
                    feelslike.setText("Feels Like" + " " + response.body().getMain().getFeels_like());
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

    public void selfie(View selfie){
        setContentView(R.layout.selfie);
    }
    public void weatheroptions(View weatheroptions){
        setContentView(R.layout.weatheroptions);
    }
    public void weatherhome(View weatherhome){
        setContentView(R.layout.weatherhome);
        search = findViewById(R.id.search);
        temp = findViewById(R.id.temp);
        feelslike = findViewById(R.id.feelslike);
        searchbar = findViewById(R.id.searchbar);
        String name = "Marlboro";
        getWeatherData(name);

    }
    public void weatherorlando(View weatherorlando){
        setContentView(R.layout.weatherorlando);
        search = findViewById(R.id.search);
        temp = findViewById(R.id.temp);
        feelslike = findViewById(R.id.feelslike);
        searchbar = findViewById(R.id.searchbar);
        String name = "Orlando";
        getWeatherData(name);

    }
    public void return1(View return1){
        setContentView(R.layout.activity_main);
    }

}
