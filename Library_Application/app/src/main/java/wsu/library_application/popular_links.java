package wsu.library_application;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class popular_links extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_links);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotofeedback(View view) {
        Intent feedback = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/1WsKHJYQgQgNqGy1RIzCOYM8Y_VhX64k_Qk0q6kskZSs/edit?ts=5aafe691"));
       // Intent feedback = new Intent(getApplicationContext(), Circulation.class);
        startActivity(feedback);

    }

    public void gotocirculation(View view) {
        //Intent circulation = new Intent(Intent.ACTION_VIEW, Uri.parse("http://libresources.wichita.edu/Circulation/libservices"));
        Intent circulation = new Intent(getApplicationContext(), Circulation.class);
        startActivity(circulation);

    }

    public void goto_time(View view){
        Intent time = new Intent(getApplicationContext(), Timings.class);
        startActivity(time);
    }
    public void gotocspace(View view) {

        Intent int11 = new Intent(getApplicationContext(), cspace.class);
        startActivity(int11);
    }
    public void gotointerloan(View view) {

        Intent int12 = new Intent(getApplicationContext(), Interloan.class);
        startActivity(int12);
    }
    public void onClickOnlineCatalog(View view){
        Intent int13 = new Intent(getApplicationContext(), BookFinder.class);
        startActivity(int13);
    }
    public void gotoevents(View view) {
        Intent int14 = new Intent(getApplicationContext(), events.class);
        startActivity(int14);
    }

    public void gotorenewitem(View view) {
        Intent int15 = new Intent(getApplicationContext(), renew_items.class);
        startActivity(int15);
    }


}
