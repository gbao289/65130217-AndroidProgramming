package thigk2.volegiabao.thigk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ChucNang3Fragment extends Fragment {

    private ListView lvTourist;
    private ArrayList<TouristAttraction> dsDiemDuLich;

    public ChucNang3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuc_nang3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvTourist = view.findViewById(R.id.lvTourist);

        // Hard-code dữ liệu cho 5 địa điểm du lịch Nha Trang
        dsDiemDuLich = new ArrayList<>();
        // Sử dụng tạm ic_launcher_background làm ảnh đại diện vì chưa có ảnh thật trong drawable
        dsDiemDuLich.add(new TouristAttraction("VinWonders Nha Trang", "Đảo Hòn Tre, Vĩnh Nguyên, Nha Trang", R.drawable.vinwonder));
        dsDiemDuLich.add(new TouristAttraction("Tháp Bà Ponagar", "Đường 2/4, Vĩnh Phước, Nha Trang", R.drawable.thapbaponagar));
        dsDiemDuLich.add(new TouristAttraction("Chùa Long Sơn", "20 Đường 23/10, Phương Sơn, Nha Trang", R.drawable.chualongson));
        dsDiemDuLich.add(new TouristAttraction("Viện Hải dương học", "01 Cầu Đá, Nha Trang", R.drawable.vienhaiduonghoc));
        dsDiemDuLich.add(new TouristAttraction("Bãi biển Nha Trang", "Dọc đường Trần Phú, Nha Trang", R.drawable.baibiennhatrang));

        TouristAdapter adapter = new TouristAdapter(
                getContext(),
                R.layout.item_tourist_attraction,
                dsDiemDuLich
        );

        lvTourist.setAdapter(adapter);
    }
}