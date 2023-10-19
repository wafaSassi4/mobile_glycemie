package com.example.wafasassilsi3_devmobil_mesure_glycemie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView age1=null,res=null;
    private SeekBar sbage =null;
    private RadioGroup rbGrp=null;
    private EditText vm=null;
    private Button btn= null;
    private boolean jéuner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age1 = (TextView) findViewById(R.id.age);
        sbage =(SeekBar) findViewById(R.id.sbage);
        btn= (Button) findViewById(R.id.btn);
        vm= (EditText) findViewById(R.id.vm);
        rbGrp=(RadioGroup) findViewById(R.id.rbGrp);
        res= (TextView) findViewById(R.id.res);

        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age1.setText("Votre age : "+sbage.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rbGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton  selectedRadioButton =findViewById(checkedId);
                String selectedValue= selectedRadioButton.getText().toString();
                if(selectedValue.equals("Oui")){
                    jéuner=true;
                }else {
                    jéuner=false;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = sbage.getProgress();
                double vM = Double.parseDouble(vm.getText().toString());

                if (jéuner) {
                    if (age >= 13 && (vM >= 5.0 && vM <= 7.2)) {
                        res.setText("niveau de glycémie est normale 1");
                    } else if ((age < 13 && age >= 6) && (vM >= 5.0 && vM <= 10.0)) {
                        res.setText("niveau de glycémie est normale 2");
                    } else if ((age < 13 && age >= 6) && (vM >= 5.5 && vM <= 10.0)) {
                        res.setText("niveau de glycémie est normale 3");
                    } else {
                        res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 1");
                    }
                } else {
                    if (age >= 13 && vM < 10.5) {
                        res.setText("niveau de glycémie est normale");
                    } else {
                        res.setText("niveau de glycémie est trop bas  ou niveau de glycémie est trop élevée 2 ");
                    }
                }
                vm.setText("");
                sbage.setProgress(0);

            }
        });

    }

}