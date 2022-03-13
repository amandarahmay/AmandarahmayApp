package com.example.amandarahmayapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Market extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listHospital = new String[] {"Indomaret", "Alfamart"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listHospital));
    }

    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Indomaret")){
                a = new Intent(this,Indomaret.class);

            } else  if (pilihan.equals("Alfamart")){
                a = new Intent(this,Alfamart.class);

            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
