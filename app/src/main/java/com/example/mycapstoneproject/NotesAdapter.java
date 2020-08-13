package com.example.mycapstoneproject;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Note> notesList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView note;
        TextView dot;
        TextView timestamp;

        MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.note);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }


    NotesAdapter(Context context, List<Note> notesList) {
        Context context1 = context;
        this.notesList = notesList;
    }

    @NonNull

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.note.setText(note.getNote());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String timestamp = currentDateTimeString;

        // Formatting and displaying timestamp
        holder.timestamp.setText(note.getTimestamp());



    }


    public int getItemCount() {
        return notesList.size();
    }


}
