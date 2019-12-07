package com.example.turismocolombia.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.turismocolombia.LugarApi.LugarApi;
import com.example.turismocolombia.Model.LugarT;
import com.example.turismocolombia.R;
import com.example.turismocolombia.TuristicAdapter;

public class HomeFragment extends Fragment {

    private Retrofit retrofit;
    private final  String logs = "---| ";

    private View root;
    private Bundle bundle;

    private RecyclerView recycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        bundle = savedInstanceState;

        recycler = root.findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        LinearLayoutManager linear = new LinearLayoutManager(root.getContext());
        recycler.setLayoutManager(linear);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        getData();

        return root;
            }

    public void onResume(){
        super.onResume();
    }

    public void onPause(){
        super.onPause();
    }

    private void getData() {
        try{

            LugarApi service = retrofit.create(LugarApi.class);
            Call<List<LugarT>> LugarTResponseCall = service.getLugarTList("yf8m-7cq5.json");

            LugarTResponseCall.enqueue(new Callback<List<LugarT>>() {
                @Override
                public void onResponse(Call<List<LugarT>> call, Response<List<LugarT>> response) {
                    if(response.isSuccessful()){
                        List<LugarT> lugares = response.body();
                        TuristicAdapter adapter = new TuristicAdapter(lugares);
                        recycler.setAdapter(adapter);
                    } else {
                        Log.e(logs, "onResponse: "+response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<LugarT>> call, Throwable t) {
                    Log.e(logs," onFailure: "+t.getStackTrace());
                }
            });

        }catch (Exception e){
            Log.e(logs, "onFailure: " + e);
        }

    }

        }
