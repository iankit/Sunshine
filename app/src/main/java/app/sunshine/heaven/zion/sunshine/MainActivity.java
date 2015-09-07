package app.sunshine.heaven.zion.sunshine;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FetchWeatherTask("94043");

        Log.d(TAG,"Main UI is running");
    }

    public static void FetchWeatherTask(String params) {
        final String base_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?";
        final String quary_param = "q";
        final String format_param = "mode";
        final String units_param = "units";
        final String days_param = "cnt";
        String format = "json";
        String units = "metric";
        int numDays = 7;
        Uri.Builder forcastUrl = Uri.parse(base_URL).buildUpon()
                        .appendQueryParameter(quary_param,params)
                        .appendQueryParameter(format_param,format)
                        .appendQueryParameter(units_param,units)
                        .appendQueryParameter(days_param, Integer.toString(numDays));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(String.valueOf(forcastUrl))
                .build();
        Log.v(TAG,"BUILT URL"+forcastUrl.toString());
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                try {
                    if (response.isSuccessful()){
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG,"Exception Cought",e);
                }

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
