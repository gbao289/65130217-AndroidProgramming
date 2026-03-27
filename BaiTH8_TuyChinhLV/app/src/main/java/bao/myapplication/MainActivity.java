package bao.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Tim listView
        ListView lvDsMonAn = (ListView) findViewById(R.id.lvDsMonAn);

        //Chuan bi luong du lieu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        dsMonAn.add(new MonAn("Cơm tấm sườn", 25_000,"Cơm tấm sườn siêu ngon có cơm và miếng sườn",R.drawable.cts));
        dsMonAn.add(new MonAn("Cơm tấm sườn", 35_000,"Cơm tấm sườn siêu ngon có cơm và miếng sườn",R.drawable.cg));
        MonAnAdapter adapter = new MonAnAdapter(dsMonAn,this);
        lvDsMonAn.setAdapter(adapter);

        //Bat va xu ly su kien
        lvDsMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Lay phan tu duoic chon
                MonAn monAnChon = dsMonAn.get(position);
                Toast.makeText(MainActivity.this,monAnChon.getTenMonAn(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}