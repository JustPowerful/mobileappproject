package com.example.ahmedaminedoudech_lsi_a3_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class EditContactActivity extends AppCompatActivity {
    private EditText nameEditText, phoneEditText, emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);

        // Retrieve existing contact details
        Intent intent = getIntent();
        nameEditText.setText(intent.getStringExtra("name"));
        phoneEditText.setText(intent.getStringExtra("phone"));
        emailEditText.setText(intent.getStringExtra("email"));

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", nameEditText.getText().toString());
                resultIntent.putExtra("phone", phoneEditText.getText().toString());
                resultIntent.putExtra("email", emailEditText.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}