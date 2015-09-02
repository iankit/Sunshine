package app.sunshine.heaven.zion.sunshine;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
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
public class MainActivityFragment extends Fragment {

    private ArrayAdapter<String> mForcastAdapter;

    public MainActivityFragment() {
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
