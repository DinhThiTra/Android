package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
      TinhBMI();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void TinhBMI(){
        EditText editten, editcannang, editchieucao, editBMI, editchandoan;
        Button btnChandoan;
        btnChandoan=findViewById(R.id.btntinhBMI);
        editten=findViewById(R.id.editten);
        editchieucao=findViewById(R.id.editchieucao);
        editcannang=findViewById(R.id.editcannang);
        editBMI=findViewById(R.id.editBMI);
        editchandoan=findViewById(R.id.editchandoan);
        btnChandoan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (editchieucao.getText().toString().isEmpty() || editcannang.getText().toString().isEmpty()) {
                    editchandoan.setText("Vui lòng nhập chiều cao và cân nặng!");
                    return; // Dừng nếu không có dữ liệu
                }
                double H=Double.parseDouble(editchieucao.getText().toString());
                double W=Double.parseDouble(editcannang.getText().toString());
                double BMI= W/Math.pow(H,2);
                String chandoan="";
                if(BMI<18){
                    chandoan="Bạn gầy!";
                }
                else if(BMI<= 24.9){
                    chandoan="Bạn bình thường";
                } else if (BMI<=29.9) {
                    chandoan="Bạn béo phì độ 1";
                } else if (BMI<=34.9) {
                    chandoan="Bạn béo phì độ 2";
                }else{
                    chandoan="Bạn béo phì độ 3";
                }
                DecimalFormat dcf= new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editchandoan.setText(chandoan);
            }

        });

}
}