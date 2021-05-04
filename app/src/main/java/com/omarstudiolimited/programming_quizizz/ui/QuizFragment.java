package com.omarstudiolimited.programming_quizizz.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.omarstudiolimited.programming_quizizz.MainActivity;
import com.omarstudiolimited.programming_quizizz.R;
import com.omarstudiolimited.programming_quizizz.ui.about.AboutViewModel;

public class QuizFragment extends Fragment {

    private AboutViewModel aboutViewModel;
    View view;
    TextView tv,qustion_number_tv;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String java_questions[] = {
            "Iterator returned by ArrayList is?",
            "Which of these is synchronised and isn’t sorted by natural order?",
            "In ListIterator, when a call to next() or previous(), if a call is made to set(E element) followed by add() or remove() what happens?",
            "Which of the following is true about super class?",

            "Which of the below are reserved keyword in Java?",
            "Which of the below is valid way to instantiate an array in java?",
            "What are the valid statements for static keyword in Java?",
    };
    String java_answers[] = {
            "Fail-fast",
            "Vector",
            "UnsupportedOperationException",
            "All of the above",
            "int",
            "int myArray [] = {1, 3, 5};",
            "We can have static block in a class",
    };
    String java_opt[] = {
            "Fail-fast","Fail-safe","Fail-equal","None of the above",
            "EnumSet", "LinkedList", "ConcurrentSkipListSet","Vector",
            "Compilation error", "UnsupportedOperationException", "ConcurrentModificationException","Non Of the Above",
            "Variables, methods and constructors which are declared private can be accessed only by the members of the super class","Variables, methods and constructors which are declared protected can be accessed by any subclass of the super class","Variables, methods and constructors which are declared public in the superclass can be accessed by any class","All of the above",
            "array","goto","null","int",
            "int myArray [] = {1, 3, 5};","int myArray [] [] = {1,2,3,4};","int myArray [] [] = {1,2,3,4};","int [] myArray = {“1”, “2”, “3”};",
            "We can have static block in a class","The static block in a class is executed every time an object of class is created","We can have static method implementations in interface","We can define static block inside a method",

    };
/////////////////////////////////////////////////////////////////////////////
    String python_questions[] = {
            "p1",
            "p2",
            "p3",
            "p4",
            "p5",
            "p6",
            "p7",
    };
    String python_answers[] = {
            "a1",
            "a2",
            "a3",
            "a4",
            "a5",
            "a6",
            "a7",
    };
    String python_opt[] = {
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    int qustion_number=0;
    String key;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("Quiz");
        key = getArguments().getString("key");
        submitbutton=(Button)view.findViewById(R.id.button3);
        qustion_number_tv=(TextView) view.findViewById(R.id.qustion_number_tv);
        tv=(TextView) view.findViewById(R.id.tvque);
        radio_g=(RadioGroup)view.findViewById(R.id.answersgrp);
        rb1=(RadioButton)view.findViewById(R.id.radioButton);
        rb2=(RadioButton)view.findViewById(R.id.radioButton2);
        rb3=(RadioButton)view.findViewById(R.id.radioButton3);
        rb4=(RadioButton)view.findViewById(R.id.radioButton4);
        tv.setText(java_questions[flag]);
        rb1.setText(java_opt[0]);
        rb2.setText(java_opt[1]);
        rb3.setText(java_opt[2]);
        rb4.setText(java_opt[3]);


        if (key.equals("Java")){
            java_quiz();
        }
        if (key.equals("Python")){
            python_quiz();
        }



        return view;
    }


    public void java_quiz(){
        qustion_number++;
        qustion_number_tv.setText("Q"+qustion_number+" Out of "+java_questions.length);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java_quiz();
//                qustion_number++;
//                String  cc = String.valueOf(correct+wrong);
//                qustion_number_tv.setText(qustion_number+"/"+cc);
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getActivity(), "الرجاء اختيار احد الاجابات", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(java_answers[flag])) {
            correct++;
            Toast.makeText(getActivity(), "اجابة صحيحة", Toast.LENGTH_SHORT).show();
        }
        else {
            wrong++;
            String correctanswer = java_answers[flag];
            Toast.makeText(getActivity(), "الاجابة الصحيحة هية->"+correctanswer, Toast.LENGTH_LONG).show();

        }
        flag++;
        if(flag<java_questions.length)
        {
            tv.setText(java_questions[flag]);
            rb1.setText(java_opt[flag*4]);
            rb2.setText(java_opt[flag*4 +1]);
            rb3.setText(java_opt[flag*4 +2]);
            rb4.setText(java_opt[flag*4 +3]);
        }
        else
        {
            marks=correct;
//            Toast.makeText(getActivity(), "صححح", Toast.LENGTH_SHORT).show();
            String name = "Java";
            String correct_val=String.valueOf(correct);
            String wrong_val=String.valueOf(wrong);
            String total_quiz_out_of_score=String.valueOf(correct+wrong);
            Fragment someFragment = new ResultFragment();
            Bundle args = new Bundle();
            args.putString("name", name);
            args.putString("correct",correct_val);
            args.putString("wrong",wrong_val);
            args.putString("outmark",total_quiz_out_of_score);
            someFragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
//            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
            transaction.commit();
//                    Intent in = new Intent(getApplicationContext(), result.class);
//                    startActivity(in);
        }
        radio_g.clearCheck();

    }


    public void python_quiz(){
        qustion_number++;
        qustion_number_tv.setText("Q"+qustion_number+" Out of "+python_questions.length);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                python_quiz();
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getActivity(), "الرجاء اختيار احد الاجابات", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(python_answers[flag])) {
            correct++;
            Toast.makeText(getActivity(), "اجابة صحيحة", Toast.LENGTH_SHORT).show();
        }
        else {
            wrong++;
            String correctanswer = python_answers[flag];
            Toast.makeText(getActivity(), "الاجابة الصحيحة هية->"+correctanswer, Toast.LENGTH_LONG).show();

        }
        flag++;
        if(flag<python_questions.length)
        {
            tv.setText(python_questions[flag]);
            rb1.setText(python_opt[flag*4]);
            rb2.setText(python_opt[flag*4 +1]);
            rb3.setText(python_opt[flag*4 +2]);
            rb4.setText(python_opt[flag*4 +3]);

        }
        else
        {
            marks=correct;
            String name = "Python";
            String correct_val=String.valueOf(correct);
            String wrong_val=String.valueOf(wrong);
            String total_quiz_out_of_score=String.valueOf(correct+wrong);
            Fragment someFragment = new ResultFragment();
            Bundle args = new Bundle();
            args.putString("name", name);
            args.putString("correct",correct_val);
            args.putString("wrong",wrong_val);
            args.putString("outmark",total_quiz_out_of_score);
            someFragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
//            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
            transaction.commit();
//                    Intent in = new Intent(getApplicationContext(), result.class);
//                    startActivity(in);
        }
        radio_g.clearCheck();

    }

}




























//        submitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (key2.equals("java")){
//                java_quiz();
//                }
//                if (key2.equals("python")){
//                    tv.setText("kfgerohtgiorehtiherpiothpoierhtpoierhtpoerhpotih");
//                    Toast.makeText(getActivity(), "  gfleglfdhgol ", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });