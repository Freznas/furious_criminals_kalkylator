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
        // Skapa Dropdown
        //dropdownItems inehåller Strings som kommer finnas i Dropdown
        String[] dropdownItems = new String[] {
                "+", "-", "*", "/", "√", "%","Pythagoras sats","Cirklens Area", "Cylinderns volym"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dropdownItems);
        // koppla dropdown variabel till dropdown elementet i xml filen.
        dropdown = (AutoCompleteTextView) findViewById(R.id.dropdown);
        //Lägg till adapter & dropdownItems på dropdown
        dropdown.setAdapter(adapter);
        //set values
        editText1 = findViewById(R.id.et_input1);
        editText2 = findViewById(R.id.et_input2);

        resultField = findViewById(R.id.textView);
        calculate_Btn = findViewById(R.id.btn_uträkning);


        calculate_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hämta värde från dropdown menyn
                String dummy;
                dummy = String.valueOf(dropdown.getText());
                // Kolla vilken uträknings funktion som ska kallas & Validera inputs för att hindra att programmet krashar
                if (dummy.equals("Cirklens Area") || dummy.equals("%")
                        && editText1.getText().toString() != null && !editText1.getText().toString() .isEmpty()){
                    // om editText inte är null eller empty fortsätter programmet.
                    räknaUt(dummy);
                }
                else if(editText1.getText().toString() != null && !editText1.getText().toString() .isEmpty()
                        && editText2.getText().toString() != null && !editText2.getText().toString() .isEmpty()){
                    //om editText1 && editText2 inte är null eller empty fortsätter programmet.
                    calculate(dummy);
                }else
                {
                    // Om något av EditTexterna har felaktiga värden körs detta kodblock
                    resultField.setText("Du har angett felaktiga värden, var snäll och försök igen. ");
                }
            }
        }) ;
    }
    public  void calculate( String operation )
    {
        /* Funktion som hanterar uträkningar med två input fields
         Inputs har blivt validerade så parse orsakar ingen krash. (validering görs i calculate onclick (java fil) och inputtype (xml fil))*/
        input1 =Double.parseDouble(editText1.getText().toString());
        input2 = Double.parseDouble(editText2.getText().toString());
        // här görs uträkningen
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
            case "Pythagoras sats":
                result = Math.sqrt(Math.pow(input1, 2) + Math.pow(input2, 2));
                break;
            case "Cylinderns volym":
                result = avrunda(Math.PI* Math.pow(input1,2) * input2,2);
                break;
            default:
                resultField.setText("Du har angett felaktiga värden, var snäll och försök igen. ");
                break;
        }
        // Visa Resultatet
        resultField.setText("Resultatet blir " + result);
    }

    public void räknaUt(String operator){
        input1 =Double.parseDouble(editText1.getText().toString());
        switch (operator){
            case "Cirklens Area":
                result =avrunda( Math.PI* Math.pow(input1,2),2);
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

    public double avrunda(double värdet, int antal_decimaler) {

        int faktor = (int) Math.pow(10, antal_decimaler);
        double tillfälligt_värde1 = faktor * värdet;
        double tillfälligt_värde2 = Math.round(tillfälligt_värde1);
        double slutligt_värde = tillfälligt_värde2 / faktor;
        return slutligt_värde;
    }
}