package com.ucb.midterm.news;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements HeadlineListFragment.OnHeadlineSelectedListener {

    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(isLandscape ? R.id.headline_container : R.id.fragment_container, new HeadlineListFragment())
                    .commit();
        }
    }

    @Override
    public void onHeadlineSelected(News selectedNews) {
        NewsContentFragment contentFragment = NewsContentFragment.newInstance(selectedNews.getHeadline(), selectedNews.getContent());

        if (isLandscape) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_container, contentFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, contentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}