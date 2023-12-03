package com.example.app_deneme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Convertor extends AppCompatActivity {

    TextView decimal;
    TextView binary;
    TextView octal;
    TextView hexadecimal;
    Button decimalConvert;
    EditText decimalValue;

    TextView byteText;
    TextView byteResult;
    EditText byteValue;
    Button byteConvert;

    TextView celcius;
    TextView celciusResult;
    EditText celciusValue;
    Button celciusConvert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convertor);

        decimal = findViewById(R.id.decimal);
        binary = findViewById(R.id.binary);
        octal = findViewById(R.id.octal);
        hexadecimal = findViewById(R.id.hexadecimal);
        decimalConvert = findViewById(R.id.decimalConvert);
        decimalValue = findViewById(R.id.decimalValue);

        byteText = findViewById(R.id.byte_id);
        byteConvert = findViewById(R.id.byteConvert);
        byteResult = findViewById(R.id.byteResult);
        byteValue = findViewById(R.id.byteValue);

        celcius = findViewById(R.id.celcius);
        celciusConvert = findViewById(R.id.celciusConvert);
        celciusResult = findViewById(R.id.celciusResult);
        celciusValue = findViewById(R.id.celciusValue);

        decimalConvert.setOnClickListener(view -> {
            decimalConvertAndDisplay();
        });

        byteConvert.setOnClickListener(
                view -> {
                    byteConvertAndDisplay();
                }
        );

        celciusConvert.setOnClickListener(view -> {
            convertTemperature();
        });
    }

    public void decimalConvertAndDisplay(){
        String inputText = decimalValue.getText().toString().trim();
        if(!inputText.isEmpty()){
            int decimalValue = Integer.parseInt(inputText);
            try {
                    String binaryValue = Convertor.convertDecimalToBinary(decimalValue);
                    String octalValue = Convertor.convertDecimalToOctal(decimalValue);
                    String hexadecimalValue = Convertor.convertDecimalToHexadecimal(decimalValue);

                    binary.setText(binaryValue);
                    octal.setText(octalValue);
                    hexadecimal.setText(hexadecimalValue);
            } catch(NumberFormatException e){
                binary.setText("Invalid input");
                octal.setText("Invalid input");
                hexadecimal.setText("Invalid input");
            }
        } else {
            binary.setText("Enter a decimal value");
            octal.setText("Enter a decimal value");
            hexadecimal.setText("Enter a decimal value");
        }
    }
    public static  String convertDecimalToBinary(int decimalValue){
        return Integer.toBinaryString(decimalValue);
    }
    public static  String convertDecimalToOctal(int decimalValue){
        return Integer.toOctalString(decimalValue);
    }
    public static  String convertDecimalToHexadecimal(int decimalValue){
        return Integer.toHexString(decimalValue);
    }

    public void byteConvertAndDisplay(){
        String megaByteText = byteValue.getText().toString();
        if (megaByteText.isEmpty()){
            byteResult.setText("enter a MegaByte value.");
            return;
        }

        double megaByte = Double.parseDouble(megaByteText);

        double kiloByte = megaByte * 1024;
        double byteValue = megaByte * 1024 * 1024;
        double kibiByte = byteValue / 1024;
        double bit = byteValue * 8;

        String byteRes = "kb: " + kiloByte + "b:" + byteValue + "kibiByte: " + kibiByte + "bit: " + bit;
        byteResult.setText(byteRes);
    }

    public void convertTemperature(){
        String celciusText = byteValue.getText().toString();
        if (celciusText.isEmpty()){
            byteResult.setText("enter a temperature value.");
            return;
        }

        double celcius = Double.parseDouble(celciusText);

        double fahrenheit = (celcius * 9/5) + 32;
        double kelvin = celcius + 273;

        String tempResult = "F: " + fahrenheit + "K: " +  kelvin;
        celciusResult.setText(tempResult);
    }
}