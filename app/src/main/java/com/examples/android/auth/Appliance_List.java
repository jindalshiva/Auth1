package com.examples.android.auth;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Appliance_List extends ArrayAdapter<Appliances> {
    private Activity context;
    private List<Appliances> appliancesList;

    public Appliance_List(Activity context, List<Appliances> appliancesList){

        super(context, R.layout.appliance_list,appliancesList);
        this.context = context;
        this.appliancesList = appliancesList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater ();
        View listViewItem = inflater.inflate (R.layout.appliance_list,null,true);

        TextView textViewItemName = (TextView) listViewItem.findViewById (R.id.text_Item_Name);
        TextView textViewPlaceName = (TextView) listViewItem.findViewById (R.id.text_Place_Name);
        TextView textViewStatus = (TextView) listViewItem.findViewById (R.id.text_status);


        Appliances appliances = appliancesList.get (position);
        textViewItemName.setText (appliances.getItemName ());
        textViewPlaceName.setText (appliances.getPlaceName ());
        textViewStatus.setText (String.valueOf (appliances.getStatus ()));

        return listViewItem;
    }
}
