package com.chenxq.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InstrumentView iView = (InstrumentView) findViewById(R.id.iView);
        final TextView txtView = (TextView) findViewById(R.id.txtView);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                iView.setReferValue(682, new InstrumentView.RotateListener() {
                    @Override
                    public void rotate(float sweepAngle, final float value) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtView.setText(Math.round(value) + "");
                            }
                        });
                    }
                });
            }
        },1000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
