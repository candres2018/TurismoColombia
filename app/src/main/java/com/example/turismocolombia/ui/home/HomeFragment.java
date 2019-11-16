package com.example.turismocolombia.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.turismocolombia.LugarApi.LugarApi;
import com.example.turismocolombia.MainActivity;
import com.example.turismocolombia.Model.LugarT;
import com.example.turismocolombia.Model.LugaresResponse;
import com.example.turismocolombia.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Retrofit retrofit;
    private List<LugarT> lugares;
    private final  String logs = "---| ";

    RecyclerView recycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        recycler = root.findViewById(R.id.recycler);

        //getData();

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);



            }
        });
        /*
        private void getData() {
            LugarApi service = retrofit.create(LugarApi.class);
            Call<List<LugarT>> call = service.getLugarT("yf8m-7cq5.json");

            call.enqueue(new Callback<List<LugarT>>() {
                @Override
                public void onResponse(Call<List<LugarT>> call, Response<List<LugarT>> response) {
                    if(response.isSuccessful()){

                }else{
                        Log.e(logs,"onResponse"+response.errorBody());
                    }

                @Override
                public void onFailure(Call<List<LugarT>> call, Throwable t) {
                        Log.e(logs," onFailure: "+t.getMessage());
                }
            });

            });
        }*/


        return root;
    }
}