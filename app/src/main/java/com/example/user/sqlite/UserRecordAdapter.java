package com.example.user.sqlite;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 22/12/2017.
 */

public class UserRecordAdapter extends ArrayAdapter<UserRecord> {
    public UserRecordAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<UserRecord> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserRecord userRecord = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_record, parent,false);

        }

        TextView textViewPhone, textViewName, textViewEmail;
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewPhone = (TextView) convertView.findViewById(R.id.textViewPhone);
        textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

        textViewName.setText(userRecord.getName());
        textViewPhone.setText(userRecord.getPhone());
        textViewEmail.setText(userRecord.getEmail());

        return convertView;
    }
}
