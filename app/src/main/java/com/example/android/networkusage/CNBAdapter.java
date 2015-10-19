package com.example.android.networkusage;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// TODO upravit tak, aby se zobrazovalo
//
//  |-----------|----------------------------------|
//  | ImageView |          NAZEV MENY              |  
//  |           |Kod                               | 
//  |  vlajka   |Stat                              |
//  |   statu   |Cena                              | 
//  |           |                                  |
//  |----------------------------------------------|


public class CNBAdapter extends ArrayAdapter<Entry>{

    Context context;
    int layoutResourceId;   
    List<Entry> data = null;
    
   
    public CNBAdapter(Context context, int layoutResourceId, List<Entry> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        EntryHolder holder = null;
       
        if(row == null)
        {
        	LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );      	
            row = inflater.inflate(layoutResourceId, parent, false);
           
            holder = new EntryHolder();
            holder.txtKod = (TextView) row.findViewById(R.id.txtKod);
            holder.txtCena = (TextView) row.findViewById(R.id.txtCena);
            holder.txtStat = (TextView) row.findViewById(R.id.txtStat);
            holder.imgStat = (ImageView) row.findViewById(R.id.imgStat);
            
            row.setTag(holder);
        }
        else
        {
            holder = (EntryHolder)row.getTag();
        }
       
        Entry entry = data.get(position);
        holder.txtKod.setText(entry.kod);
        holder.txtStat.setText(entry.stat);
        holder.txtCena.setText(String.valueOf(entry.cena));
        holder.imgStat.setImageResource(Flags.get(entry.kod));
        
        return row;
    }
   
    static class EntryHolder
    {
        TextView txtKod;
        TextView txtStat;
        TextView txtCena;
        ImageView imgStat;
    }
}
