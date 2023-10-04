package com.example.furiouscriminalskalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText editText1;
    EditText editText2;
    TextView resultField;
    AutoCompleteTextView dropdown;
    double input1;
    double input2;
    double result;
    Button calculate_Btn;
    String opperator;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set items in dropdown
        String[] dropdownItems = new String[] {
                "+", "-", "*", "/", "√", "%","Pythagoras sats","Cirklens Area", "Cylinderns volym"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dropdownItems);
        //add items to dropdown
        dropdown = (AutoCompleteTextView)
                findViewById(R.id.dropdown);
        dropdown.setAdapter(adapter);

        //set values
        editText1 = findViewById(R.id.et_input1);
        editText2 = findViewById(R.id.et_input2);

        resultField = findViewById(R.id.textView);
        calculate_Btn = findViewById(R.id.btn_uträkning);
        dropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
           opperator = parent.getItemAtPosition(position).toString();
          //  resultField.setText(item);
        }
    });
        //Buttons
        calculate_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get value from dropdown, skicka in i calculate
                calculate(opperator);
            }
        }) ;
    }
    /*
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