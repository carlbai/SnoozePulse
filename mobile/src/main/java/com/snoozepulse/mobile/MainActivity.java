package com.snoozepulse.mobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;


public class MainActivity extends Activity {

    boolean vibrate;
    public final static String VIBRATE = "com.snoozepulse.mobile.vibrate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSwitchClicked(View view) {
        // Is the toggle on?
        boolean on = ((Switch) view).isChecked();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        if (on) {
            builder.setMessage(R.string.on_message);
            // Enable vibrate
            vibrate = true;

            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            v.vibrate(500);
        } else {
            builder.setMessage(R.string.off_message);
            // Disable vibrate
            vibrate = false;
        }

        AlertDialog dialog = builder.create();
        dialog.show();

    }
}
