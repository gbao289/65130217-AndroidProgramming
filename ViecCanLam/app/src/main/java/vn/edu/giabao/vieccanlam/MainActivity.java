package vn.edu.giabao.vieccanlam;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<TASKS> lstVCL;
    private TaskAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Tìm và thiết lập RecyclerView
        recyclerView = findViewById(R.id.rcvVCL); //
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Khởi tạo danh sách và Adapter
        lstVCL = new ArrayList<>();
        adapter = new TaskAdapter(lstVCL);
        recyclerView.setAdapter(adapter);

        //Kết nối Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("TASKS");
        
        //Lắng nghe dữ liệu
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Xóa danh sách cũ trước khi thêm dữ liệu mới để tránh bị lặp
                lstVCL.clear();

                for (DataSnapshot obj : dataSnapshot.getChildren()) {
                    TASKS task = obj.getValue(TASKS.class);
                    if (task != null) {
                        lstVCL.add(task);
                    }
                }

                // Thông báo cho Adapter biết dữ liệu đã thay đổi để vẽ lại giao diện
                adapter.notifyDataSetChanged();
                Log.d("VCL app", "Đã cập nhật " + lstVCL.size() + " công việc.");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("VCL app", "Lỗi kết nối Firebase: " + error.getMessage());
            }
        });
    }
}