package com.example.databasemrv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databasemrv.extras.DBHelper;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private EditText edtAmount,edtId;
    private Button btnSave,btnReport;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = edtAmount.getText().toString();
                String id = edtId.getText().toString();

                if (amount.isEmpty() && id.isEmpty()){
                    Toast.makeText(context, "Please Enter Details", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean inserted = db.insertData(amount,id);
                    if (inserted){
                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                        edtAmount.setText("");
                        edtId.setText("");
                    }else{
                        Toast.makeText(context, "Not Saved", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ReportActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    public void init(){
        context = getApplicationContext();
        edtAmount = findViewById(R.id.edt_amount);
        edtId = findViewById(R.id.edt_id);
        btnSave = findViewById(R.id.btn_save);
        btnReport = findViewById(R.id.btn_report);
        db = new DBHelper(this);
    }
}