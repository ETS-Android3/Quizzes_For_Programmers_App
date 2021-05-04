package com.omarstudiolimited.programming_quizizz.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.omarstudiolimited.programming_quizizz.MainActivity;
import com.omarstudiolimited.programming_quizizz.R;
import com.omarstudiolimited.programming_quizizz.ui.about.AboutViewModel;

public class ResultFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    View view;
    TextView tvr;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_results, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("Results");

        String name=getArguments().getString("name");
        String correct_val=getArguments().getString("correct");
        String wrong_val=getArguments().getString("wrong");
        String outmark=getArguments().getString("outmark");
        tvr=(TextView)view.findViewById(R.id.tvr);
        tvr.setText(
                "Results:"+"\n"+"Your Score in "+name+" Quiz is ("+correct_val+") Out of ("+outmark+")"+
                        "\n"+"Correct answer ("+correct_val+")"+
                        "\n"+"Wrong answer ("+wrong_val+")"
        );
        return view;
    }
}