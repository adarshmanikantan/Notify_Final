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

public class view_pdts5 extends AppCompatActivity {

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
    ArrayList<String> pdttyp;
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
        pdtid = new ArrayList<String>();
        pdtnm = new ArrayList<String>();
        pdttyp = new ArrayList<String>();
        pdtprice = new ArrayList<String>();

        String s = "55555555-5555-5555-5555-555555555555";
        params.put("beaconid", s);
        client.get("http://srishti-systems.info/projects/ishoppee/user/viewallproduct.php?", params, new AsyncHttpResponseHandler() {
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
                            String sid = jobj.getString("Shops_id");
                            shpid.add("Shops id:  "+sid);

                            SharedPreferences pref=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
                            SharedPreferences.Editor editor=pref.edit();
                            editor.putString("id",sid);
                            editor.apply();
//
//                                String sname = jobj.getString("Product_id");
//                                shpname.add("Product id:  "+sname);



                            String pid = jobj.getString("Product_id");
                            pdtid.add("Product id:  "+pid);

                            String shop_nm = jobj.getString("Shop_name");
                            shpname.add("Shop Name:  "+pid);

                            String pname = jobj.getString("ProductName");
                            pdtnm.add("Product Name:     "+pname);

                            String pdt_typ = jobj.getString("Product_type");
                            pdttyp.add("Product Type:  "+pid);

                            String pprice = jobj.getString("ProductPrice");
                            pdtprice.add(pprice);
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
            holder.ssid.setText(shpname.get(position));


//                    holder.ssnam = (TextView) convertView.findViewById(R.id.shp_nm);
//                    holder.ssnam.setText(shpname.get(position));

            holder.ppid = (TextView) convertView.findViewById(R.id.pdt_id);
            holder.ppid.setText(pdttyp.get(position));


            holder.ppnam = (TextView) convertView.findViewById(R.id.pdt_nm);
            holder.ppnam.setText(pdtnm.get(position));

            holder.pri = (TextView) convertView.findViewById(R.id.pdt_pri);
            holder.pri.setText(pdtprice.get(position));
            holder.pri.setVisibility(View.GONE);


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



