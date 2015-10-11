package styx.com.ride;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button_main_schedule,button_main_join;
    TextView textview_main_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_main_schedule=(Button)findViewById(R.id.button_main_schedule);
        button_main_join=(Button)findViewById(R.id.button_main_join);
        textview_main_username=(TextView)findViewById(R.id.textview_main_username);
        textview_main_username.setText(ParseUser.getCurrentUser().get("fullname").toString());
        button_main_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int myNumber = 42;
                String myString = "the number is " + myNumber;
                Date myDate = new Date();

                JSONArray myArray = new JSONArray();
                myArray.put(myString);
                myArray.put(myNumber);

                JSONObject myObject = new JSONObject();
                try {
                    myObject.put("number", myNumber);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    myObject.put("string", myString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                byte[] myData = { 4, 8, 16, 32 };

                ParseObject bigObject = new ParseObject("BigObject");
                bigObject.put("myNumber", myNumber);
                bigObject.put("myString", myString);
                bigObject.put("myDate", myDate);
                bigObject.put("myData", myData);
                bigObject.put("myArray", myArray);
                bigObject.put("myObject", myObject);
                bigObject.put("myNull", JSONObject.NULL);
                bigObject.saveInBackground();
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
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
