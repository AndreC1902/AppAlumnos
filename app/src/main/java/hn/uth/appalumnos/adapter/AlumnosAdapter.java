package hn.uth.appalumnos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hn.uth.appalumnos.databinding.ItemAlumnoBinding;
import hn.uth.appalumnos.entity.Alumno;

public class AlumnosAdapter extends RecyclerView.Adapter<AlumnosAdapter.ViewHolder> {

    private List<Alumno> dataset;

    public AlumnosAdapter(List<Alumno> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public AlumnosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAlumnoBinding binding = ItemAlumnoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnosAdapter.ViewHolder holder, int position) {
        Alumno alumnoactual = dataset.get(position);
        holder.binding.txtNombre.setText(alumnoactual.getNombre());
        holder.binding.txtCuenta.setText(alumnoactual.getCuenta());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemAlumnoBinding binding;
        public ViewHolder(ItemAlumnoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
