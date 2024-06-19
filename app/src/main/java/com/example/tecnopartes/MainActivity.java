package com.example.tecnopartes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;
    private Button buttonLogin;
    private TextView textViewRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewRegister = findViewById(R.id.textViewRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String email = editTextEmail.getText().toString().trim();
                    String password = editTextPassword.getText().toString().trim();

                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Por favor, ingrese el correo y la contraseña", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para verificar las credenciales de inicio de sesión
                        if (isValidUser(email, password)) {
                            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                            startActivity(intent);
                            finish(); // Termina la actividad actual
                        } else {
                            Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    // Captura cualquier excepción y muestra un mensaje de error
                    Toast.makeText(MainActivity.this, "Error al iniciar sesión: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace(); // Imprime la traza de la excepción en Logcat para depuración
                }
            }
        });
    }

    // Método de ejemplo para verificar las credenciales de inicio de sesión
    private boolean isValidUser(String email, String password) {
        // Aquí deberías implementar la lógica real para verificar las credenciales
        // Puedes usar SharedPreferences, Base de datos SQLite, API de autenticación, etc.
        // Este es solo un ejemplo básico
        return email.equals("luis@gmail.com") && password.equals("123");
    }
}