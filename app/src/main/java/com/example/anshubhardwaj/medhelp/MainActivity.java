package com.example.anshubhardwaj.medhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public boolean IS_USER_VERIFIED=false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view){
        if(IS_USER_VERIFIED) {
            intent = new Intent(this, LoginActivity.class);
            IS_USER_VERIFIED=true;
        }
        else{
            intent=new Intent(this,SignedinActivity.class);
        }
        startActivity(intent);
    }
}
