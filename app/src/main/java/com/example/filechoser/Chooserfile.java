package com.example.filechoser;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Chooserfile extends BaseAdapter {

    private final LayoutInflater inflater;
    private final int pos_id;
    private final int img_id;
    private final int tex_id;
    private final int LayoutResource;
    private final List<List<String>> list;
    private final MainActivity context;

    public Chooserfile(MainActivity context, List<List<String>> List){
        this.LayoutResource = R.layout.itemfile;
        this.pos_id=R.id.Fpos;
        this.img_id=R.id.Ftype;
        this.tex_id = R.id.Fname;
        this.inflater = context.getLayoutInflater();
        this.context=context;
        this.list=List;

    }

    @Override
    public int getCount() {
        if (this.list == null) {return 0;}return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position).get(1);
    }

    @Override
    public long getItemId(int position) {
        return (position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = this.inflater.inflate(this.LayoutResource, null, true);

        TextView tvt = rowView.findViewById(this.tex_id);
        TextView tvp = rowView.findViewById(this.pos_id);
        ImageView im = rowView.findViewById(this.img_id);

        String str = "";
        Drawable dr = null;

        int  nb =Integer.parseInt(this.list.get(position).get(0));

        for(int i=0;i<nb;i++){str += "\t|\t"; }


        if(this.list.get(position).get(2).equals("F")) {
            if(!this.list.get(position).get(0).equals("0")){ str += "\t|>";}
            dr = context.getDrawable(R.drawable.ic_file_24);

        }
        else {
            if(!this.list.get(position).get(0).equals("0")){ str += "\t|>";}
            dr = context.getResources().getDrawable(R.drawable.ic_folder_24);
            //if(this.list.get(position).get(3).equals("DO")) {dr=context.getResources().getDrawable(R.drawable.ic_folder_open_24);}
        }

        im.setImageDrawable(dr);
        tvp.setText(str);
        tvt.setText(list.get(position).get(1));
        return rowView;
    }
}
