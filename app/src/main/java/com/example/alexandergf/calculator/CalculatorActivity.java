package com.example.alexandergf.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private String num = ""; //Aqui es on esta guardat el numero actual
    private String numant = "";
    private char operacio = ' ';
    private boolean banderaComa = false;

    //Referencias a la vista
    private TextView numview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview = findViewById(R.id.numview);
        numview.setText(num);

    }

    public void  onClickOperator (View view){
        Button b = (Button)view;
        numant =  num;
        num="";
        operacio=b.getText().toString().charAt(0);
        numview.setText(num);
    }

    public void onClickDigit(View view){
        Button b = (Button)view;

        num += b.getText().toString();
        numview.setText(num);
    }

    public void onClickEquals(View view) {
        if (num=="" || numant==""){
            //Toast.makeText(this, "Faltan datos.", Toast.LENGTH_SHORT).show();
            numview.setText(num);
        }else {
            banderaComa=false;
            double x = Double.valueOf(num);
            double xant = Double.valueOf(numant);
            switch (operacio) {
                case '+':
                    num = Double.toString(x + xant);
                    break;
                case '-':
                    num = Double.toString(xant - x);
                    break;
                case '*':
                    num = Double.toString(xant * x);
                    break;
                case '/':
                    num = Double.toString(xant / x);
                    break;
            }
            numview.setText(num);
        }
    }
    public void onClickReset (View view){
        num="";
        numant="";
        operacio=' ';
        banderaComa=false;
        numview.setText(num);
    }
    public void onClickComa (View view){
        Button b = (Button)view;

        if (banderaComa==false && num==""){
            banderaComa=true;
            num="0" + b.getText().toString();
            numview.setText(num);
        } else if (banderaComa==false && num!=""){
            banderaComa=true;
            numview.setText(b.getText().toString());
        } else {

        }
    }
}
