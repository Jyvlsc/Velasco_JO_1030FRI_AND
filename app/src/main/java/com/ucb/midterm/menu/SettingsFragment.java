package com.ucb.midterm.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button exitButton = view.findViewById(R.id.exitButton);
        exitButton.setOnClickListener(v -> {
            // Exit the app
            requireActivity().finishAffinity();
        });

        return view;
    }
}