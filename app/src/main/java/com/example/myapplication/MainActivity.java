package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final ArrayList<String> contactNames = new ArrayList<String>(Arrays.asList("+491738729782", "+4915210767568"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView cLv = findViewById(R.id.listView);
        ContactsAdapter cAdapter = new ContactsAdapter(getApplicationContext(), contactNames);
        cLv.setAdapter(cAdapter);

        // getSelectedContacts is well acessible ;  make sure you declared the adapter as  ContactsAdapter not as BaseAdapter
        cAdapter.getSelectedContacts();


    }
}