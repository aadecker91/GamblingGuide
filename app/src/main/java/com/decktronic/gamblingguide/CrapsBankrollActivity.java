package com.decktronic.gamblingguide;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Adam on 1/9/2015.
 */
public class CrapsBankrollActivity extends ActionBarActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankroll);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final double average_rolls = 3.376;
                final double pass_std_dev = 1.0;
                final double four_ten_std_dev = 1.41;
                final double five_nine_std_dev = 1.22;
                final double six_eight_std_dev = 1.10;
                double adjusted_pass_std_dev;
                double adjusted_four_ten_std_dev;
                double adjusted_five_nine_std_dev;
                double adjusted_six_eight_std_dev;
                final double house_edge = 0.0141;
                double number_of_rolls = 170;
                double adjusted_num_of_rolls = 0;
                double rolls_resolved;
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
                    adjusted_num_of_rolls = 0.5 * number_of_rolls;
                } else if (hours.equals("1 Hour")) {
                    adjusted_num_of_rolls = number_of_rolls;
                } else if (hours.equals("2 Hours")) {
                    adjusted_num_of_rolls = 2 * number_of_rolls;
                } else if (hours.equals("3 Hours")) {
                    adjusted_num_of_rolls = 3 * number_of_rolls;
                } else if (hours.equals("4 Hours")) {
                    adjusted_num_of_rolls = 4 * number_of_rolls;
                } else if (hours.equals("8 Hours")) {
                    adjusted_num_of_rolls = 8 * number_of_rolls;
                }

                rolls_resolved = adjusted_num_of_rolls / average_rolls;

                adjusted_pass_std_dev = 1.6 * pass_std_dev;
                adjusted_four_ten_std_dev = 1.6 * four_ten_std_dev;
                adjusted_five_nine_std_dev = 1.6 * five_nine_std_dev;
                adjusted_six_eight_std_dev = 1.6 * six_eight_std_dev;

                //TODO average_bet = average_rolls * average_bet;

                base_value = (average_bet * rolls_resolved) * house_edge;
                final_value = (int) Math.round(base_value + (adjusted_pass_std_dev * Math.sqrt(rolls_resolved) * average_bet) + (adjusted_four_ten_std_dev * Math.sqrt(rolls_resolved) * average_bet * 6 / 36) + (adjusted_five_nine_std_dev * Math.sqrt(rolls_resolved) * average_bet * 8 / 36) + (adjusted_six_eight_std_dev * Math.sqrt(rolls_resolved) * average_bet * 10 / 36));
                final_value_walk_away = (int) Math.round((0.5 * pass_std_dev * Math.sqrt(rolls_resolved) * average_bet) + (0.5 * four_ten_std_dev * Math.sqrt(rolls_resolved) * average_bet * 6 / 36) + (0.5 * five_nine_std_dev * Math.sqrt(rolls_resolved) * average_bet * 8 / 36) + (0.5 * six_eight_std_dev * Math.sqrt(rolls_resolved) * average_bet * 10 / 36));

                String text_value = Integer.toString(final_value);
                String text_value_walk_away = Integer.toString(final_value_walk_away);

                TextView bankroll = (TextView) findViewById(R.id.textView2);
                bankroll.setText(text_value + " Dollars");

                TextView walkAway = (TextView) findViewById(R.id.textView7);
                walkAway.setText("+" + text_value_walk_away + " Dollars");
            }
        });
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
}
