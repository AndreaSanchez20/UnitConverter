package org.cnit_lab.andrea_sanchez_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
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
}
