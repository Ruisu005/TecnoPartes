package com.example.tecnopartes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


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

        setupCategoryClick(R.id.imageViewProcessors, "Procesadores");
        setupCategoryClick(R.id.imageViewGraphicsCards, "Tarjetas Gráficas");
        setupCategoryClick(R.id.imageViewRAM, "RAM");
        setupCategoryClick(R.id.imageViewMotherboards, "Tarjetas Madres");
        setupCategoryClick(R.id.imageViewCases, "Gabinetes");
        setupCategoryClick(R.id.imageViewStorage, "Almacenamiento");
        setupCategoryClick(R.id.imageViewAirCooling, "Enfriamiento de Aire");
        setupCategoryClick(R.id.imageViewLiquidCooling, "Enfriamiento Líquido");
        setupCategoryClick(R.id.imageViewPowerSupplies, "Fuentes de Poder");
        setupCategoryClick(R.id.imageViewFans, "Ventiladores");
    }

    private void setupCategoryClick(int imageViewId, final String category) {
        ImageView imageView = findViewById(imageViewId);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryProductsActivity.class);
                intent.putExtra("category", category);
                startActivity(intent);
            }
        });

    }
}

