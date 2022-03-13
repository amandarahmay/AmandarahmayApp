package com.example.amandarahmayapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EkaHospital extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Direction", "Website", "Google Info", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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
            if (pilihan.equals("Call Center")){
                String nomortel = "tel:07616989999";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            } else  if (pilihan.equals("SMS Center")){
                String smsText = "Amanda Rahma Yanti H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:082114779339"));
                a.putExtra("sms_body", smsText);

            } else  if (pilihan.equals("Direction")){
                String lokasirs ="https://www.google.com/maps/place/Eka+Hospital+Pekanbaru/@0.4823349,101.4180781,17z/data=!3m1!4b1!4m5!3m4!1s0x31d5a958ff468d7d:0x958ef365745c3ff7!8m2!3d0.4823295!4d101.4202668";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")){
                String website = "https://www.ekahospital.com/id";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Google Info")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Eka Hospital");

            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
