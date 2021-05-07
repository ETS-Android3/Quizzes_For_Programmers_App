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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
            "What is an abstract class?",
            "What happens when you use the build-in function any() on a list?",
            "What data structure does a binary tree degenerate to if it isn't balanced properly?",
            "What statement about static methods is true?",
            "What are attributes?",
            "What is the term to describe this code? count, fruit, price = (2, 'apple', 3.5)",
            "What built-in list method would you use to remove items from a list?",
        "What is one of the most common use of Python's sys library?",
        "What is the runtime of accessing a value in a dictionary by using its key?",
        "What is the correct syntax for defining a class called Game?"
    };

    String python_opt[] = {
            "An abstract class is the name for any class from which you can instantiate an object","Abstract classes must be redefined any time an object is instantiated from them.","Abstract classes must inherit from concrete classes.","An abstract class exists only so that other \"concrete\" classes can inherit from the abstract class.",
            "The any() function will randomly return any item from the list.","The any() function returns True if any item in the list evaluates to True. Otherwise, it returns False.","The any() function takes as arguments the list to check inside, and the item to check for. If \"any\" of the items in the list match the item to check for, the function returns True.","The any() function returns a Boolean value that answers the question \"Are there any items in this list?\"",
            "linked list","queue","set","OrderedDict",
            "Static methods are called static because they always return None.","Static methods can be bound to either a class or an instance of a class.","Static methods serve mostly as utility methods or helper methods, since they can't access or modify a class's state.","Static methods can access and modify the state of a class or an instance of a class.",
            "Attributes are long-form version of an if/else statement, used when testing for equality between objects.","Attributes are a way to hold data or describe a state for a class or an instance of a class.","Attributes are strings that describe characteristics of a class.","Function arguments are called \"attributes\" in the context of class methods and instance methods.",
            "tuple assignment","tuple unpacking","tuple matching","tuple duplication",
            "\".delete()\" method","pop(my_list)","del(my_list)","\".pop()\" method",
            "to capture command-line arguments given at a file's runtime","to connect various systems, such as connecting a web front end, an API service, a database, and a mobile app","to take a snapshot of all the packages and libraries in your virtual environment","to scan the health of your Python ecosystem while inside a virtual environment",
            "O(n), also called linear time.","O(log n), also called logarithmic time.\n","O(n^2), also called quadratic time.","O(1), also called constant time.",
            "class Game: pass","def Game(): pass","def Game: pass","class Game(): pass",

    };

    String python_answers[] = {
            "An abstract class exists only so that other \"concrete\" classes can inherit from the abstract class.",
            "The any() function returns True if any item in the list evaluates to True. Otherwise, it returns False.",
            "linked list\n",
            "Static methods serve mostly as utility methods or helper methods, since they can't access or modify a class's state.",
            "Attributes are a way to hold data or describe a state for a class or an instance of a class.",
            "tuple unpacking",
            "\".pop()\" method",
            "to capture command-line arguments given at a file's runtime",
            "O(1), also called constant time.",
            "class Game: pass"
    };

//    ========================================================
String php_questions[] = {
        " ?",
        "php2",
        "p3",
        "p4",
        "p5",
        "p6",
        "p7",
};
    String php_answers[] = {
            "a1",
            "a2",
            "a3",
            "a4",
            "a5",
            "a6",
            "a7",
    };
    String php_opt[] = {
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
            "op1","op2","op3","op4",
    };

