package com.example.chuyennhiet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView textview1, textview2;
EditText txtfar, txtcel;
Button btnfar, btncel, btnclean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initControl(){
        textview1=findViewById(R.id.textview1);
        textview2=findViewById(R.id.textview2);
        txtcel=findViewById(R.id.txtCel);
        txtfar=findViewById(R.id.txtFar);
        btnfar=findViewById(R.id.btnfar);
        btncel=findViewById(R.id.btncel);
        btnclean=findViewById(R.id.btnclean);
       btncel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             String far= txtfar.getText().toString();
             if(!far.isEmpty()){
                 double farr= Double.parseDouble(far);
                 double cel=(farr-32)*5/9;
                 txtcel.setText(String.format("%.1f", cel));

             }
           }
       });
       btnfar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String cel= txtcel.getText().toString();
               if(!cel.isEmpty()){
                   double cell =Double.parseDouble(cel);
                   double far=cell*9/5+32;
                   txtfar.setText(String.format("%.1f", far));
               }
           }
       });
       btnclean.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               txtfar.setText("");
               txtcel.setText("");
           }
       });
    }
}