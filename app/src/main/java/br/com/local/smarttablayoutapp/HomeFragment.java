package br.com.local.smarttablayoutapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    private TextView txtHome;
    private Button btnEnviarDados;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        txtHome = view.findViewById(R.id.txtHome);

        txtHome.setText("Home");

        btnEnviarDados = view.findViewById(R.id.btnEnviarDados);

        btnEnviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "Dados enviados com sucesso!!!",
                        Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}