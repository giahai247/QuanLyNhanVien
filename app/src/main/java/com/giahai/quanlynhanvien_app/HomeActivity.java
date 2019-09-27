package com.giahai.quanlynhanvien_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.giahai.quanlynhanvien_app.ui.login.LoginActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView tvHome;
    private ImageView profileImage;

    private RecyclerView recyclerView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvHome = (TextView) findViewById(R.id.tvHome);
        profileImage = (ImageView) findViewById(R.id.profile_image);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        button = (Button) findViewById(R.id.button);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
            }
        });
    }
    private void showMenu(){
        PopupMenu popupMenu = new PopupMenu(this,profileImage);
        popupMenu.getMenuInflater().inflate(R.menu.menu_logout,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.logout:
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        finish();
                        break;
                    case  R.id.profile:
                        startActivity(new Intent(HomeActivity.this, ProfileActivity.class));

                        break;

                }
                return false;
            }
        });
        popupMenu.show();
    }
}
