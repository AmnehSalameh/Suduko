package com.example.amon.suduko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RightansActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rightans);
        Button s=(Button)findViewById(R.id.r);
        s.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), home.class);
                i.putExtra("FSF", 3);
                startActivity(i);
            }
        });
    }
}
