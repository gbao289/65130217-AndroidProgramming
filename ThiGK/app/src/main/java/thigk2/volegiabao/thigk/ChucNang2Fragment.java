package thigk2.volegiabao.thigk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChucNang2Fragment extends Fragment {

    private ListView lvThanhPho;
    private ArrayList<String> dsThanhPho;

    public ChucNang2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuc_nang2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Ánh xạ ListView
        lvThanhPho = view.findViewById(R.id.lvThanhPho);

        // 2. Tạo dữ liệu Hard-code (10 thành phố)
        dsThanhPho = new ArrayList<>();
        dsThanhPho.add("Hà Nội");
        dsThanhPho.add("TP. Hồ Chí Minh");
        dsThanhPho.add("Đà Nẵng");
        dsThanhPho.add("Hải Phòng");
        dsThanhPho.add("Cần Thơ");
        dsThanhPho.add("Huế");
        dsThanhPho.add("Nha Trang");
        dsThanhPho.add("Đà Lạt");
        dsThanhPho.add("Quy Nhơn");
        dsThanhPho.add("Võ Lê Gia Bảo"); // Thành phố đặc biệt

        // 3. Tạo Adapter để hiển thị dữ liệu lên ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1, // Layout mặc định của Android
                dsThanhPho
        );

        // 4. Gắn Adapter vào ListView
        lvThanhPho.setAdapter(adapter);

        // 5. Thêm sự kiện click (tùy chọn) để xem tên thành phố
        lvThanhPho.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedCity = dsThanhPho.get(position);
            Toast.makeText(getContext(), "Bạn chọn: " + selectedCity, Toast.LENGTH_SHORT).show();
        });
    }
}