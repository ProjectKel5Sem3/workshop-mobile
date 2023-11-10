package com.example.vioscake;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavbarFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar_page);
        loadFragment(new Home());

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            if (item.getItemId() == R.id.navigation_home) {
                fragment = new Home();
            } else if (item.getItemId() == R.id.navigation_katalog) {
                fragment = new Katalog();
            } else if (item.getItemId() == R.id.navigation_notifications) {
                fragment = new Notifications();
            } else if (item.getItemId() == R.id.navigation_account) {
                fragment = new Profile();
            }

            if (fragment != null) {
                for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
                    MenuItem otherItem = bottomNavigationView.getMenu().getItem(i);
                    if (otherItem.getItemId() == item.getItemId()) {
                        // Highlight the selected item
                        otherItem.setChecked(true);
                        otherItem.setIconTintList(getResources().getColorStateList(R.color.selected_icon_color));
                    } else {
                        // Unhighlight other items
                        otherItem.setChecked(false);
                        otherItem.setIconTintList(getResources().getColorStateList(R.color.unselected_icon_color));
                    }
                }

                // Load the selected fragment
                loadFragment(fragment);
                return true;  // Keluar dari metode setelah menangani item yang dipilih
            }

            return false;
        }
    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment == null) {
            return false;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();

        return true;
    }
}