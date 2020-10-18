package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContactsAdapter extends BaseAdapter {

    Context context ;
    ArrayList<String> theContacts;
    ArrayList<String> selectedContacts;

    public ContactsAdapter(Context c, ArrayList<String> theContact) {
        this.context = c;
        this.theContacts = theContact;
        selectedContacts = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return theContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return selectedContacts.get(i);
    }


    //getter method  to get lis of selected contacts
    public ArrayList<String> getSelectedContacts() {
        return selectedContacts;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ContactsAdapter.ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ContactsAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.my_contact_list_item,parent,false);
            viewHolder.chkbox = (CheckBox) convertView.findViewById(R.id.checkbox_listItem);
            result=convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ContactsAdapter.ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.chkbox.setText(theContacts.get(position));
        viewHolder.chkbox.setPadding(20,20,20,20);
        viewHolder.chkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean selected) {
                if ( selected){
                    selectedContacts.add(theContacts.get(position));
                    Log.e("ADAPTER"  ,  " contact is selected " +  theContacts.get(position) ) ;

                }else {
                    selectedContacts.remove(theContacts.get(position));
                    Log.e("ADAPTER"  ,  " contact is removed " +  theContacts.get(position) ) ;

                }


            }
        });
        return convertView;
    }
    private static class ViewHolder {

        CheckBox chkbox;
    }
}
