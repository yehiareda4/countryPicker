package com.reda.yehia.countrypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;

public class MainActivity extends AppCompatActivity {

    private CountryPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create Instance
        CountryPicker picker = CountryPicker.newInstance("CountryPicker", this);

        //Show Picker
        picker.show(getSupportFragmentManager(),"");

        //dismiss Picker
        picker.dismiss();

        //Listener
        picker.setListener(new CountryPickerListener() {
            @Override
            public void onSelectCountry(Country country) {

            }
        });

    }
}
