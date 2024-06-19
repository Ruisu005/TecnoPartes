package com.example.tecnopartes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageViewProcessors = findViewById(R.id.imageViewProcessors);
        ImageView imageViewGraphicsCards = findViewById(R.id.imageViewGraphicsCards);
        ImageView imageViewRAM = findViewById(R.id.imageViewRAM);
        ImageView imageViewMotherboards = findViewById(R.id.imageViewMotherboards);
        ImageView imageViewCases = findViewById(R.id.imageViewCases);
        ImageView imageViewStorage = findViewById(R.id.imageViewStorage);
        ImageView imageViewAirCooling = findViewById(R.id.imageViewAirCooling);
        ImageView imageViewLiquidCooling = findViewById(R.id.imageViewLiquidCooling);
        ImageView imageViewPowerSupplies = findViewById(R.id.imageViewPowerSupplies);
        ImageView imageViewFans = findViewById(R.id.imageViewFans);

        imageViewProcessors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Procesadores seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewGraphicsCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Tarjetas Gráficas seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewRAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "RAM seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewMotherboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Tarjetas Madres seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Gabinetes seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Almacenamiento seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewAirCooling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Enfriamiento de Aire seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewLiquidCooling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Enfriamiento Líquido seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewPowerSupplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Fuentes de Poder seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewFans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "Ventiladores seleccionado", Toast.LENGTH_SHORT).show();
            }
        });
    }

}