package com.example.lab011;

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
    EditText txtX, txtY;//nhập X,Y
    TextView txtResult; //Hiển thị kết quả
    Button btnPlus, btnMinus, btnMultiply, btnDivide, btnPercent; //Nút +,-,*,/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // gọi phương thức innitControl
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }

    private void initControl() {
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnPercent = findViewById(R.id.btnPercent);
        //Xử lý sự kiên nút phép cộng
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x + y;

                txtResult.setText(String.valueOf(result));
            }
        });

        // Xử lý sự kiện nút phép trừ
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x - y;
                txtResult.setText(String.valueOf(result));
            }
        });

        // Xử lý nút phép nhân
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x * y;
                txtResult.setText(String.valueOf(result));
            }
        });
        //Xử lý nút phép chia
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(txtX.getText().toString());
                float y = Float.parseFloat(txtY.getText().toString());
                if (y != 0) {
                    float result = x / y;
                    txtResult.setText(String.valueOf(result));
                } else {
                    txtResult.setText(" Khong chia duoc cho so 0. Moi nhap so bi chia khac 0 !");
                }
            }
        });

        // Xử lý sự kiên tính %
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = Float.parseFloat(txtX.getText().toString());
                float y = Float.parseFloat(txtY.getText().toString());
                if ( y!=0 )
                {
                    float result = x%y;
                    txtResult.setText(String.valueOf(result) +"%");
                }
                else {
                    txtResult.setText(" Khong the chia phan tram cho so 0. Moi nhap so bi chia khac 0");
                }
            }
        });
    }
}
