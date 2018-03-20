package wsu.library_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class print_scan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_scan);
    }


    public void gotopolicy(View view){
        Intent policy = new Intent(getApplicationContext(), Generalpolicy.class);
        startActivity(policy);
    }
}
