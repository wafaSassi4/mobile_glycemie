package com.example.wafasassilsi3_devmobil_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wafasassilsi3_devmobil_mesure_glycemie.R;
import com.example.wafasassilsi3_devmobil_mesure_glycemie.controller.controller;

public class MainActivity extends AppCompatActivity {

    private TextView age=null,res=null;
    //private TextVien tvage;tvresult;
    private SeekBar sbage =null;
    //private SeekBar sbage;
    private RadioGroup rbGrp=null;
    private RadioButton rboui=null,rbnon=null;
    private EditText vm=null;
    private Button btn= null;

    private static controller myController = new controller();
    @Override
    //public void main
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChanged:"+progress);
                age.setText("Votre age : "+sbage.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age;
                double vM;
                boolean veriAge=false,verifValeur=false,isFasting;

                if(sbage.getProgress() != 0){
                    veriAge=true;
                }else {
                    Toast.makeText(MainActivity.this, "Veuillez vérifier votre age", Toast.LENGTH_SHORT).show();
                }
                if (!vm.getText().toString().isEmpty()){
                    verifValeur=true;
                }else{
                    Toast.makeText(MainActivity.this, "Veuillez vérifier votr valeur muserée", Toast.LENGTH_LONG).show();
                }
                if (veriAge && verifValeur){
                    age = sbage.getProgress();
                    vM = Double.valueOf(vm.getText().toString());
                    isFasting = rboui.isChecked();

                    myController.createPatient(vM,age,isFasting);

                    res.setText(myController.getResponse());
                }
            }
        });

    }
    private void init(){

        age = (TextView) findViewById(R.id.age);
        sbage =(SeekBar) findViewById(R.id.sbage);
        btn= (Button) findViewById(R.id.btn);
        vm= (EditText) findViewById(R.id.vm);
       // rbGrp=(RadioGroup) findViewById(R.id.rbGrp);
        rbnon=(RadioButton)findViewById(R.id.rbNon);
        rboui=(RadioButton)findViewById(R.id.rbOui);
        res= (TextView) findViewById(R.id.res);
    }


}