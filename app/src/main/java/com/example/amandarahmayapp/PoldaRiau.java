package com.example.amandarahmayapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PoldaRiau extends ListActivity {
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
                String nomortel = "tel:076131307";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            } else  if (pilihan.equals("SMS Center")){
                String smsText = "Amanda Rahma Yanti H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:076131307"));
                a.putExtra("sms_body", smsText);

            } else  if (pilihan.equals("Direction")){
                String lokasirs ="https://www.google.com/maps/place/Bakwan+Sumatera/@0.5126465,101.4481891,17z/data=!4m12!1m6!3m5!1s0x31d5aec14333e6f1:0xbcbc6a819ea27901!2sPolda+Riau!8m2!3d0.5105346!4d101.4578011!3m4!1s0x31d5aea6d3773c17:0x5efe4e18164ff16a!8m2!3d0.5126463!4d101.4503781";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")){
                String website = "https://www.tempo.co/tag/polda-riau";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Google Info")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Polda Riau");

            } else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
