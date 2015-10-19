package com.example.android.networkusage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by smuggler on 13.10.15.
 */
public class ExchangeActivity extends Activity {
    private String country;
    private String currency;
    private double rate;
    private int amount;

    private EditText czkAmount;
    private EditText forAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange);
        Intent i = getIntent();
        country = i.getStringExtra("fCountry");
        currency = i.getStringExtra("fCurr");
        rate = i.getDoubleExtra("fRate", 1);
        amount = i.getIntExtra("fAmount", 1);

        ((TextView) findViewById(R.id.foreignCountry)).setText(country);
        ((TextView) findViewById(R.id.foreignCurrency)).setText(currency);
        ((TextView) findViewById(R.id.foreignRate)).setText(String.valueOf(rate));
        ((ImageView) findViewById(R.id.foreignFlag)).setBackgroundResource(Flags.get(currency));
        czkAmount = (EditText) findViewById(R.id.czkInput);
        forAmount = (EditText) findViewById(R.id.foreignInput);
        czkAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!czkAmount.hasFocus())
                    return;
                try {
                    forAmount.setText(String.valueOf(Double.valueOf(charSequence.toString()) / rate * amount));
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        forAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!forAmount.hasFocus())
                    return;
                try {
                    czkAmount.setText(String.valueOf(Double.valueOf(charSequence.toString()) * rate / amount));
                } catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
