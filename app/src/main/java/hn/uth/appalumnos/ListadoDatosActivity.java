package hn.uth.appalumnos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import hn.uth.appalumnos.adapter.AlumnosAdapter;
import hn.uth.appalumnos.databinding.ActivityListadoDatosBinding;
import hn.uth.appalumnos.entity.Alumno;

public class ListadoDatosActivity extends AppCompatActivity implements OnItemClickListener<Alumno> {

    private ActivityListadoDatosBinding binding;
    private AlumnosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListadoDatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(view -> {
           Intent intento = new Intent(this.getBaseContext(), MainActivity.class);
           startActivity(intento);
        });
        List<Alumno> listadoAlumnos = new ArrayList<>();
        listadoAlumnos.add(new Alumno("Pedro Perez","202010020045","pedrop8@gnail.com","Masculino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Juan Fernandez","202210020045", "juanf@gnail.com","Masculino","Tegucigalpa"));
        listadoAlumnos.add(new Alumno("Rosario Dominguez","201910020045", "rosariod@gnail.com","Femenino","Choloma"));
        listadoAlumnos.add(new Alumno("Juan Castro","202210020045", "juanc@gnail.com","Masculino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Lucia Hernandez","202010130045", "luciah@gnail.com","Fememino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Lilian Cerrato","202130020045", "lilianc@gnail.com","Femenino","Choluteca"));
        listadoAlumnos.add(new Alumno("Carlos Castro","201810120045", "carlosc@gnail.com","Masculino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Roberto Contreras","201510420045", "robertoc@gnail.com","Masculino","Santa Barbara"));
        listadoAlumnos.add(new Alumno("Julio Perdomo","201010120025", "juliop@gnail.com","Masculino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Sofia Lanza","202010120035", "sofial@gnail.com","Femenino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Maria Perez","202010120045", "mariap@gnail.com","Femenino","La Ceiba"));
        listadoAlumnos.add(new Alumno("Juana Fernandez","202310020045", "juanaf@gnail.com","Femenino","El Progreso"));
        listadoAlumnos.add(new Alumno("Omar Dominguez","200820020045", "omard@gnail.com","Masculino","Roatan"));
        listadoAlumnos.add(new Alumno("Lucia Castro","201910020045", "luciac@gnail.com","Femenino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Marcela Hernandez","202110130045", "marcelah@gnail.com","Femenino","Tegucigalpa"));
        listadoAlumnos.add(new Alumno("Juan Cerrato","202230020045", "juanc@gnail.com","Masculino","San Pedro Sula"));
        listadoAlumnos.add(new Alumno("Francisco Castro","202310120045", "franciscoc@gnail.com","Masculino","El Progreso"));
        listadoAlumnos.add(new Alumno("Antonio Contreras","202110420045", "antonioc@gnail.com","Masculino","La Ceiba"));
        listadoAlumnos.add(new Alumno("Grecia Perdomo","201210122025", "greciap@gnail.com","Femenino","Choloma"));
        listadoAlumnos.add(new Alumno("Valeria Lanza","201510020035", "valerial@gnail.com","Femenino","San Pedro Sula"));

        adapter = new AlumnosAdapter(listadoAlumnos, this);
        setupRecyclerView();
    }
    private void setupRecyclerView(){
        LinearLayoutManager linearLayout = new LinearLayoutManager(this.getApplicationContext());
        binding.contentlistado.rvDatos.setLayoutManager(linearLayout);
        binding.contentlistado.rvDatos.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Alumno data) {
        Intent intento = new Intent(this.getBaseContext(), MainActivity.class);
        intento.putExtra("ALUMNO-NOMBRE", data.getNombre());
        intento.putExtra("ALUMNO-CUENTA", data.getCuenta());
        intento.putExtra("ALUMNO-CORREO", data.getCorreo());
        intento.putExtra("ALUMNO-GENERO", data.getGenero());
        intento.putExtra("ALUMNO-CAMPUS", data.getCampus());
        startActivity(intento);
    }
}