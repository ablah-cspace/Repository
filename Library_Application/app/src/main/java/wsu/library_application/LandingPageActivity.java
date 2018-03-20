package wsu.library_application;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class LandingPageActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



       // startActivity(new Intent(this.getApplicationContext(),SmartSearchActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        /*
        switch (item.getItemId()) {
            case R.id.cspace:
                fragment = new CSpaceFragment();
        }

        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, fragment); // replace a Fragment with Frame Layout
            transaction.commit(); // commit the changes
            drawerLayout.closeDrawers();
        }
        */
        return true;
    }



    public void gotopop_link(View view)
    {
        Intent int3 = new Intent(getApplicationContext(), popular_links.class);
        startActivity(int3);

    }
    public void onTapContactUs(View view){
        //startActivity(new Intent(this.getApplicationContext(),SmartSearchActivity.class));
    }

    public void gotoresources(View view) {
        Intent int4 = new Intent(getApplicationContext(), lib_resources.class);
        startActivity(int4);

    }
    public void gotoabout_lib(View view) {
        Intent int5 = new Intent(getApplicationContext(), about_lib.class);
        startActivity(int5);

    }

    public void gotohelp_resources(View view) {
        Intent int5 = new Intent(getApplicationContext(), Help_research.class);
        startActivity(int5);

    }




}
