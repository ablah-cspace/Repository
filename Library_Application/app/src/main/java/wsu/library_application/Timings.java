package wsu.library_application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Timings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timings);
    }

    public void goto_time(View view) {
        Intent time = new Intent(Intent.ACTION_VIEW, Uri.parse("http://libresources.wichita.edu/hours"));
        startActivity(time);

    }



}
