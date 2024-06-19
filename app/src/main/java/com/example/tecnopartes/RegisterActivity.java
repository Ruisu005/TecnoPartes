package com.example.tecnopartes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextFirstName, editTextLastName, editTextEmailRegister, editTextUsername, editTextPasswordRegister;
    private Spinner spinnerAge, spinnerStates;
    private GridLayout gridLayoutCategories;
    private CheckBox checkBoxTerms, checkBoxNotifications;
    private Button buttonRegister;
    private List<CheckBox> categoryCheckBoxes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmailRegister = findViewById(R.id.editTextEmailRegister);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPasswordRegister = findViewById(R.id.editTextPasswordRegister);
        spinnerAge = findViewById(R.id.spinnerAge);
        spinnerStates = findViewById(R.id.spinnerStates);
        gridLayoutCategories = findViewById(R.id.gridLayoutCategories);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);
        checkBoxNotifications = findViewById(R.id.checkBoxNotifications);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Populate age spinner
        Integer[] ages = new Integer[81];
        for (int i = 0; i < 81; i++) {
            ages[i] = i + 10;
        }
        ArrayAdapter<Integer> ageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ages);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(ageAdapter);

        // Populate states spinner
        String[] states = {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua",
                "Ciudad de México", "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México",
                "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí",
                "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
        ArrayAdapter<String> statesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        statesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStates.setAdapter(statesAdapter);

        // Populate category checkboxes
        for (int i = 0; i < gridLayoutCategories.getChildCount(); i++) {
            View view = gridLayoutCategories.getChildAt(i);
            if (view instanceof CheckBox) {
                categoryCheckBoxes.add((CheckBox) view);
            }
        }

        // Set up register button click listener
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxTerms.isChecked()) {
                    // Check selected categories
                    int selectedCount = 0;
                    for (CheckBox checkBox : categoryCheckBoxes) {
                        if (checkBox.isChecked()) {
                            selectedCount++;
                        }
                    }

                    if (selectedCount > 5) {
                        Toast.makeText(RegisterActivity.this, "Puedes seleccionar hasta 5 categorías", Toast.LENGTH_SHORT).show();
                    } else {
                        // Do registration logic here
                        Toast.makeText(RegisterActivity.this, "Registrado exitosamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}