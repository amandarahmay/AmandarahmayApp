package com.example.amandarahmayapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SMAN5Pekanbaru extends ListActivity {
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
                String nomortel = "tel:076132075";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));

            } else  if (pilihan.equals("SMS Center")){
                String smsText = "Amanda Rahma Yanti H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:0761-32075"));
                a.putExtra("sms_body", smsText);

            } else  if (pilihan.equals("Direction")){
                String lokasirs ="https://www.google.com/maps/place/SMA+Negeri+5+Pekanbaru/@0.502715,101.4406057,17z/data=!3m1!4b1!4m5!3m4!1s0x31d5aeb11fef3da9:0x62a23cf351c79abc!8m2!3d0.5027096!4d101.4427944";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")){
                String website = "https://id.wikipedia.org/wiki/SMA_Negeri_5_Pekanbaru";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Google Info")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"SMA N 5 Pekanbaru");

            } else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(a);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
