package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String expr;
    TextView t;
    private Switch nightswitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textView1);
        nightswitch = (Switch) findViewById(R.id.switch1);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            nightswitch.setChecked(true);
        }
        nightswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
    }

    public void restartApp(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

    public void mul(View v){
        expr = expr+"*";

    }
    public void div(View v){
        expr = expr+"/";
    }
    public void sub(View v){
        expr = expr+"-";
    }
    public void add(View v){
        expr = expr+"+";
    }
    public void evaluate(View v){
        try {
            if(expr==""){
                t.setText("Please enter something");
            }
            else {
                double res = EvaluateString.eval(expr);
                System.out.println(res);
                t.setText(Double.toString(res));
            }
        } catch(Exception e) {
            t.setText("Invalid input ...");
        }
        finally{
            expr = "";
        }
    }

    public void dig9(View v){
        expr = expr+"9";
    }
    public void dig8(View v){
        expr = expr+"8";
    }
    public void dig7(View v){
        expr = expr+"7";
    }
    public void dig6(View v){
        expr = expr+"6";
    }
    public void dig5(View v){
        expr = expr+"5";
    }
    public void dig4(View v){
        expr = expr+"4";
    }
    public void dig3(View v){
        expr = expr+"3";
    }
    public void dig2(View v){
        expr = expr+"2";
    }
    public void dig1(View v){
        expr = expr+"1";
    }
    public void dig0(View v){
        expr = expr+"0";
    }
    public void dot(View v){
        expr = expr+".";
    }
    public void dump(View v){
        expr = "";
    }

    public void newtab(View v){
        Intent i = new Intent(getApplicationContext(), Maps.class);
        startActivity(i);
    }


}
