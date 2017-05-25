package com.baturamobile.designlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.baturamobile.design.BaturaButton;
import com.baturamobile.design.BaturaEditText;
import com.baturamobile.design.BaturaTextInputLayout;
import com.baturamobile.design.GenericData;

public class MainActivity extends AppCompatActivity {

    BaturaEditText baturaEditText;

    BaturaTextInputLayout editTextInputLayout;

    BaturaTextInputLayout editTextEmailLayout;

    BaturaEditText editTextEmail;

    BaturaEditText notEditableEditText;

    BaturaButton verifyEmailButton;

    BaturaButton button;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GenericData.GENERIC_FONT = "fonts/gothambook.ttf";
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        button = (BaturaButton) findViewById(R.id.pil_show_error);
        editTextInputLayout = (BaturaTextInputLayout)findViewById(R.id.password_input_layout);

        editTextEmailLayout = (BaturaTextInputLayout)findViewById(R.id.email_input_layout);
        editTextEmail = (BaturaEditText)findViewById(R.id.email_input_edittext);

        notEditableEditText = (BaturaEditText)findViewById(R.id.disbled_edittext);


        editTextEmailLayout.setEnabled(true);
        editTextInputLayout.setEnabled(true);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextInputLayout.getError() == null) {
                    editTextInputLayout.setError(getString(R.string.show_error));
                }else{
                    editTextInputLayout.setError(null);
                }
            }
        });

        verifyEmailButton = (BaturaButton)findViewById(R.id.email_verify_button);

        verifyEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextEmail.isValid()){
                    editTextEmailLayout.setError(getString(R.string.email_invalid));
                }else{
                    editTextEmailLayout.setErrorEnabled(false);
                }
            }
        });

        editTextEmail.setEditable(true);
        notEditableEditText.setEditable(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity, menu);

        return true;
    }
}
