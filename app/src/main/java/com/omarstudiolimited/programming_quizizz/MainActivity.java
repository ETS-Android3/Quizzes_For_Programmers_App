package com.omarstudiolimited.programming_quizizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.omarstudiolimited.programming_quizizz.ui.about.AboutFragment;
import com.omarstudiolimited.programming_quizizz.ui.home.HomeFragment;
import com.omarstudiolimited.programming_quizizz.ui.types_prog_lang.Type_Prog_Lang_Fragment;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,BottomNavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        //drower
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_drwer);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.drwer_about)
                .setDrawerLayout(drawer)
                .build();

        //bottom navigation
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.navigation_prog_lang)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        ImageView sort_img = (ImageView) findViewById(R.id.sort);
        sort_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);

//        navView.setOnNavigationItemReselectedListener(item -> {
//            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.nav_host_fragment);
//            switch (item.getItemId()){
//                case R.id.navigation_prog_lang:
//                    frameLayout.removeAllViews();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
//                            new Type_Prog_Lang_Fragment()).commit();
//                    break;
//
//                case R.id.home:
//                    frameLayout.removeAllViews();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
//                            new HomeFragment()).commit();
//                    break;
//            }
//        });

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.nav_host_fragment);


        switch (item.getItemId()){
            case R.id.home:
                frameLayout.removeAllViews();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new HomeFragment()).addToBackStack(null).commit();
                break;

            case R.id.drwer_about:
                frameLayout.removeAllViews();
//                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                        new AboutFragment()).addToBackStack(null).commit();
                break;

            case R.id.share:
//                Toast.makeText(this, "اختر جهة المشاركة", Toast.LENGTH_SHORT).show();
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.google.com/");
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent,"Share"));
                break;
        }
        return true;
    }
}


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
