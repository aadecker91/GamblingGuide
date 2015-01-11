package com.tornadeck.gamblingguide;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Adam on 12/16/2014.
 */

public class BJBankrollActivity extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankroll);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double bj_std_dev = 1.15;
                double adjusted_std_dev = 0;
                double house_edge = 0.0053;
                double number_of_hands = 100;
                double adjusted_num_of_hands = 0;
                double average_bet = 0;
                double base_value;
                int final_value;
                int final_value_walk_away;

                try {
                    EditText editText = (EditText) findViewById(R.id.editText);
                    String a = editText.getText().toString();
                    average_bet = Double.parseDouble(a);
                } catch (NumberFormatException e) {
                    // TODO error handling
                }

                Spinner hoursSpinner=(Spinner) findViewById(R.id.spinner2);
                String hours = hoursSpinner.getSelectedItem().toString();

                if (hours.equals("30 Minutes")) {
                    adjusted_num_of_hands = 0.5 * number_of_hands;
                } else if (hours.equals("1 Hour")) {
                    adjusted_num_of_hands = number_of_hands;
                } else if (hours.equals("2 Hours")) {
                    adjusted_num_of_hands = 2 * number_of_hands;
                } else if (hours.equals("3 Hours")) {
                    adjusted_num_of_hands = 3 * number_of_hands;
                } else if (hours.equals("4 Hours")) {
                    adjusted_num_of_hands = 4 * number_of_hands;
                } else if (hours.equals("8 Hours")) {
                    adjusted_num_of_hands = 8 * number_of_hands;
                }

                adjusted_std_dev = 1.6 * bj_std_dev;

                base_value = (average_bet * adjusted_num_of_hands) * house_edge;
                final_value = (int) (base_value + (adjusted_std_dev * Math.sqrt(adjusted_num_of_hands) * average_bet));
                final_value_walk_away = (int) ((bj_std_dev * Math.sqrt(adjusted_num_of_hands) * average_bet)/2);

                String text_value = Integer.toString(final_value);
                String text_value_walk_away = Integer.toString(final_value_walk_away);

                TextView bankroll = (TextView) findViewById(R.id.textView2);
                bankroll.setText(text_value + " Dollars");

                TextView walkAway = (TextView) findViewById(R.id.textView7);
                walkAway.setText("+" + text_value_walk_away + " Dollars");
            }
        });
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
