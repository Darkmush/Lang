package se.dara.lang;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import se.dara.lang.db.LocaleHandler;


public class MainActivity extends ActionBarActivity {

    private LocaleHandler localeHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localeHandler = new LocaleHandler(this);
        localeHandler.downloadLanguages();


        final Button button = (Button) findViewById(R.id.langbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toggleLanguage();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toggleLanguage(){
        localeHandler.toggleLanguage();

        long st = System.currentTimeMillis();
        localeHandler.cacheLanguage();
        long ct = System.currentTimeMillis();

        ((TextView) findViewById(R.id.text1)).setText(localeHandler.getString("String0"));
        ((TextView) findViewById(R.id.textView)).setText(localeHandler.getString("String1"));
        ((TextView) findViewById(R.id.textView2)).setText(localeHandler.getString("String2"));
        ((TextView) findViewById(R.id.textView3)).setText(localeHandler.getString("String3"));
        ((TextView) findViewById(R.id.textView4)).setText(localeHandler.getString("String4"));
        ((TextView) findViewById(R.id.textView5)).setText(localeHandler.getString("String5"));
        ((TextView) findViewById(R.id.textView6)).setText(localeHandler.getString("String6"));
        ((TextView) findViewById(R.id.textView7)).setText(localeHandler.getString("String7"));
        ((TextView) findViewById(R.id.textView8)).setText(localeHandler.getString("String8"));
        ((TextView) findViewById(R.id.textView9)).setText(localeHandler.getString("String9"));
        ((TextView) findViewById(R.id.textView10)).setText(localeHandler.getString("String10"));
        ((TextView) findViewById(R.id.textView11)).setText(localeHandler.getString("String11"));
        ((TextView) findViewById(R.id.textView12)).setText(localeHandler.getString("String12"));
        ((TextView) findViewById(R.id.textView13)).setText(localeHandler.getString("String13"));
        ((TextView) findViewById(R.id.textView14)).setText(localeHandler.getString("String14"));

        long et = System.currentTimeMillis();
        ((TextView) findViewById(R.id.textView15)).setText("Cache loaded in " + (ct-st) + "ms.\n" +
                "Texts translated in " + (et-ct) + "ms.");

    }

}
