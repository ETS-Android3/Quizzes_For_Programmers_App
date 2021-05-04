package com.omarstudiolimited.programming_quizizz.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.omarstudiolimited.programming_quizizz.MainActivity;
import com.omarstudiolimited.programming_quizizz.R;
import com.omarstudiolimited.programming_quizizz.ui.QuizFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    View view;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView toolbarTextView = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("Home");

        Button java_b=(Button)view.findViewById(R.id.java_b);
        java_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = "Java";
                Fragment someFragment = new QuizFragment();
                Bundle args = new Bundle();
                args.putString("key", key);
                someFragment.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });


        Button python_b=(Button)view.findViewById(R.id.python_b);
        python_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = "Python";
                Fragment someFragment = new QuizFragment();
                Bundle args = new Bundle();
                args.putString("key", key);
                someFragment.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });



        return view;
    }
    }
////        Intent intent = getIntent();
//        submitbutton=(Button)view.findViewById(R.id.button3);
//        tv=(TextView) view.findViewById(R.id.tvque);
//        radio_g=(RadioGroup)view.findViewById(R.id.answersgrp);
//        rb1=(RadioButton)view.findViewById(R.id.radioButton);
//        rb2=(RadioButton)view.findViewById(R.id.radioButton2);
//        rb3=(RadioButton)view.findViewById(R.id.radioButton3);
//        rb4=(RadioButton)view.findViewById(R.id.radioButton4);
//        tv.setText(questions[flag]);
//        rb1.setText(opt[0]);
//        rb2.setText(opt[1]);
//        rb3.setText(opt[2]);
//        rb4.setText(opt[3]);
//        submitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(radio_g.getCheckedRadioButtonId()==-1)
//                {
//                    Toast.makeText(getActivity(), "الرجاء اختيار احد الاجابات", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
//                String ansText = uans.getText().toString();
//                if(ansText.equals(answers[flag])) {
//                    correct++;
//                }
//                else {
//                    wrong++;
//                }
//                flag++;
//                if(flag<questions.length)
//                {
//                    tv.setText(questions[flag]);
//                    rb1.setText(opt[flag*4]);
//                    rb2.setText(opt[flag*4 +1]);
//                    rb3.setText(opt[flag*4 +2]);
//                    rb4.setText(opt[flag*4 +3]);
//                }
//                else
//                {
//                    marks=correct;
//                    Toast.makeText(getActivity(), "صححح", Toast.LENGTH_SHORT).show();
////                    Intent in = new Intent(getApplicationContext(), result.class);
////                    startActivity(in);
//                }
//                radio_g.clearCheck();
//            }
//        });
//
//        return view;
//    }
//}