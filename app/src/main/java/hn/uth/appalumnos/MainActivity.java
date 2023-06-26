package hn.uth.appalumnos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import hn.uth.appalumnos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.toolbarDetail.setTitle(R.string.title_alumno_create);
        obtenerIntentData(getIntent());

        binding.btnGuardar.setOnClickListener(v -> {
            String cuenta = binding.tilCuenta.getEditText().getText().toString();

            if(cuenta.length() > 20){
                Snackbar.make(binding.getRoot(), "Número de Cuenta invalido", Snackbar.LENGTH_SHORT).show();
                binding.tilCuenta.setError("Número de Cuenta invalido");
            }else{
                binding.tilCuenta.setError(null);
            }
        });
    }

    private void obtenerIntentData(Intent intent) {
        String cuenta = intent.getStringExtra("ALUMNO-CUENTA");
        if(cuenta != null && !"".equals(cuenta)){
            String nombre = intent.getStringExtra("ALUMNO-NOMBRE");
            String correo = intent.getStringExtra("ALUMNO-CORREO");
            String genero = intent.getStringExtra("ALUMNO-GENERO");
            String campus = intent.getStringExtra("ALUMNO-CAMPUS");
            binding.tilCuenta.getEditText().setText(cuenta);
            binding.tilNombre.getEditText().setText(nombre);
            binding.tilCorreo.getEditText().setText(correo);
            binding.tilCampus.getEditText().setText(campus);

            if("Femenino".equalsIgnoreCase(genero)){
                binding.tbGenero.setChecked(true);
            }else{
                binding.tbGenero.setChecked(false);
            }
            binding.toolbarDetail.setTitle(R.string.title_alumno_view);
        }
    }
}