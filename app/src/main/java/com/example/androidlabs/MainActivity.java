package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);
        //setContentView(R.layout.activity_main_linear);
        //setContentView(R.layout.activity_main_grid);

        Button btn = findViewById(R.id.button2);
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.edittext);
        CheckBox checkBox = findViewById(R.id.checkBox);

        btn.setOnClickListener( (click) -> {
            String message = editText.getText().toString();
            textView.setText(message);
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_LONG).show();

        } );

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {
                    b = true;
                    Snackbar.make(checkBox, getResources().getString(R.string.snackbar_text) + " " + getResources().getString(R.string.turnedOn), Snackbar.LENGTH_LONG).setAction("undo", click -> checkBox.setChecked(false)).show();
                } else {
                    b = true;
                    Snackbar.make(checkBox, getResources().getString(R.string.snackbar_text) + " " + getResources().getString(R.string.turnedOff), Snackbar.LENGTH_LONG).setAction("undo", click -> checkBox.setChecked(true)).show();
                }
            }
        });
    }
}