package com.omarstudiolimited.programming_quizizz.ui.types_prog_lang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.omarstudiolimited.programming_quizizz.MainActivity;
import com.omarstudiolimited.programming_quizizz.R;

public class Type_Prog_Lang_Fragment extends Fragment {

    private Type_Prog_Lang_ViewModel type_prog_lang_ViewModel;
    View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view  = inflater.inflate(R.layout.fragment_type_prog_lang, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("Programming Languages");
        ImageView logo_in_tool_bar= (ImageView) ((MainActivity) this.getActivity()).findViewById(R.id.logo);
        logo_in_tool_bar.setImageDrawable(null);
        return view;
    }
}