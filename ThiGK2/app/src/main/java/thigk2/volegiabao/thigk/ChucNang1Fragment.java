package thigk2.volegiabao.thigk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChucNang1Fragment extends Fragment {

    private EditText edtChieuDai, edtChieuRong;
    private Button btnChuVi, btnDienTich;
    private TextView tvKetQua;

    public ChucNang1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chuc_nang1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Ánh xạ các thành phần từ giao diện XML
        edtChieuDai = view.findViewById(R.id.edtChieuDai);
        edtChieuRong = view.findViewById(R.id.edtChieuRong);
        btnChuVi = view.findViewById(R.id.btnChuVi);
        btnDienTich = view.findViewById(R.id.btnDienTich);
        tvKetQua = view.findViewById(R.id.tvKetQua);

        // 2. Thiết lập sự kiện khi nhấn nút "Tính Chu Vi"
        btnChuVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan(true); // true là tính chu vi
            }
        });

        // 3. Thiết lập sự kiện khi nhấn nút "Tính Diện Tích"
        btnDienTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan(false); // false là tính diện tích
            }
        });
    }

    private void tinhToan(boolean laChuVi) {
        String strDai = edtChieuDai.getText().toString();
        String strRong = edtChieuRong.getText().toString();

        // Kiểm tra xem người dùng đã nhập đủ chưa
        if (strDai.isEmpty() || strRong.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng nhập đủ chiều dài và chiều rộng", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double dai = Double.parseDouble(strDai);
            double rong = Double.parseDouble(strRong);
            double ketQua;

            if (laChuVi) {
                // Công thức chu vi: (dài + rộng) * 2
                ketQua = (dai + rong) * 2;
                tvKetQua.setText("Chu vi là: " + ketQua);
            } else {
                // Công thức diện tích: dài * rộng
                ketQua = dai * rong;
                tvKetQua.setText("Diện tích là: " + ketQua);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}