//    ========================================================
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    int qustion_number=1;
    String key;
    Chronometer chronometer;
    String no;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        correct=0;
        wrong=0;
        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        ImageView logo_in_tool_bar= (ImageView) ((MainActivity) this.getActivity()).findViewById(R.id.logo);
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
            String op1=java_opt[flag*4];
            String op2=java_opt[(flag*4)+1];
            String op3=java_opt[(flag*4)+2];
            String op4=java_opt[(flag*4)+3];
            ArrayList<String>arr_ans_rand=new ArrayList<>();
            arr_ans_rand.add(op1);
            arr_ans_rand.add(op2);
            arr_ans_rand.add(op3);
            arr_ans_rand.add(op4);
            Collections.shuffle(arr_ans_rand);
            rb1.setText(arr_ans_rand.get(0));
            rb2.setText(arr_ans_rand.get(1));
            rb3.setText(arr_ans_rand.get(2));
            rb4.setText(arr_ans_rand.get(3));
            java_quiz();
            logo_in_tool_bar.setImageResource(R.drawable.ic_java);
        }
        if(key.equals("Python")){
            tv.setText(python_questions[flag]);
            String op1=python_opt[flag*4];
            String op2=python_opt[(flag*4)+1];
            String op3=python_opt[(flag*4)+2];
            String op4=python_opt[(flag*4)+3];
            ArrayList<String>arr_ans_rand=new ArrayList<>();
            arr_ans_rand.add(op1);
            arr_ans_rand.add(op2);
            arr_ans_rand.add(op3);
            arr_ans_rand.add(op4);
            Collections.shuffle(arr_ans_rand);
            rb1.setText(arr_ans_rand.get(0));
            rb2.setText(arr_ans_rand.get(1));
            rb3.setText(arr_ans_rand.get(2));
            rb4.setText(arr_ans_rand.get(3));
            python_quiz();
            logo_in_tool_bar.setImageResource(R.drawable.ic_python);
        }
        if(key.equals("PHP")){
            tv.setText(php_questions[flag]);
            rb1.setText(php_questions[flag*4]);
            rb2.setText(php_questions[flag*4 +1]);
            rb3.setText(php_questions[flag*4 +2]);
            rb4.setText(php_questions[flag*4 +3]);
        }
        if(key.equals("C++")){
            tv.setText(python_questions[flag]);
            rb1.setText(python_opt[flag*4]);
            rb2.setText(python_opt[flag*4 +1]);
            rb3.setText(python_opt[flag*4 +2]);
            rb4.setText(python_opt[flag*4 +3]);
        }
        if(key.equals("C#")){
            tv.setText(python_questions[flag]);
            rb1.setText(python_opt[flag*4]);
            rb2.setText(python_opt[flag*4 +1]);
            rb3.setText(python_opt[flag*4 +2]);
            rb4.setText(python_opt[flag*4 +3]);
        }
        if(key.equals("Java Script")){
            tv.setText(python_questions[flag]);
            rb1.setText(python_opt[flag*4]);
            rb2.setText(python_opt[flag*4 +1]);
            rb3.setText(python_opt[flag*4 +2]);
            rb4.setText(python_opt[flag*4 +3]);
        }
        return view;
    } // On Create End


    public void java_quiz(){
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + java_questions.length);
            submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java_quiz();
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1) {
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
            String op1=java_opt[flag*4];
            String op2=java_opt[(flag*4)+1];
            String op3=java_opt[(flag*4)+2];
            String op4=java_opt[(flag*4)+3];
            ArrayList<String>arr_ans_rand=new ArrayList<>();
            arr_ans_rand.add(op1);
            arr_ans_rand.add(op2);
            arr_ans_rand.add(op3);
            arr_ans_rand.add(op4);
            Collections.shuffle(arr_ans_rand);
            rb1.setText(arr_ans_rand.get(0));
            rb2.setText(arr_ans_rand.get(1));
            rb3.setText(arr_ans_rand.get(2));
            rb4.setText(arr_ans_rand.get(3));
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
        qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                python_quiz();
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1) {
            Toast.makeText(getActivity(), "Please Select Answer", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(python_answers[flag])) {
            correct++;
            qustion_number++;
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);

            if (qustion_number==python_questions.length){
                submitbutton.setText("Finish");}
        } else {
            wrong++;
            qustion_number++;
            qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);
            if(qustion_number==python_questions.length){
                submitbutton.setText("Finish");
            }
        }
        flag++;
        if(flag<python_questions.length) {
            tv.setText(python_questions[flag]);
            String op1=python_opt[flag*4];
            String op2=python_opt[(flag*4)+1];
            String op3=python_opt[(flag*4)+2];
            String op4=python_opt[(flag*4)+3];
            ArrayList<String>arr_ans_rand=new ArrayList<>();
            arr_ans_rand.add(op1);
            arr_ans_rand.add(op2);
            arr_ans_rand.add(op3);
            arr_ans_rand.add(op4);
            Collections.shuffle(arr_ans_rand);
            rb1.setText(arr_ans_rand.get(0));
            rb2.setText(arr_ans_rand.get(1));
            rb3.setText(arr_ans_rand.get(2));
            rb4.setText(arr_ans_rand.get(3));
        } else {
            marks=correct;
            String name = "Python";
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



} // Fragment Class End








