package com.tornadeck.gamblingguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Adam on 12/15/2014.
 */
public class CrapsActivity extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        // TODO add a feature that can track how much you've won or lost

    }

//TODO: Implement settings
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Intent intent = new Intent(this, SettingsActivity.class);
//            startActivity(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void goToBankRoll(View view) {
        Intent intent = new Intent(this, CrapsBankrollActivity.class);
        startActivity(intent);
    }

    public void goToBetting(View view) {
        Intent intent = new Intent(this, CrapsBettingActivity.class);
        startActivity(intent);
    }

//TODO: Implement Practice
//    public void goToPractice(View view) {
//        Intent intent = new Intent(this, CrapsPracticeActivity.class);
//        startActivity(intent);
//    }

    public void goToReadMe(View view) {
        Intent intent = new Intent(this, CrapsReadMeActivity.class);
        startActivity(intent);
    }
}
