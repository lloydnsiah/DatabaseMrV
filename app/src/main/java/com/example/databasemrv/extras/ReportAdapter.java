package com.example.databasemrv.extras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.databasemrv.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ReportObject> arrayList;

    public ReportAdapter(Context context, ArrayList<ReportObject> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(arrayList.get(position).getId());
        holder.amount.setText("GHS " + arrayList.get(position).getAmount());
        holder.date.setText(arrayList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id,amount,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.report_id);
            amount =itemView.findViewById(R.id.report_amount);
            date = itemView.findViewById(R.id.report_date);
        }
    }
}
