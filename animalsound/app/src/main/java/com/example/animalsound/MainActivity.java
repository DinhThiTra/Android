package com.example.animalsound;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Khai báo ImageView để hiển thị icon và các TextView
    private ImageView imageView;
    private ImageView callIcon;
    private TextView sdt1, sdt2;

    // Tạo mảng các màu và icon
    private int[] colors = {Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA};
    private int[] images = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Liên kết ImageView với layout chính
        imageView = findViewById(R.id.imageView);

        // Tạo đối tượng Random để chọn màu và ảnh ngẫu nhiên
        Random random = new Random();

        // Lấy ngẫu nhiên một màu từ mảng colors
        int randomColor = colors[random.nextInt(colors.length)];

        // Lấy ngẫu nhiên một ảnh từ mảng images
        int randomImage = images[random.nextInt(images.length)];

        // Áp dụng màu nền ngẫu nhiên cho layout chính
        findViewById(R.id.main).setBackgroundColor(randomColor);

        // Áp dụng ảnh ngẫu nhiên cho ImageView
        imageView.setImageResource(randomImage);

        // Xử lý việc hiển thị insets cho hệ thống
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Sử dụng Handler để chuyển đổi layout sau 3 giây
        new Handler().postDelayed(() -> {
            // Chuyển sang layout m001_act_profile
            setContentView(R.layout.m001_act_profile);

            // Gọi phương thức để xử lý sự kiện trên layout mới
            setupProfileLayout();
        }, 3000); // Chuyển đổi sau 3 giây
    }

    private void setupProfileLayout() {
        // Liên kết các View từ layout m001_act_profile
        callIcon = findViewById(R.id.dienthoai); // ImageView icon điện thoại
        sdt1 = findViewById(R.id.sdt1); // TextView chứa số điện thoại 1
        sdt2 = findViewById(R.id.sdt2); // TextView chứa số điện thoại 2

        // Đặt sự kiện onClick cho ImageView gọi điện
        callIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy số điện thoại từ TextView sdt1 hoặc sdt2
                String phoneNumber = sdt1.getText().toString();

                // Kiểm tra xem sdt2 có nội dung hay không, nếu có thì dùng số sdt2
                if (!sdt2.getText().toString().isEmpty()) {
                    phoneNumber = sdt2.getText().toString();
                }

                // Tạo Intent.ACTION_DIAL để mở giao diện quay số
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber)); // Gọi đến số lấy từ TextView
                startActivity(intent);
            }
        });
    }
}
