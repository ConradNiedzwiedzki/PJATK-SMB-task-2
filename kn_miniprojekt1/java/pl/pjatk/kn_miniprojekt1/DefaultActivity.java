package pl.pjatk.kn_miniprojekt1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

public abstract class DefaultActivity extends AppCompatActivity {


    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isDarkMode = sharedPreferences.getBoolean(getString(R.string.themeSetting), false);

        if(isDarkMode) {
            RelativeLayout rl = (RelativeLayout) findViewById(R.id.mainLayout);
            rl.setBackgroundColor(Color.GRAY);
        }
    }
}
