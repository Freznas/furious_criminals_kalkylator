package com.example.furiouscriminalskalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    TextView resultField;
    double input1;
    double input2;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set values
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        resultField = findViewById(R.id.textView);

        // TODO Fixa Button onclick calculate();
    }

    /*
    hantera 0 - 9 knappar
    hantera uträkning
    */
    public  void calculate( String operation )
    {
        switch (operation)
        {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                result = input1 / input2 ;
                break;
            case "squareRoot":
                result = Math.sqrt(input1);
                break;
            case "%":
                result = input1 / 100;
                break;
            case "pythagoras":
                result = Math.sqrt(Math.pow(input1, 2) - Math.pow(input2, 2)); // Is this correct?
                // result = Math.sqrt( a * a + b * b )
                break;
                //TODO lägg till uträkningar här
            case "circleArea":
                // calculate circlearea
                break;
            case "cylinderVolym":
                // calc volym
                break;
            default:
                //Error message
                break;
        }
        // TODO Visa resultat
    }
}