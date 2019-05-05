package com.estimote.notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;


//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class  MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ImageView rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        rl=(ImageView) findViewById(R.id.rl);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shop=new Intent(getApplicationContext(),view_shop.class);
                startActivity(shop);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication app = (MyApplication) getApplication();

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else if (!app.isBeaconNotificationsEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            app.enableBeaconNotifications();


        }

        else if (!app.isBeaconShoponeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShoponeNotification();

        }


        else if (!app.isBeaconShoptwoEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShoptwoNotification();

        }


        else if (!app.isBeaconShopthreeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShopthreeNotification();

        }


        else if (!app.isBeaconShopfourEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShopfourNotification();

        }

        else if (!app.isBeaconShopfourEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShopfourNotification();

        }

        else if (!app.isBeaconShopfiveEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //  app.enableBeaconNotifications();
            app.enableShopfiveNotification();

        }



        else if (!app.isBeaconProductoneShoponeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
         //   app.enableBeaconNotifications();
            app.enableProductoneShoponeNotification();

        }

        else if (!app.isBeaconProducttwoShoponeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //   app.enableBeaconNotifications();
            app.isBeaconProducttwoShoponeEnabled();

        }


        else if (!app.isBeaconProductoneShoptwoEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //   app.enableBeaconNotifications();
            app.isBeaconProductoneShoptwoEnabled();

        }

        else if (!app.isBeaconProducttwoShoptwoEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //   app.enableBeaconNotifications();
            app.enableProducttwoShoptwoNotification();

        }


        else if (!app.isBeaconProductoneShopthreeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //   app.enableBeaconNotifications();
            app.enableProductoneShopthreeNotification();

        }

        else if (!app.isBeaconProducttwoShopthreeEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            //   app.enableBeaconNotifications();
            app.enableProductwoShopthreeNotification();

        }

}
}
