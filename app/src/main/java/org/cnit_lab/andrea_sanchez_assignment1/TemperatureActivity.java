package org.cnit_lab.andrea_sanchez_assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature_unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = findViewById(R.id.spinner_unit);
        EditText myTextBox = findViewById(R.id.edit_text_number);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);

        myTextBox.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence value, int i, int i1, int i2) {
                Convert(value.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent mIntent=new Intent(this,InfoActivity.class);
                startActivity(mIntent);
                return true;

            case R.id.weight:
                Intent mIntent1=new Intent(this,WeightActivity.class);
                startActivity(mIntent1);
                return true;

            case R.id.length:
                Intent mIntent2 =new Intent(this,MainActivity.class);
                startActivity(mIntent2);
                return true;
            case R.id.temperature:
                Intent mIntent3 =new Intent(this,TemperatureActivity.class);
                startActivity(mIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int itemSelected, long l) {
        EditText myTextBox = findViewById(R.id.edit_text_number);
        String textValue = myTextBox.getText().toString();
        if (textValue.length() > 0) {
            Convert(textValue);
        }
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void Convert(String value) {
        if(!(isDouble(value))){
            value="0.0";
        }
        Spinner spinner = findViewById(R.id.spinner_unit);

        String unit=spinner.getSelectedItem().toString();
        TextView output_1 = findViewById(R.id.text_view_value1);
        TextView output_2 = findViewById(R.id.text_view_value2);
        TextView output_3 = findViewById(R.id.text_view_value3);


        Double converted=0.0;

        if(unit.equals("C")){
            converted = Double.parseDouble(value);//C
            output_1.setText(String.format("%.4f", converted));
            converted = (Double.parseDouble(value)* 9/5) + 32;//F
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)+273.15 ;//K
            output_3.setText(String.format("%.4f", converted));
        }

        if(unit.equals("F")){
            converted = (Double.parseDouble(value)-32)*5/9;//C
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//F
            output_2.setText(String.format("%.4f", converted));
            converted = (Double.parseDouble(value)-32) * 5/9 + 273.15;//K
            output_3.setText(String.format("%.4f", converted));
        }
        if(unit.equals("K")){
            converted = (Double.parseDouble(value))-273.15;//C
            output_1.setText(String.format("%.4f", converted));
            converted = (Double.parseDouble(value)-273.15)*9/5 + 32;//F
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//K
            output_3.setText(String.format("%.4f", converted));
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}