package com.example.appconglinearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edNum1;
    EditText edNum2;
    EditText edKQ;
    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //Gan bo lang nghe su kien va code xu ly cho tung nut
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyCong();
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyTru();
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyNhan();
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyChia();
            }
        });

    }
    public void TimDieuKhien()
    {
        edNum1 = findViewById(R.id.edtA);
        edNum2 = findViewById(R.id.edtB);
        edKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }
    public void XuLyCong()
    {
        String strA = edNum1.getText().toString();
        String strB = edNum2.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a + b;
        String strTong = String.valueOf(kq);
        //
        edKQ.setText(strTong);


    }
    public void XuLyTru(){

        String strA = edNum1.getText().toString();
        String strB = edNum2.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a - b;
        String strHieu = String.valueOf(kq);
        //
        edKQ.setText(strHieu);
    }
    public void XuLyNhan(){

        String strA = edNum1.getText().toString();
        String strB = edNum2.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a * b;
        String strTich = String.valueOf(kq);
        //
        edKQ.setText(strTich);
    }
    public void XuLyChia(){

        String strA = edNum1.getText().toString();
        String strB = edNum2.getText().toString();

        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a / b;
        String strThuong = String.valueOf(kq);
        //
        edKQ.setText(strThuong);
    }
    public void TimMax(){
        setContentView(R.layout.tim_max);
    }
}