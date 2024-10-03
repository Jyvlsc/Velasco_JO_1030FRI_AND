package com.ucb.midterm.news;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.Arrays;
import java.util.List;

public class HeadlineListFragment extends ListFragment {

    private OnHeadlineSelectedListener callback;
    private List<News> newsList;

    public interface OnHeadlineSelectedListener {
        void onHeadlineSelected(News news);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callback = (OnHeadlineSelectedListener) context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsList = Arrays.asList(
                new News("IMF Lowers Philippine Economic Growth Forecast", "The International Monetary Fund (IMF) downgraded its growth forecast for the Philippines for 2024 and 2025 due to global uncertainties and inflationary pressures. This is a notable adjustment as the country navigates post-pandemic recovery and economic challenges."),
                new News("South Korea’s President to Visit the Philippines", "South Korean President Yoon Suk-yeol is scheduled to visit the Philippines next week to discuss bilateral relations, including labor agreements and security cooperation. This visit also marks the 75th anniversary of diplomatic ties between the two nations."),
                new News("Arnolfo Teves Jr. Faces Extradition from Timor-Leste", "Former Philippine congressman Arnolfo Teves Jr. faces extradition from Timor-Leste after being implicated in several criminal cases, including the murder of a governor. Teves, on the Interpol red list, has been in detention since March."),
                new News("Tulfo Brothers Lead Senatorial Survey for 2025", "Brothers of Senator Raffy Tulfo top the latest surveys for the upcoming 2025 senatorial elections. They remain strong favorites due to their family’s media influence and reputation for advocating for ordinary citizens."),
                new News("Calls to End Hazing Culture Grow after Latest Verdict", "Public outrage continues after a Manila court convicted fraternity members for the 2017 hazing death of Horacio \"Atio\" Castillo. Advocates are pushing for stronger reforms to prevent hazing incidents in schools and organizations.")
        );
        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, newsList));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        callback.onHeadlineSelected(newsList.get(position));
    }
}