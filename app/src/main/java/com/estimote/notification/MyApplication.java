package com.estimote.notification;

import android.app.Application;

import com.estimote.coresdk.common.config.EstimoteSDK;
import com.estimote.notification.estimote.BeaconID;
import com.estimote.notification.estimote.BeaconNotificationsManager;
import com.estimote.notification.estimote.BeaconProduct;
import com.estimote.notification.estimote.BeaconProduct2;
import com.estimote.notification.estimote.BeaconShop;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MyApplication extends Application {

    private boolean beaconNotificationsEnabled = false;
    private boolean beaconShoponeEnabled = false;
    private boolean beaconShoptwoEnabled = false;
    private boolean beaconShopthreeEnabled = false;
    private boolean beaconShopfourEnabled = false;
    private boolean beaconShopfiveEnabled = false;

    private boolean beaconProductoneShoponeEnabled = false;
    private boolean beaconProducttwoShoponeEnabled = false;

    private boolean beaconProductoneShoptwoEnabled = false;
    private boolean beaconProducttwoShoptwoEnabled = false;

    private boolean beaconProductoneShopthreeEnabled = false;
    private boolean beaconProducttwoShopthreeEnabled = false;

    @Override
    public void onCreate() {
        super.onCreate();

        // TODO: put your App ID and App Token here
        // You can get them by adding your app on https://cloud.estimote.com/#/apps
        EstimoteSDK.initialize(getApplicationContext(), "<#App ID#>", "<#App Token#>");

        // uncomment to enable debug-level logging
        // it's usually only a good idea when troubleshooting issues with the Estimote SDK
//        EstimoteSDK.enableDebugLogging(true);
    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) {
            return;
        }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("00000000-0000-0000-0000-000000000000", 1, 1),
                "Welcome ! BEACON NO 1 FOUND AND CONNECTED  ",
                "Goodbye, world.");
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;

    }

    public void enableShoponeNotification() {
        if (beaconShoponeEnabled) {
            return;
        }

        BeaconProduct beaconNotificationsManageshp1 = new BeaconProduct(this);
        beaconNotificationsManageshp1.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("11111111-1111-1111-1111-111111111111", 1, 1),
                "Welcome ! BEACON NO 2 FOUND AND CONNECTED  ",
                "Thanks , world.");
        beaconNotificationsManageshp1.startMonitoring();

        beaconShoponeEnabled = true;
    }

    public boolean isBeaconShoponeEnabled() {
        return beaconShoponeEnabled;
    }


    public void enableShoptwoNotification() {
        if (beaconShoptwoEnabled) {
            return;
        }

        BeaconProduct2 beaconNotificationsManageshp2 = new BeaconProduct2(this);
        beaconNotificationsManageshp2.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("22222222-2222-2222-2222-222222222222", 1, 1),
                "Welcome to shop , world.",
                "Thanks for shopping, world.");
        beaconNotificationsManageshp2.startMonitoring();

        beaconShoptwoEnabled = true;
    }

    public boolean isBeaconShoptwoEnabled() {
        return beaconShoptwoEnabled;
    }


    public void enableShopthreeNotification() {
        if (beaconShopthreeEnabled) {
            return;
        }

        BeaconProduct beaconNotificationsManageshp3 = new BeaconProduct(this);
        beaconNotificationsManageshp3.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("33333333-3333-3333-3333-333333333333", 1, 1),
                "Welcome to shop , world.",
                "Thanks for shopping, world.");
        beaconNotificationsManageshp3.startMonitoring();

        beaconShopthreeEnabled = true;
    }

    public boolean isBeaconShopthreeEnabled() {
        return beaconShopthreeEnabled;
    }


    public void enableShopfourNotification() {
        if (beaconShopfourEnabled) {
            return;
        }

        BeaconProduct beaconNotificationsManageshp4 = new BeaconProduct(this);
        beaconNotificationsManageshp4.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("44444444-4444-4444-4444-444444444444", 1, 1),
                "Welcome to shop , world.",
                "Thanks for shopping, world.");
        beaconNotificationsManageshp4.startMonitoring();

        beaconShopfourEnabled = true;
    }

    public boolean isBeaconShopfourEnabled() {
        return beaconShopfourEnabled;
    }


    public void enableShopfiveNotification() {
        if (beaconShopfourEnabled) {
            return;
        }

        BeaconProduct beaconNotificationsManageshp5 = new BeaconProduct(this);
        beaconNotificationsManageshp5.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("55555555-5555-5555-5555-555555555555", 1, 1),
                "Welcome to shop , world.",
                "Thanks for shopping, world.");
        beaconNotificationsManageshp5.startMonitoring();

        beaconShopfiveEnabled = true;
    }

    public boolean isBeaconShopfiveEnabled() {
        return beaconShopfiveEnabled;
    }


    public void enableProductoneShoponeNotification() {
        if (beaconProductoneShoponeEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag12 = new BeaconShop(this);
        beaconNotificationsManag12.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("12121212-1212-1212-1212-121212121212", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag12.startMonitoring();

        beaconProductoneShoponeEnabled = true;
    }

    public boolean isBeaconProductoneShoponeEnabled() {
        return beaconProductoneShoponeEnabled;
    }


    public void enableProducttwoShoponeNotification() {
        if (beaconProducttwoShoponeEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag13 = new BeaconShop(this);
        beaconNotificationsManag13.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("13131313-1313-1313-1313-131313131313", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag13.startMonitoring();

        beaconProducttwoShoponeEnabled = true;
    }

    public boolean isBeaconProducttwoShoponeEnabled() {
        return beaconProducttwoShoponeEnabled;
    }


    public void enableProductoneShoptwoNotification() {
        if (beaconProductoneShoptwoEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag21 = new BeaconShop(this);
        beaconNotificationsManag21.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("21212121-2121-2121-2121-212121212121", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag21.startMonitoring();

        beaconProductoneShoptwoEnabled = true;
    }

    public boolean isBeaconProductoneShoptwoEnabled() {
        return beaconProductoneShoponeEnabled;
    }


    public void enableProducttwoShoptwoNotification() {
        if (beaconProducttwoShoptwoEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag23 = new BeaconShop(this);
        beaconNotificationsManag23.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("23232323-2323-2323-2323-232323232323", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag23.startMonitoring();

        beaconProducttwoShoptwoEnabled = true;
    }

    public boolean isBeaconProducttwoShoptwoEnabled() {
        return beaconProducttwoShoptwoEnabled;
    }


    public void enableProductoneShopthreeNotification() {
        if (beaconProducttwoShoptwoEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag31 = new BeaconShop(this);
        beaconNotificationsManag31.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("31313131-3131-3131-3131-313131313131", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag31.startMonitoring();

        beaconProductoneShopthreeEnabled = true;
    }

    public boolean isBeaconProductoneShopthreeEnabled() {
        return beaconProductoneShopthreeEnabled;
    }



    public void enableProductwoShopthreeNotification() {
        if (beaconProducttwoShopthreeEnabled) {
            return;
        }

        BeaconShop beaconNotificationsManag32 = new BeaconShop(this);
        beaconNotificationsManag32.addNotification(
                // TODO: replace with UUID, major and minor of your own beacon
                new BeaconID("32323232-3232-3232-3232-323232323232", 1, 1),
                "Offers for you , world.",
                "Thankyou, world.");
        beaconNotificationsManag32.startMonitoring();

        beaconProducttwoShopthreeEnabled = true;
    }

    public boolean isBeaconProducttwoShopthreeEnabled() {
        return beaconProducttwoShopthreeEnabled;
    }
}