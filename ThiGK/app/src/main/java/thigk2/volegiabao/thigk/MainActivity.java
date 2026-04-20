package thigk2.volegiabao.thigk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);


        if (savedInstanceState == null) {
            loadFragment(new ChucNang1Fragment());
        }

        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_tinhtoan) {
                selectedFragment = new ChucNang1Fragment();
            } else if (itemId == R.id.nav_danhmuc) {
                selectedFragment = new ChucNang2Fragment();
            } else if (itemId == R.id.nav_dulich) {
                selectedFragment = new ChucNang3Fragment();
            } else if (itemId == R.id.nav_profile) {
                selectedFragment = new ChucNang4Fragment();
                return true;
            }

            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }
            return false;
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}