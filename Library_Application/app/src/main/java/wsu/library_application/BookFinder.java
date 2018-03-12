package wsu.library_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BookFinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookfinder);
        Intent gridView = new Intent(BookFinder.this, GridViewActivity.class);
        startActivity(gridView);
    }




}
