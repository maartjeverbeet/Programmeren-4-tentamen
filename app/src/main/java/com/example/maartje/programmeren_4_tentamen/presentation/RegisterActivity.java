package com.example.maartje.programmeren_4_tentamen.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maartje.programmeren_4_tentamen.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    EditText voornaamEdit, achternaamEdit, emailEdit, wachtwoordEdit;
    Button registreerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        voornaamEdit = (EditText) findViewById(R.id.voornaamEdit);
        achternaamEdit = (EditText) findViewById(R.id.achternaamEdit);
        emailEdit = (EditText) findViewById(R.id.mailEdit);
        wachtwoordEdit = (EditText) findViewById(R.id.wachtwoordEdit);
        registreerButton = (Button) findViewById(R.id.registerButton);
        registreerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String voornaam, achternaam, email, password;

                voornaam = voornaamEdit.getText().toString();
                achternaam = achternaamEdit.getText().toString();
                email = emailEdit.getText().toString();
                password = emailEdit.getText().toString();

                try {
                    register(voornaam, achternaam, email, password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void register(String vn, String an, String em, String pw) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("first_name", vn);
        json.put("last_name", an);
        json.put("email", em);
        json.put("password_user", pw);

        Log.d("registreer", json.toString());
    }
}
