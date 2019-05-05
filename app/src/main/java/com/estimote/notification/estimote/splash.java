package com.estimote.notification.estimote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.estimote.notification.MainActivity;
import com.estimote.notification.R;

/**
 * Created by dell on 7/13/2017.
 */

public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread background = new Thread()
        {
            public void run()
            {

                try
                {
                    // Thread will sleep for 5 seconds

                    sleep(3000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);

                    startActivity(i);

                    //Remove activity
                    finish();
                     /* */
                } catch (Exception e)
                {

                }
            }
        };
        // start thread
        background.start();
    }
}
