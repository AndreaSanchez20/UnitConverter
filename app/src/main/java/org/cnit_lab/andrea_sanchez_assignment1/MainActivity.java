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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit, android.R.layout.simple_spinner_item);
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
        TextView output_4 = findViewById(R.id.text_view_value4);
        TextView output_5 = findViewById(R.id.text_view_value5);
        TextView output_6 = findViewById(R.id.text_view_value6);
        TextView output_7 = findViewById(R.id.text_view_value7);
        TextView output_8 = findViewById(R.id.text_view_value8);

        Double converted=0.0;
        if(unit.equals("inch")){
            converted = Double.parseDouble(value)*25.4;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*2.54;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*0.0254;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/39370;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/2;//ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/36;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/63360;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("mm")){
            converted = Double.parseDouble(value);//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/10;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1000;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1000000;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/25.4;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/305; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/914;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1609344;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("cm")){
            converted = Double.parseDouble(value)*10;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/100;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/100000;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/2.54;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/30.48; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/91.44;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/160934;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("m")){
            converted = Double.parseDouble(value)*1000;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*100;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1000;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*39.37;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*3.281; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*1.094;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1609;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("km")){
            converted = Double.parseDouble(value)*1000000;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*100000;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*1000;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*39370;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*3281; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*1094;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1.609;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("ft")){
            converted = Double.parseDouble(value)*305;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*30.48;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/3.281;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/3281;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*12;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value); //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/3;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/5280;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("yd")){
            converted = Double.parseDouble(value)*914;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*91.44;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1.094;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1094;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*36;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*3; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1760;//mi
            output_8.setText(String.format("%.4f", converted));
        }
        if(unit.equals("mile")){
            converted = Double.parseDouble(value)*1609344;//mm
            output_1.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*160934;//cm
            output_2.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1609;//m
            output_3.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)/1.609;//km
            output_4.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*63360;//in
            output_5.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*5280; //ft
            output_6.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value)*1760;//yd
            output_7.setText(String.format("%.4f", converted));
            converted = Double.parseDouble(value);//mi
            output_8.setText(String.format("%.4f", converted));
        }
    }

    /*public String UnitConvertionXML(String value, String Unit) {
        String[] arUnits = this.getResources().getStringArray(R.array.unit);
        String[] arConvert = this.getResources().getStringArray(R.array.conversion);
        Double factor=0.0;
        for (int pos = 0; pos< arUnits.length; pos++) {
            if (arUnits[pos].toString().equals(Unit)) {
                factor = Double.parseDouble(arConvert[pos]);
            }
        }
        Double converted = Double.parseDouble(value)*factor;
        return Double.toString(converted);
    }*/

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}