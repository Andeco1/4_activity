package com.example.task911;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    static String CURRENT_ACTIVITY = "Activity 4";
    public static int Request_Code = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        Button button1 = findViewById(R.id.But1);
        Button button2 = findViewById(R.id.But2);
        Button button3 = findViewById(R.id.But3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, MainActivity.class);
                startActivityForResult(intent, Request_Code);
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, Activity2.class);
                startActivityForResult(intent, Request_Code);
                intent.putExtra("last_act",CURRENT_ACTIVITY);
                setResult(RESULT_OK,intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this, Activity3.class);
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
