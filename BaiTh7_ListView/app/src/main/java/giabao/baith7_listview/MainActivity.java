package giabao.baith7_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Hien thi du lieu len ListView
        //B1 Khai bao bien, them du lieu
        ArrayList<String> dsTenTinhThanhVN; // Khai Bao
        dsTenTinhThanhVN = new ArrayList<String>();
        //Them Du Lieu
        dsTenTinhThanhVN.add("Ha Noi");
        dsTenTinhThanhVN.add("Thanh pho Ho Chi Minh");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Hai Phong");
        dsTenTinhThanhVN.add("Da Nang");
        //B2 tao adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsTenTinhThanhVN);
        //B3 Gan vao dieu khien hien thi listView
        //3.1 Tim dieu khien
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        //3.2 Gan
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 Lang nghe va xu ly su kien


        AdapterView.OnItemClickListener BoLangNghevaXl = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Code xu ly o day
                // position la vi tri phan tu duoc click
                // vi du hien thi 1 tin nhan len mang hinh
                Toast.makeText(MainActivity.this, "Ban vua chon " + dsTenTinhThanhVN.get(position) , Toast.LENGTH_LONG).show();
            }
        };
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXl);
    }

    }