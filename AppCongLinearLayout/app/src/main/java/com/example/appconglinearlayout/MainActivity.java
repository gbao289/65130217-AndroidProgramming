package com.example.appconglinearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edNum1;
    EditText edNum2;
    EditText edKQ;
    String strA,strB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        LayGiaTriKieuChuoi();
    }
    public void TimDieuKhien()
    {
        edNum1 = findViewById(R.id.edtA);
        edNum2 = findViewById(R.id.edtB);
        edKQ = findViewById(R.id.edtKQ);
    }
    public void LayGiaTriKieuChuoi(){
        strA = edNum1.getText().toString();
        strB = edNum2.getText().toString();
    }
    public void XuLyCong(View view)
    {
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a + b;
        String strTong = String.valueOf(kq);
        //
        edKQ.setText(strTong);


    }
    public void XuLyTru(View view){
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a - b;
        String strHieu = String.valueOf(kq);
        //
        edKQ.setText(strHieu);
    }
    public void XuLyNhan(View view){
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a * b;
        String strTich = String.valueOf(kq);
        //
        edKQ.setText(strTich);
    }
    public void XuLyChia(View view){
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //
        int kq = a / b;
        String strThuong = String.valueOf(kq);
        //
        edKQ.setText(strThuong);
    }

}