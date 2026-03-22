package bao.myapplication;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ArrayList<String> dsMonan = new ArrayList<>(); // Khai bao, khoi tao
        //Add du lieu
        dsMonan.add("Com chien duong chau");
        dsMonan.add("Banh mi");
        dsMonan.add("Pho bo");
        dsMonan.add("...");
        dsMonan.add("...");
        dsMonan.add("...");
        //Khai bao, khoi tao adapter
        ArrayAdapter<String> adapterDsmonan;
        adapterDsmonan = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dsMonan);

        //Tim dieu khien va hien thi
        ListView lvdsMonan = findViewById(R.id.lvdsMonan);
        lvdsMonan.setAdapter(adapterDsmonan);



    }
}