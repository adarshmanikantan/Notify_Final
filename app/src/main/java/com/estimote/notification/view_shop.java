package com.estimote.notification;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dell on 7/28/2017.
 */

public class view_shop extends AppCompatActivity {
    AsyncHttpClient client;
    JSONArray jarray;
    JSONObject jobject;
    RequestParams params;
    ListView lv;
    JSONObject jsonObject;
    JSONArray jsonArray;




    ArrayList<String> shpid;
    ArrayList<String> shpname;
//    ArrayList<String> pdtid;
//    ArrayList<String> pdtnm;
    ArrayList<String> pdtprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_shop);
        lv=(ListView)findViewById(R.id.view_offr_lst);
        client = new AsyncHttpClient();
        params = new RequestParams();
        shpid = new ArrayList<String>();
        shpname = new ArrayList<String>();
//        pdtid = new ArrayList<String>();
//        pdtnm = new ArrayList<String>();
        pdtprice = new ArrayList<String>();
        client.get("http://srishti-systems.info/projects/ishoppee/user/viewshops.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                try {
                    jsonObject = new JSONObject(content);
                    String res = jsonObject.getString("Result");
                    Log.e("rrrrrrrrrrrr", res);
                    if (res.equals("success")) {
                        jsonArray = jsonObject.getJSONArray("Shops");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jobj = jsonArray.getJSONObject(i);
                            String sid = jobj.getString("Shops_id");
                            shpid.add("Shop id:   "+sid);
                            Log.e("iiiiiiiiiiiiii", sid);
                            String sname = jobj.getString("ShopName");
                            shpname.add("Shop Name:   "+sname);

//                            String pid = jobj.getString("Shop_type");
//                            pdtid.add("Product id:   "+pid);
//
//                            String pname = jobj.getString("ProductName");
//                            pdtnm.add("Product Name:   "+pname);

                            String pprice = jobj.getString("Shop_type");
                            pdtprice.add("Shop Type:   "+pprice);
                        }
                    }
                    adapter ad = new adapter();
                    lv.setAdapter(ad);
                } catch (Exception e) {

                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(),WebAct.class));
            }
        });

    }
    class adapter extends BaseAdapter {
            LayoutInflater inflater;

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return shpid.size();
            }

            @Override
            public Object getItem(int position) {
                // TODO Auto-generated method stub
                return position;
            }

            @Override
            public long getItemId(int position) {
                // TODO Auto-generated method stub
                return position;
            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custlist_shop, null);
                Viewholder holder = new Viewholder();
//                holder.ssid = (TextView) convertView.findViewById(R.id.shp_id);
//                holder.ssid.setVisibility(View.GONE);
//                holder.ssid.setText(shpid.get(position));

                holder.ssid = (TextView) convertView.findViewById(R.id.shp_NM);

                holder.ssid.setText(shpname.get(position));

//                holder.ppid = (TextView) convertView.findViewById(R.id.pdt_id);
//                holder.ssid.setVisibility(View.GONE);
//                holder.ppid.setText(pdtid.get(position));
//
//                holder.ppnam = (TextView) convertView.findViewById(R.id.pdt_nm);
//                holder.ssid.setVisibility(View.GONE);
//                holder.ppnam.setText(pdtnm.get(position));

                holder.pri = (TextView) convertView.findViewById(R.id.shp_TYP);

                holder.pri.setText(pdtprice.get(position));


                return convertView;
            }

            class Viewholder {
                TextView ssnam;
                TextView ssid;
                TextView ppid;
                TextView ppnam;
                TextView pri;


            }
    }
}