//    public void quiz(){
////        qustion_number_tv.setText("Q" + qustion_number + " Out of " + java_questions.length);
//        submitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                quiz();
//            }
//        });
//        if(radio_g.getCheckedRadioButtonId()==-1) {
//            Toast.makeText(getActivity(), "Please Select Answer", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        RadioButton answer_selected = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
//        String ansText = answer_selected.getText().toString();
//        if (key.equals("Python")){
//
//
//            qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);
//            if(ansText.equals(python_answers[flag])) {
//                correct++;
//                qustion_number++;
//                qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);
//                if (qustion_number==python_questions.length){
//                    submitbutton.setText("Finish");}
//            } else {
//                wrong++;
//                qustion_number++;
//                qustion_number_tv.setText("Q" + qustion_number + " Out of " + python_questions.length);
//                if(qustion_number==python_questions.length){
//                    submitbutton.setText("Finish");
//                }
//            }
//            flag++;
//            if(flag<python_questions.length) {
//                tv.setText(python_questions[flag]);
//                String op1=python_opt[flag*4];
//                String op2=python_opt[(flag*4)+1];
//                String op3=python_opt[(flag*4)+2];
//                String op4=python_opt[(flag*4)+3];
//                ArrayList<String>arr_ans_rand=new ArrayList<>();
//                arr_ans_rand.add(op1);
//                arr_ans_rand.add(op2);
//                arr_ans_rand.add(op3);
//                arr_ans_rand.add(op4);
//                Collections.shuffle(arr_ans_rand);
//                rb1.setText(arr_ans_rand.get(0));
//                rb2.setText(arr_ans_rand.get(1));
//                rb3.setText(arr_ans_rand.get(2));
//                rb4.setText(arr_ans_rand.get(3));
//            } else {
//                marks=correct;
//                String name = "Python";
//                String correct_val=String.valueOf(correct);
//                String wrong_val=String.valueOf(wrong);
//                String total_quiz_out_of_score=String.valueOf(correct+wrong);
//                long time_until_finish = SystemClock.elapsedRealtime() - chronometer.getBase();
//                int hours = (int) (time_until_finish / 3600000);
//                int minutes = (int) (time_until_finish - hours * 3600000) / 60000;
//                int seconds = (int) (time_until_finish - hours * 3600000 - minutes * 60000) / 1000;
//                String time_m = String.valueOf(minutes);
//                String time_s = String.valueOf(seconds);
//                Fragment someFragment = new ResultFragment();
//                Bundle args = new Bundle();
//                args.putString("name", name);
//                args.putString("correct",correct_val);
//                args.putString("wrong",wrong_val);
//                args.putString("outmark",total_quiz_out_of_score);
//                args.putString("time_m_Finish",time_m);
//                args.putString("time_s_Finish",time_s);
//                someFragment.setArguments(args);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
//                transaction.commit();
//            }
//            radio_g.clearCheck();
//        }// if key equals python
//
//        if (key.equals("PHP")){
//
//            if(ansText.equals(php_answers[flag])) {
//                correct++;
//                qustion_number++;
//                qustion_number_tv.setText("Q" + qustion_number + " Out of " + php_questions.length);
//                if (qustion_number==php_questions.length){
//                    submitbutton.setText("Finish");}
//            } else {
//                wrong++;
//                qustion_number++;
//                qustion_number_tv.setText("Q" + qustion_number + " Out of " + php_questions.length);
//                if(qustion_number==php_questions.length){
//                    submitbutton.setText("Finish");
//                }
//            }
//            flag++;
//            if(flag<python_questions.length) {
//                tv.setText(php_questions[flag]);
//                String op1=php_opt[flag*4];
//                String op2=php_opt[(flag*4)+1];
//                String op3=php_opt[(flag*4)+2];
//                String op4=php_opt[(flag*4)+3];
//                ArrayList<String>arr_ans_rand=new ArrayList<>();
//                arr_ans_rand.add(op1);
//                arr_ans_rand.add(op2);
//                arr_ans_rand.add(op3);
//                arr_ans_rand.add(op4);
//                Collections.shuffle(arr_ans_rand);
//                rb1.setText(arr_ans_rand.get(0));
//                rb2.setText(arr_ans_rand.get(1));
//                rb3.setText(arr_ans_rand.get(2));
//                rb4.setText(arr_ans_rand.get(3));
//            } else {
//                marks=correct;
//                String name = "PHP";
//                String correct_val=String.valueOf(correct);
//                String wrong_val=String.valueOf(wrong);
//                String total_quiz_out_of_score=String.valueOf(correct+wrong);
//                long time_until_finish = SystemClock.elapsedRealtime() - chronometer.getBase();
//                int hours = (int) (time_until_finish / 3600000);
//                int minutes = (int) (time_until_finish - hours * 3600000) / 60000;
//                int seconds = (int) (time_until_finish - hours * 3600000 - minutes * 60000) / 1000;
//                String time_m = String.valueOf(minutes);
//                String time_s = String.valueOf(seconds);
//                Fragment someFragment = new ResultFragment();
//                Bundle args = new Bundle();
//                args.putString("name", name);
//                args.putString("correct",correct_val);
//                args.putString("wrong",wrong_val);
//                args.putString("outmark",total_quiz_out_of_score);
//                args.putString("time_m_Finish",time_m);
//                args.putString("time_s_Finish",time_s);
//                someFragment.setArguments(args);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
//                transaction.commit();
//            }
//            radio_g.clearCheck();
//
//        }// if key equals php
//
//    }//quiz end













//    String correctanswer = python_answers[flag];
//            Toast.makeText(getActivity(), "الاجابة الصحيحة هية->"+correctanswer, Toast.LENGTH_LONG).show();
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