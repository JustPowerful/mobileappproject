package com.example.ahmedaminedoudech_lsi_a3_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static List<Contact> contactList = new ArrayList<>();
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactAdapter = new ContactAdapter(this, contactList);
        ListView contactListView = findViewById(R.id.contactListView);
        contactListView.setAdapter(contactAdapter);

        findViewById(R.id.addContactMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String phone = data.getStringExtra("phone");
            String email = data.getStringExtra("email");

            Contact newContact = new Contact(name, phone, email);
            contactList.add(newContact);
            contactAdapter.notifyDataSetChanged();
        }
    }

    public static List<Contact> getContactList() {
        return contactList;
    }
}