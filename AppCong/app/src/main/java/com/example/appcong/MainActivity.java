package com.example.appcong;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //Set Layout
        setContentView(R.layout.activity_main);
    }
    //Ham Xu Ly Su Kien
    public void XuLyCong(View view){
        //Tim tham chieu cua dieu khien tren giao dien, mapping sang java file
        EditText edNum1 = findViewById(R.id.edtA);
        EditText edNum2 = findViewById(R.id.edtB);
        EditText edKQ = findViewById(R.id.edtKQ);
        //Lay du lieu
        String strA = edNum1.getText().toString();
        String strB = edNum2.getText().toString();
        //Chuyen du lieu tu kieu chuoi sang So
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        //Thuc hien tinh toan
        int KQ = a + b;
        String strTong = String.valueOf(KQ); // Chuyen du lieu sang dang chuoi
        //Hien thi ra man hinh
        edKQ.setText(strTong);

    }
}