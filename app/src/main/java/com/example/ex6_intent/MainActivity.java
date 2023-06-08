package com.example.ex6_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView editTextName;
    public Button btnClickMe;
    public  Button btnDial;
    public EditText editTextUrl;
    public  Button btnUrl;
    public static final  String  EXTRA_MESSAGE = "com.example.ex6_intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName=findViewById(R.id.editTextName);
        btnClickMe=findViewById(R.id.btnClickMe);
        btnDial=findViewById(R.id.btnDial);
        editTextUrl=findViewById(R.id.editTextUrl);
        btnUrl=findViewById(R.id.btnUrl);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                    String yName = editTextName.getText().toString();
                    intent.putExtra("MESSAGE", yName);
                    startActivity(intent);
            }
        });

        btnDial.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}