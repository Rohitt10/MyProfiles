package com.example.myprofiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Profiles> {
    Context context;
    ArrayList<Profiles> al;
    public MyAdapter(ArrayList<Profiles> al,Context context)
    {
        super(context,R.layout.my_layout,al);
        this.al=al;
        this.context=context;
    }
    public static class ViewHolder
    {
        TextView textView;
        ImageView imageView;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        Profiles p=getItem(position);
        final View result;
        if(convertView==null)
        {
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.my_layout,parent,false);
            viewHolder.textView=(TextView) convertView.findViewById(R.id.textView);
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.imageView);
            result=convertView;
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) convertView.getTag();
            result=convertView;
        }
        viewHolder.textView.setText(p.name);
        viewHolder.imageView.setImageResource(p.logo);
        return convertView;
    }
}
