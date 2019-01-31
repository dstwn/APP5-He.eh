package id.dstwn.pantiq.activity.dashboard;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.auth.login.LoginActivity;
import id.dstwn.pantiq.activity.dashboard.bookmark.BookmarkActivity;
import id.dstwn.pantiq.activity.dashboard.profile.ProfileActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static id.dstwn.pantiq.R.*;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;
    List<Data> dataList = new ArrayList<>();

    Menu btn_logout;
    TextView txt_nama, txt_username, txt_id;
    String id,username,nameuser;
    SharedPreferences sharedPreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_NAMEUSER = "nameuser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Toolbar toolbar = setToolbar();

        drawer(toolbar);
        navigationView();
        setTanggalan();

        RecycleMenu();
        SetListKabupaten();
        kabAdapter();
        
        getDataUser();

    }

    void getDataUser() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hv = navigationView.getHeaderView(0);

        txt_nama = (TextView) hv.findViewById(R.id.txt_nama_pn);
        txt_username =(TextView) hv.findViewById(R.id.txt_username_pn);
        txt_id = (TextView) hv.findViewById(R.id.txt_id_pn);
        btn_logout = (Menu) hv.findViewById(R.id.nav_logout);

        sharedPreferences = getSharedPreferences(LoginActivity.sharedPref, Context.MODE_PRIVATE);

        username = getIntent().getStringExtra(TAG_USERNAME);
        nameuser = getIntent().getStringExtra(TAG_NAMEUSER);
        id = getIntent().getStringExtra(TAG_ID);


        txt_id.setText("ID : "+ id);
        txt_username.setText(username);
        txt_nama.setText(nameuser);

    }

    void RecycleMenu() {
        recyclerView = (RecyclerView) findViewById(R.id.daftarKab);
        recyclerView.setLayoutManager(setLayout());
    }

    void SetListKabupaten() {
        String kabupaten[] = getResources().getStringArray(array.dataKab);
        TypedArray img = getResources().obtainTypedArray(array.imageKab);

        dataList.clear();
        for (int a = 0 ; a < kabupaten.length ; a++){
            dataList.add(new Data(kabupaten[a],img.getResourceId(a,-1)));
        }
    }

    void kabAdapter() {
        mainAdapter = new MainAdapter(this,dataList);
        recyclerView.setAdapter(mainAdapter);
    }


    private RecyclerView.LayoutManager setLayout() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return linearLayoutManager;
    }

    void setTanggalan() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, d MMMM YYYY");
        String formate = simpleDateFormat.format(c.getTime());
        TextView tgl = (TextView)findViewById(R.id.tglecuk);
        tgl.setText(formate);
    }

    @SuppressLint("RestrictedApi")
    Toolbar setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(null);
        actionBar.setHomeAsUpIndicator(drawable.ic_menu_nav);
        actionBar.setDisplayHomeAsUpEnabled(true);

        return toolbar;
    }

    private void navigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void drawer(Toolbar toolbar) {
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, string.navigation_drawer_open, string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
           Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
           startActivity(i);

        } else if (id == R.id.nav_bookmark) {
            Intent i = new Intent(getApplicationContext(),BookmarkActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_logout) {

            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LoginActivity.session_status, false);
        editor.putString(TAG_ID, null);
        editor.putString(TAG_USERNAME, null);
        editor.putString(TAG_NAMEUSER,null);
        editor.commit();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
