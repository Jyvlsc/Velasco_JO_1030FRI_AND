package com.ucb.midterm.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class NewsContentFragment extends Fragment {
    private static final String ARG_HEADLINE = "headline";
    private static final String ARG_CONTENT = "content";

    public static NewsContentFragment newInstance(String headline, String content) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HEADLINE, headline);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);
        if (getArguments() != null) {
            String headline = getArguments().getString(ARG_HEADLINE);
            String content = getArguments().getString(ARG_CONTENT);
            ((TextView) view.findViewById(R.id.news_headline)).setText(headline);
            ((TextView) view.findViewById(R.id.news_content)).setText(content);
        }
        return view;
    }
}