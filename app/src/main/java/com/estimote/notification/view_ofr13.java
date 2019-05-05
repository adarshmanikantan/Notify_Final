package com.estimote.notification;

/**
 * Created by dell on 8/20/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by dell on 7/29/2017.
 */


public class view_ofr13 extends AppCompatActivity {

    // private static final String TAG = "VIEW_PRODUCT";
    AsyncHttpClient client;
    JSONArray jarray;
    JSONObject jobject;
    RequestParams params;
    ListView lv;
    JSONObject jsonObject;
    JSONArray jsonArray;




    ArrayList<String> shpid;
    ArrayList<String> shpname;
    ArrayList<String> pdtid;
    ArrayList<String> pdtnm;
    ArrayList<String> pdtprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_offer);
        lv=(ListView)findViewById(R.id.list_ofr);

        client = new AsyncHttpClient();
        params = new RequestParams();
        shpid = new ArrayList<String>();
        shpname = new ArrayList<String>();
        pdtid = new ArrayList<String>();
        pdtnm = new ArrayList<String>();
        pdtprice = new ArrayList<String>();

        String s = "13131313-1313-1313-1313-131313131313";
        SharedPreferences pref=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        String spid=pref.getString("id1","");
        params.put("beaconid", s);
        params.put("shop_id",spid);
        Log.e(spid,"jgfhgfhfh");
        client.get("http://srishti-systems.info/projects/ishoppee/user/viewproductoffer.php?", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                try {
                    jsonObject = new JSONObject(content);
                    String res = jsonObject.getString("Result");

                    Log.e("reeeeeeeee", res);
                    if (res.equals("success")) {
                        jsonArray = jsonObject.getJSONArray("Shops");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jobj = jsonArray.getJSONObject(i);
                            String sid = jobj.getString("Shop_name");
                            shpid.add("Shop Name:     "+sid);

                            String sname = jobj.getString("Product_type");
                            shpname.add("Product Type:   "+sname);

                            String pid = jobj.getString("ProductName");
                            pdtid.add("Product Name:   "+pid);

                            String pname = jobj.getString("ProductPrice");
                            pdtnm.add("Product Price:   "+pname);

                            String pprice = jobj.getString("OfferPrice");
                            pdtprice.add("Offer Price:   "+pprice);
                        }
                    }

                    adapter ad = new adapter();
                    lv.setAdapter(ad);
                } catch (Exception e) {

                }
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
            convertView = inflater.inflate(R.layout.custom_list_view_offr, null);
            Viewholder holder = new Viewholder();
            holder.ssid = (TextView) convertView.findViewById(R.id.shp_id);
            holder.ssid.setText(shpid.get(position));


            holder.ssnam = (TextView) convertView.findViewById(R.id.shp_nm);
            holder.ssnam.setText(shpname.get(position));


            holder.ppid = (TextView) convertView.findViewById(R.id.pdt_id);
            holder.ppid.setText(pdtid.get(position));

            holder.ppnam = (TextView) convertView.findViewById(R.id.pdt_nm);
            holder.ppnam.setText(pdtnm.get(position));

            holder.pri = (TextView) convertView.findViewById(R.id.pdt_pri);
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