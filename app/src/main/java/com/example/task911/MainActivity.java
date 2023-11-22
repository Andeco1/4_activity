package com.example.task911;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String CURRENT_ACTIVITY = "Activity 1";
    public static int Request_Code = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.But2);
        Button button3 = findViewById(R.id.But3);
        Button button4 = findViewById(R.id.But4);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivityForResult(intent, Request_Code);
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity3.class);
                startActivityForResult(intent, Request_Code);
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity4.class);
                startActivityForResult(intent, Request_Code);
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
            }
        });
        Button buttonB = findViewById(R.id.ButB);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String end = "Good end!";

                Intent intent = new Intent();
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Request_Code && data!= null) {
            String str = data.getStringExtra("last_act");
            Toast.makeText(getApplicationContext(), "Вы перешли на " + CURRENT_ACTIVITY + " с " + str, Toast.LENGTH_SHORT).show();
        }
    }
}
