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

    private ViewPager viewPagerFeaturedProducts;
    private ViewPager viewPagerSponsorBrands;
    private GridView gridViewCategories;

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

        viewPagerFeaturedProducts = findViewById(R.id.viewPagerFeaturedProducts);
        viewPagerSponsorBrands = findViewById(R.id.viewPagerSponsorBrands);

        GridLayout gridLayoutCategories = findViewById(R.id.gridLayoutCategories);

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

        FeaturedProductsAdapter featuredProductsAdapter = new FeaturedProductsAdapter(this);
        SponsorBrandsAdapter sponsorBrandsAdapter = new SponsorBrandsAdapter(this);

        viewPagerFeaturedProducts.setAdapter(featuredProductsAdapter);
        viewPagerSponsorBrands.setAdapter(sponsorBrandsAdapter);

        // Configurar clics en las categorías
        for (int i = 0; i < gridLayoutCategories.getChildCount(); i++) {
            View child = gridLayoutCategories.getChildAt(i);
            if (child instanceof ImageView) {
                final String categoryName = getCategoryNameFromIndex(i); // Método para obtener el nombre de la categoría
                child.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Abrir CategoryProductsActivity y pasar el nombre de la categoría como extra
                        Intent intent = new Intent(CategoriesActivity.this, CategoryProductsActivity.class);
                        intent.putExtra(CategoryProductsActivity.EXTRA_CATEGORY_NAME, categoryName);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    // Método para obtener el nombre de la categoría según el índice
    private String getCategoryNameFromIndex(int index) {
        switch (index) {
            case 0: return "Procesadores";
            case 1: return "Tarjetas Gráficas";
            case 2: return "RAM";
            case 3: return "Tarjetas Madres";
            case 4: return "Gabinetes";
            case 5: return "Almacenamiento";
            case 6: return "Enfriamiento de Aire";
            case 7: return "Enfriamiento Líquido";
            case 8: return "Fuentes de Poder";
            case 9: return "Ventiladores";
            default: return "";
        }
    }

}