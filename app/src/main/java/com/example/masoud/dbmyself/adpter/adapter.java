package com.example.masoud.dbmyself.adpter;


import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.masoud.dbmyself.R;
import com.example.masoud.dbmyself.model.Person;

import java.util.List;
import java.util.zip.Inflater;

public class adapter extends ArrayAdapter<Person>{

    Context context;
    List<Person> personList;
    int resource;

    public adapter(Context context, int resource, List<Person> personList) {
        super(context, resource, personList);

        this.context = context;
        this.resource = resource;
        this.personList = personList;

    }

     static class viewHolder{
         TextView tvname , tvfamily , tvphonenum;
         ImageView imageView;

     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_list_view , null);
            LayoutInflater inflater = LayoutInflater.from(context);
            View rootview = inflater.inflate(resource , null);

            holder = new viewHolder();

            holder.tvname = (TextView) convertView.findViewById(R.id.tvname);
            holder.tvfamily = (TextView) convertView.findViewById(R.id.tvfamily);
            holder.tvphonenum = (TextView) convertView.findViewById(R.id.tvphonenum);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }

        Person person = personList.get(position);

//        holder.imageView.setImageResource(MediaStore);
        holder.tvname.setText(person.getName());
        holder.tvfamily.setText(person.getFamily());
        holder.tvphonenum.setText(person.getPhonenum());

        return convertView;
    }
}

