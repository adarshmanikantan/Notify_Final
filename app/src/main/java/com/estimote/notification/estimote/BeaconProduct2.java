package com.estimote.notification.estimote;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;
import com.estimote.notification.R;
import com.estimote.notification.view_pdts2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 8/25/2017.
 */


public class BeaconProduct2 {

    private static final String TAG = "BeaconNotifications";

    private BeaconManager beaconManager;

    private List<BeaconRegion> regionsToMonitor = new ArrayList<>();
    private HashMap<String, String> enterMessages = new HashMap<>();
    private HashMap<String, String> exitMessages = new HashMap<>();

    private Context context;

    private int notificationID = 0;

    public BeaconProduct2(Context context) {
        this.context = context;
        beaconManager = new BeaconManager(context);
        beaconManager.setMonitoringListener(new BeaconManager.BeaconMonitoringListener() {
            @Override
            public void onEnteredRegion(BeaconRegion region, List<Beacon> list) {
                Log.d(TAG, "onEnteredRegion: " + region.getIdentifier());
                String message = enterMessages.get(region.getIdentifier());
                if (message != null) {
                    showNotification(message);
                }
            }

            @Override
            public void onExitedRegion(BeaconRegion region) {
                Log.d(TAG, "onExitedRegion: " + region.getIdentifier());
                String message = exitMessages.get(region.getIdentifier());
                if (message != null) {
                    showNotification(message);
                }
            }
        });
    }

    public void addNotification(BeaconID beaconID, String enterMessage, String exitMessage) {
        BeaconRegion region = beaconID.toBeaconRegion();
        enterMessages.put(region.getIdentifier(), enterMessage);
        exitMessages.put(region.getIdentifier(), exitMessage);
        regionsToMonitor.add(region);
    }

    public void startMonitoring() {
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                for (BeaconRegion region : regionsToMonitor) {
                    beaconManager.startMonitoring(region);
                }
            }
        });
    }

    private void showNotification(String message) {
        Intent resultIntent = new Intent(context, view_pdts2.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(
                context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                //.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.carr))
                .setSmallIcon(R.mipmap.carr)
                .setContentTitle("iShoppe Notifications")
                .setContentText(message)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(resultPendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notificationID++, builder.build());
    }
}