package com.estimote.notification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
 * Created by dell on 7/29/2017.
 */

public class view_pdts extends AppCompatActivity {

    private static final String TAG = "VIEW_PRODUCT";
        AsyncHttpClient client;
        JSONArray jarray;
        JSONObject jobject;
        RequestParams params;
        ListView lv;
        JSONObject jsonObject;
        JSONArray jsonArray;




        ArrayList<String> shpid;
        ArrayList<String> shpname;
        ArrayList<String> pdtnm;
        ArrayList<String> offers;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.view_shop);
            lv=(ListView)findViewById(R.id.view_offr_lst);

            client = new AsyncHttpClient();
            params = new RequestParams();
            shpid = new ArrayList<String>();
            shpname = new ArrayList<String>();
//            pdtid = new ArrayList<String>();
            pdtnm = new ArrayList<String>();
            offers=new ArrayList<String>();
//            pdttyp = new ArrayList<String>();
//            pdtprice = new ArrayList<String>();

            String s = "11111111-1111-1111-1111-111111111111";
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
                                editor.putString("id1",sid);
                                editor.apply();
//
//                                String sname = jobj.getString("Product_id");
//                                shpname.add("Product id:  "+sname);



//                                String pid = jobj.getString("Product_id");
//                                pdtid.add("Product id:  "+pid);

                                String shop_nm = jobj.getString("ShopName");
                                shpname.add("Shop Name:  "+shop_nm);

                                String pname = jobj.getString("Offered_Products");
                                pdtnm.add("Product Name:     "+pname);
                                String soffer = jobj.getString("offers");
                                offers.add("Offers:     "+soffer);

//                                String pdt_typ = jobj.getString("Product_type");
//                                pdttyp.add("Product Type:  "+pdt_typ);
//
//                                String pprice = jobj.getString("ProductPrice");
//                                pdtprice.add(pprice);
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
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i =new Intent(view_pdts.this,Fashionhub.class);
                    startActivity(i);
                }
            });
        }
            class adapter extends BaseAdapter {
                LayoutInflater inflater;

                @Override
                public int getCount() {
                    // TODO Auto-generated method stub
                    return shpname.size();
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
                    holder.ppid.setText(shpname.get(position));


                    holder.ppnam = (TextView) convertView.findViewById(R.id.pdt_nm);
                    holder.ppnam.setText(pdtnm.get(position));

                    holder.pri = (TextView) convertView.findViewById(R.id.pdt_pri);
                    holder.pri.setText(offers.get(position));
                // holder.pri.setVisibility(View.GONE);


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



