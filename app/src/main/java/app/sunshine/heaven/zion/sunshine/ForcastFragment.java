package app.sunshine.heaven.zion.sunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForcastFragment extends Fragment {

    private ArrayAdapter<String> mForcastAdapter;

    public ForcastFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.forcastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            MainActivity fetchweather = new MainActivity();
            fetchweather.FetchWeatherTask("94043");
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        String[] forcastArray = {
                "Today - Sunny - 88/63",
                "Tommorrow - Rainy - 66/51",
                "Today - Sunny - 88/63",
                "Tommorrow - Rainy - 66/51",
                "Today - Sunny - 88/63",
                "Tommorrow - Rainy - 66/51",
                "Today - Sunny - 88/63",
                "Tommorrow - Rainy - 66/51"
        };
        List<String> weekForcast = new ArrayList<String>(
                Arrays.asList(forcastArray));
        mForcastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forcast,
                R.id.list_item_textView,
                weekForcast);
        ListView listView = (ListView) rootView.findViewById(
                R.id.listview_forcast);
        listView.setAdapter(mForcastAdapter);


        return rootView;
    }
}
