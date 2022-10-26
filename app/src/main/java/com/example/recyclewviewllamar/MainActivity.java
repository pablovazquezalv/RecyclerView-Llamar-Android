package com.example.recyclewviewllamar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int REQUEST_CODE = 200;
    private ArrayList<Usuario> usersList;
    private RecyclerView recyclerView;
    AdaptadorUsuario personaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();
        personaAdapter = new AdaptadorUsuario(usersList, new AdaptadorUsuario.ItemClickListener() {
            @Override
            public void onItemClick(Usuario item) {
                showToast("Usuario seleccionado:" + item.getUsername());
                Intent llamar = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+item.getPhone()));
                startActivity(llamar);
            }
        });
        recyclerView.setAdapter(personaAdapter);
    }


    private void showToast(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void setAdapter() {
        AdaptadorUsuario adapter = new AdaptadorUsuario(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private void setUserInfo() {
        usersList.add(new Usuario("Pablo", "8713457555"));
        usersList.add(new Usuario("Julieta", "8711116314"));
        usersList.add(new Usuario("Daniel", "6761239812"));
    }
}