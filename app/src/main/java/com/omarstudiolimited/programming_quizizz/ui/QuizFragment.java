package com.omarstudiolimited.programming_quizizz.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;
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
            "Given the string (strawberries) saved in a variable called fruit, what would fruit.substring(2, 5) return?",

            "How can you achieve runtime polymorphism in Java?",

            "Given the following definitions, which of these expression will NOT evaluate to true? boolean b1 = true, b2 = false; int i1 = 1, i2 = 2;",

            "What can you use to create new instances in Java?",

            "How do you write a foreach loop that will iterate over ArrayList<Pencil>pencilCase?",

            "What code would you use to tell if \"schwifty\" is of type String?",

            "What does this code print?",

            "By implementing encapsulation, you cannot directly access the class's _ properties unless you are writing code inside the class itself.",

            "Which is the most up-to-date way to instantiate the current date?",

            "The runtime system starts your program by calling which function first?",

    };

    String java_opt[] = {
            "rawb", "raw" ,"awb" , "traw",
            "method overloading","method overrunning","method overriding","method calling",
            "(i1 | i2) == 3","i2 && b1","b1 || !b2","(i1 ^ i2) < 4",
            "constructor","another instance","field","private method",
            "for (Pencil pencil : pencilCase) {}","for (pencilCase.next()) {}","for (Pencil pencil : pencilCase.iterator()) {}","for (pencil in pencilCase) {}",
            "\"schwifty\".getType() == String","\"schwifty\".getClass().getSimpleName() == \"String\"","\"schwifty\".getType().equals(\"String\")","\"schwifty\" instanceof String",
            "0","positive number","negative number","compilation error",
            "private","protected","no-modifier","public",
            "new SimpleDateFormat(\"yyyy-MM-dd\").format(new Date())","new Date(System.currentTimeMillis())","LocalDate.now()","Calendar.getInstance().getTime()",
            "print","iterative","hello","main",


    };

    String java_answers[] = {
            "raw",
            "method overriding",
            "i2 && b1",
            "constructor",
            "for (Pencil pencil : pencilCase) {}",
            "\"schwifty\" instanceof String",
            "negative number",
            "private",
            "LocalDate.now()",
            "main"
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
    int qustion_number=1;
    String key;
    Chronometer chronometer;
    String no;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        ImageView logo_in_tool_bar= (ImageView) ((MainActivity) this.getActivity()).findViewById(R.id.logo);
//        toolbarTextView.setText("Quiz");
        key = getArguments().getString("key");
        toolbarTextView.setText(key+" Quiz");
        chronometer =(Chronometer) view.findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();

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
            logo_in_tool_bar.setImageResource(R.drawable.ic_java);
        }
        if (key.equals("Python")){
            tv.setText(python_questions[flag]);
            rb1.setText(python_opt[flag*4]);
            rb2.setText(python_opt[flag*4 +1]);
            rb3.setText(python_opt[flag*4 +2]);
            rb4.setText(python_opt[flag*4 +3]);
            python_quiz();
        }



        return view;
    }


    public void java_quiz(){
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + java_questions.length);
            submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java_quiz();
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getActivity(), "Please Select Answer", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(java_answers[flag])) {
            correct++;
            qustion_number++;
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + java_questions.length);

            if (qustion_number==java_questions.length){
                submitbutton.setText("Finish");}
        } else {
            wrong++;
            qustion_number++;
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + java_questions.length);
            if(qustion_number==java_questions.length){
                submitbutton.setText("Finish");
            }
        }
        flag++;
        if(flag<java_questions.length) {
            tv.setText(java_questions[flag]);
            rb1.setText(java_opt[flag*4]);
            rb2.setText(java_opt[(flag*4) +1]);
            rb3.setText(java_opt[(flag*4) +2]);
            rb4.setText(java_opt[(flag*4) +3]);
        } else {
            marks=correct;
            String name = "Java";
            String correct_val=String.valueOf(correct);
            String wrong_val=String.valueOf(wrong);
            String total_quiz_out_of_score=String.valueOf(correct+wrong);
            long time_until_finish = SystemClock.elapsedRealtime() - chronometer.getBase();
            int hours = (int) (time_until_finish / 3600000);
            int minutes = (int) (time_until_finish - hours * 3600000) / 60000;
            int seconds = (int) (time_until_finish - hours * 3600000 - minutes * 60000) / 1000;
            String time_m = String.valueOf(minutes);
            String time_s = String.valueOf(seconds);
            Fragment someFragment = new ResultFragment();
            Bundle args = new Bundle();
            args.putString("name", name);
            args.putString("correct",correct_val);
            args.putString("wrong",wrong_val);
            args.putString("outmark",total_quiz_out_of_score);
            args.putString("time_m_Finish",time_m);
            args.putString("time_s_Finish",time_s);
            someFragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
            transaction.commit();
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
            Toast.makeText(getActivity(), "Please Select Answer", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(python_answers[flag])) {
            correct++;

//            Toast.makeText(getActivity(), "اجابة صحيحة", Toast.LENGTH_SHORT).show();
        }
        else {
            wrong++;
//            String correctanswer = python_answers[flag];
//            Toast.makeText(getActivity(), "الاجابة الصحيحة هية->"+correctanswer, Toast.LENGTH_LONG).show();

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














//            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack



// qustion_number++;
////            String correctanswer = java_answers[flag];
////            Toast.makeText(getActivity(), "Wrong Answer", Toast.LENGTH_SHORT).show();
////            Toast.makeText(getActivity(), "The Correct Answer For Question "+(qustion_number-1)+" is " +"("+correctanswer+")", Toast.LENGTH_SHORT).show();











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