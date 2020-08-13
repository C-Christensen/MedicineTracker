package com.example.mycapstoneproject;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineHolder> {
    private List<Medicine> medicines = new ArrayList<>();



    @NonNull
    @Override
    public MedicineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.medicine_item, parent, false);
        return new MedicineHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineHolder holder, int position) {
        Medicine currentMedicine = medicines.get(position);
        holder.textViewName.setText(currentMedicine.getName());
        holder.timestamp.setText(currentMedicine.getTimestamp());
        holder.quantity.setText(String.valueOf(currentMedicine.getQuantity()));
        holder.type.setText(String.valueOf(currentMedicine.getType()));

        holder.dot.setText(Html.fromHtml("&#FF0000;"));
    }

    @Override
    public int getItemCount() {
        return medicines.size();
    }

    public void setMedicines(List<Medicine> medicines){
        this.medicines = medicines;
        notifyDataSetChanged();
    }

    public Medicine getMedicineAt(int position){
        return medicines.get(position);
    }

    class MedicineHolder extends RecyclerView.ViewHolder{
        private TextView textViewName;
        private TextView timestamp;
        private TextView quantity;
        private TextView type;
        private TextView dot;
       // private ImageView mThumbnailImage;

        public MedicineHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            timestamp = itemView.findViewById(R.id.text_view_timestamp);
            quantity = itemView.findViewById(R.id.text_view_quantity);
            type = itemView.findViewById(R.id.text_view_type);
            dot = itemView.findViewById(R.id.dot);
        }
    }


}
