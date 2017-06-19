package com.example.maartje.programmeren_4_tentamen.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maartje.programmeren_4_tentamen.R;

public class RegisterActivity extends AppCompatActivity {

    EditText voornaamEdit, achternaamEdit, emailEdit, wachtwoordEdit;
    Button registreerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        voornaamEdit = (EditText) voornaamEdit.findViewById(R.id.voornaamEdit);
        achternaamEdit = (EditText) achternaamEdit.findViewById(R.id.achternaamEdit);
        emailEdit = (EditText) emailEdit.findViewById(R.id.mailEdit);
        wachtwoordEdit = (EditText) wachtwoordEdit.findViewById(R.id.wachtwoordEdit);
        registreerButton = (Button) registreerButton.findViewById(R.id.registerButton);
        registreerButton.setOnClickListener((View.OnClickListener) this);
    }

    public void onClick(View view) {

        Log.d("hoi", "onClick: button geklikt");

    }

    public void register(){

    }
}
