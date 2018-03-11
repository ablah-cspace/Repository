package wsu.library_application;

import android.content.Intent;
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
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        Intent int4 = new Intent(getApplicationContext(), Resources.class);
        startActivity(int4);

    }
}
