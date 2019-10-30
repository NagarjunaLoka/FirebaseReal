package com.example.zoy.firebasereal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Query_Adapter2 extends ArrayAdapter<Query_class> {
    private Activity context;
    List<Query_class> queryclasses;

    private ArrayList<Query_class> arraylist;




    public Query_Adapter2(Activity context, List<Query_class> queryclasses) {
        super(context, R.layout.layout_artist_list, queryclasses);
        this.context = context;
        this.arraylist = new ArrayList<Query_class>();
        this.arraylist.addAll(queryclasses);
        this.queryclasses = queryclasses;

    }

    @Override
    public Query_class getItem(int position) {
        return queryclasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
        ImageView flag;
    }


/*

     public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.rank);
            holder.country = (TextView) view.findViewById(R.id.country);
            holder.population = (TextView) view.findViewById(R.id.population);
            // Locate the ImageView in listview_item.xml
            holder.flag = (ImageView) view.findViewById(R.id.flag);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.rank.setText(worldpopulationlist.get(position).getRank());
        holder.country.setText(worldpopulationlist.get(position).getCountry());
        holder.population.setText(worldpopulationlist.get(position)
                .getPopulation());


    */




    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_artist_list, null, true);
        if (convertView == null) {

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);


        if(queryclasses != null && queryclasses.size() !=0) {//checking whether list is empty are not

            Query_class queryclass = queryclasses.get(position);
            textViewName.setText(queryclass.getName());
            textViewGenre.setText(queryclass.getEmail());

        }else{

            Toast toast = Toast.makeText(context.getApplicationContext(),"No Search Item Available",Toast.LENGTH_SHORT);
            Toast.makeText(context.getApplicationContext(),"HelloWorld",Toast.LENGTH_SHORT); toast.setGravity(Gravity.CENTER,0,0); toast.show();
            View view = toast.getView();
           // view.setBackgroundResource(R.drawable.wrong);
           // view.setBackgroundColor(R.color.orange);
           // view.getResources().getColor(R.color.orange);

        }

        return listViewItem;
    }


    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        queryclasses.clear();
        if (charText.length() == 0) {
            queryclasses.addAll(arraylist);
        } else {
            for (Query_class wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    queryclasses.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
}