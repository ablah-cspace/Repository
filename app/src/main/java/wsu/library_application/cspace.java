package wsu.library_application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class cspace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cspace);
    }

    public void gotoservices(View view){
        Intent services = new Intent(getApplicationContext(), cspace_services.class);
        startActivity(services);
    }
    public void gotostaffdetails(View view){
        Intent staff = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/10rDACjSn75qeol0QQRwFGsn7rXSYx6M7MBGFFwVo_lI/edit"));
        startActivity(staff);

    }


}
