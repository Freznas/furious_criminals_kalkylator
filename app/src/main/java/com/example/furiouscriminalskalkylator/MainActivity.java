package com.example.furiouscriminalskalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] dropdownItems = new String[] {
                "+", "-", "*", "/", "√", "%","Pythagoras sats","Cirklens Area", "Cylinderns volym"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dropdownItems);
        dropdown = (AutoCompleteTextView)
                findViewById(R.id.dropdown);
        dropdown.setAdapter(adapter);
        //set values
        editText1 = findViewById(R.id.et_input1);
        editText2 = findViewById(R.id.et_input2);

        resultField = findViewById(R.id.textView);
        calculate_Btn = findViewById(R.id.btn_uträkning);


        calculate_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dummy;
                dummy = String.valueOf(dropdown.getText());

                if (dummy.equals("Cirklens Area") || dummy.equals("%")){
                        räknaUt(dummy);
                }
                else {
                    calculate(dummy);
                }
            }
        }) ;
    }
    /*
    hantera uträkning
    */
    public  void calculate( String operation )
    {
        input1 =Double.parseDouble(editText1.getText().toString());
      //  String värde2 = editText2.getText().toString();
        input2 = Double.parseDouble(editText2.getText().toString());
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
            case "√":
                result = Math.sqrt(input1);
                break;
            case "%":
                result = input1 / 100;
                break;
            case "Pythagoras sats":
                result = Math.sqrt(Math.pow(input1, 2) + Math.pow(input2, 2)); // Is this correct? just changed the - to a +
                // result = Math.sqrt( a * a + b * b )
                break;
                //TODO lägg till uträkningar här
            case "circleArea":
                result = Math.PI* Math.pow(input1,2);
                break;
            case "Cylinderns volym":
                result = Math.PI* Math.pow(input1,2) * input2;
                break;
            default:
                resultField.setText("Du har angett felaktiga värden, var snäll och försök igen. ");
                break;
        }
        // TODO Visa resultat
        resultField.setText("Resultatet blir " + result);
    }

    public void räknaUt(String operator){
        input1 =Double.parseDouble(editText1.getText().toString());
        switch (operator){
            case "Cirklens Area":
                result = Math.PI* Math.pow(input1,2);
                break;
            case "%":
                result = input1 / 100;
                break;
            default:
                resultField.setText("Du har angett felaktiga värden, var snäll och försök igen. ");
                break;
        }
        resultField.setText("Resultatet blir " + result);

    }
}