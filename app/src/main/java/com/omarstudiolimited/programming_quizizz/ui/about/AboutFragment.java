package com.omarstudiolimited.programming_quizizz.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.omarstudiolimited.programming_quizizz.MainActivity;
import com.omarstudiolimited.programming_quizizz.R;

public class AboutFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    View view;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("About");
        return view;
    }
}