package com.example.tecnopartes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryProductsActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_NAME = "category_name";

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_products);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        // Obtener el nombre de la categoría seleccionada
        String categoryName = getIntent().getStringExtra(EXTRA_CATEGORY_NAME);

        // Simular datos de productos para la categoría seleccionada (ejemplo)
        // Aquí debes reemplazar con tus datos reales o lógica para obtener productos
        if ("Procesadores".equals(categoryName)) {
            productList.add(new Product("Intel Core i9-12900K", "Intel", "Procesadores", 699.99, R.drawable.intel_core_i9_12900k));
            productList.add(new Product("AMD Ryzen 9 5900X", "AMD", "Procesadores", 549.99, R.drawable.amd_ryzen_9_5900x));
            productList.add(new Product("Intel Core i7-12700K", "Intel", "Procesadores", 429.99, R.drawable.intel_core_i7_12700k));
            productList.add(new Product("AMD Ryzen 5 5600X", "AMD", "Procesadores", 299.99, R.drawable.amd_ryzen_5_5600x));
            productList.add(new Product("Intel Core i5-12600K", "Intel", "Procesadores", 249.99, R.drawable.intel_core_i5_12600k));
        } else if ("Tarjetas Gráficas".equals(categoryName)) {
            productList.add(new Product("Nvidia GeForce RTX 3080", "Nvidia", "Tarjetas Gráficas", 799.99, R.drawable.nvidia_geforce_rtx_3080));
            productList.add(new Product("AMD Radeon RX 6900 XT", "AMD", "Tarjetas Gráficas", 999.99, R.drawable.amd_radeon_rx_6900_xt));
            productList.add(new Product("Nvidia GeForce RTX 3060 Ti", "Nvidia", "Tarjetas Gráficas", 399.99, R.drawable.nvidia_geforce_rtx_3060_ti));
            productList.add(new Product("AMD Radeon RX 6700 XT", "AMD", "Tarjetas Gráficas", 479.99, R.drawable.amd_radeon_rx_6700_xt));
            productList.add(new Product("Nvidia GeForce RTX 3070", "Nvidia", "Tarjetas Gráficas", 499.99, R.drawable.nvidia_geforce_rtx_3070));
        }
        // Añadir más productos para otras categorías aquí...

        // Configurar el adaptador para el RecyclerView
        productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);
    }
}