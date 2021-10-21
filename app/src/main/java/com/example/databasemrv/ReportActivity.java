package com.example.databasemrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.databasemrv.extras.DBHelper;
import com.example.databasemrv.extras.ReportAdapter;
import com.example.databasemrv.extras.ReportObject;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
    private Context context;
    private ArrayList<ReportObject> arrayList;
    private ReportAdapter adapter;
    private RecyclerView recyclerView;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        context = getApplicationContext();
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView_report);
        db = new DBHelper(this);


//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));
//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));
//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));
//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));
//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));
//        arrayList.add(new ReportObject("100001","2000.00","20/10/2021"));

        getData();

    }

    public void getData(){
        Cursor cursor = db.getData();
        cursor.isBeforeFirst();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Entry Available", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                String date = cursor.getString(0);
                String amount = cursor.getString(1);
                String id = cursor.getString(2);
                arrayList.add(new ReportObject(id,amount,date));
            }

            LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            adapter = new ReportAdapter(context,arrayList);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }
    }
}