package com.reda.yehia.countrypicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CountryPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = CountryPicker.newInstance("gnfhjgjhg", this);
        picker.show(getSupportFragmentManager(),"");
    }
}
