package com.example.tinhtoan2so;

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
 EditText edtX, edtY;
 TextView txtsoA, txtsoB,txtResult;
 Button btncong,btntru,btnnhan,btnchia,btnucln, btnthoat;
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
        edtX=findViewById(R.id.edtX);
        edtY=findViewById(R.id.edtY);
        txtsoA=findViewById(R.id.txtsoA);
        txtsoB=findViewById(R.id.txtsoB);
       txtResult=findViewById(R.id.txtResult);
       btncong= findViewById(R.id.btncong);
       btntru=findViewById(R.id.btntru);
       btnnhan=findViewById(R.id.btnnhan);
       btnchia=findViewById(R.id.btnchia);
       btnucln=findViewById(R.id.btnucln);
       btnthoat=findViewById(R.id.btnthoat);
      // xu ly cho nut cong
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });
         btntru.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int x = Integer.parseInt(edtX.getText().toString());
                 int y = Integer.parseInt(edtY.getText().toString());
                 int result = x-y;
                 txtResult.setText(String.valueOf(result));
             }
         });
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int result = x * y;
                txtResult.setText(String.valueOf(result));
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float x = Float.parseFloat(edtX.getText().toString());
                    float y = Float.parseFloat(edtY.getText().toString());
                    if (y != 0) {
                        float result = x / y;
                        txtResult.setText(String.format("%.2f", result)); // Hiển thị kết quả với 2 chữ số thập phân
                    } else {
                        txtResult.setText("Không chia được cho số 0! Chọn số khác.");
                    }
                } catch (NumberFormatException e) {
                    txtResult.setText("Vui lòng nhập số hợp lệ.");
                }
            }
        });

        btnucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Lấy giá trị từ EditText và chuyển đổi thành int
                    String xText = edtX.getText().toString();
                    String yText = edtY.getText().toString();

                    // Kiểm tra nếu các giá trị không rỗng
                    if (!xText.isEmpty() && !yText.isEmpty()) {
                        int x = Integer.parseInt(xText);
                        int y = Integer.parseInt(yText);

                        // Đảm bảo các số không âm và không phải 0
                        if (x > 0 && y > 0) {
                            int ucln = x;
                            int y1 = y;

                            // Thuật toán Euclid để tính ƠCLN
                            while (y1 != 0) {
                                int temp = ucln % y1;
                                ucln = y1;
                                y1 = temp;
                            }

                            txtResult.setText(String.valueOf(ucln));
                        } else {
                            txtResult.setText("Các số phải lớn hơn 0.");
                        }
                    } else {
                        txtResult.setText("Vui lòng nhập đầy đủ số.");
                    }
                } catch (NumberFormatException e) {
                    txtResult.setText("Vui lòng nhập số hợp lệ.");
                }
            }
        });

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}