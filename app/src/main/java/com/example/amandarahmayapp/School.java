package com.example.amandarahmayapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class School extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listHospital = new String[] {"SMAN 1 Pekanbaru","SMAN 2 Pekanbaru", "SMAN 5 Pekanbaru"};
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
            if (pilihan.equals("SMAN 1 Pekanbaru")){
                a = new Intent(this,SMAN1Pekanbaru.class);

            } else  if (pilihan.equals("SMAN 2 Pekanbaru")){
                a = new Intent(this,SMAN2Pekanbaru.class);

            } else  if (pilihan.equals("SMAN 5 Pekanbaru")){
                a = new Intent(this,SMAN5Pekanbaru.class);

            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
