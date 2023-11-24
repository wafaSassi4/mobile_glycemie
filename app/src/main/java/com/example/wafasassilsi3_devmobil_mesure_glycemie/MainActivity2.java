package com.example.wafasassilsi3_devmobil_mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wafasassilsi3_devmobil_mesure_glycemie.view.MainActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView resultTextView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView resultTextView =(TextView) findViewById(R.id.res);

        // Retrieve the data from the Intent
        Intent intent = getIntent();
        String result = null;
        if (intent != null) {
            result = intent.getStringExtra("result");
            resultTextView.setText(result);
        }
        Button dev = findViewById(R.id.btn);
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    public void  goBack(){
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
