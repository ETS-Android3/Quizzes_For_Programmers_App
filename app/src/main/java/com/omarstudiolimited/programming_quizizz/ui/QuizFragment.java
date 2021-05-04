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
    TextView tv;
    Button submitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
            "كيف كان شعورك خلال الاسبوعين الماضيين بما في ذلك اليوم؟",
            "كيف تشعر حيال المستقبل؟",
            "هل تشعر بالفشل؟",
            "إلى أي مدى تستمتع بالاشياء؟",
            "هل لديك شعور بالذنب؟",
            "هل تشعر بأنك معاقـَب؟",
            "هل تفكر بالانتحار؟",
    };
    String answers[] = {
            "لا اشعر بالحزن.",
            "لا اشعر بالإحباط خاصة حيال المستقبل.",
            "لا اشعر بالفشل.",
            "انا استمتع بالاشياء الان مثلما استمعت بها في الماضي.",
            "لا اشعر بالذنب بشكل خاص.",
            "لا اشعر بأنني معاقـَب.",
            "لا أفكر ابدًا بقتل نفسي.",
    };
    String opt[] = {
            "لا اشعر بالحزن.","انا حزين.","اشعر بالحزن طوال الوقت ولا يمكنني التخلص منه","اشعر بالحزن الشديد او التعاسة حتى انه لا يمكنني تحمل ذلك.",
            "لا اشعر بالإحباط خاصة حيال المستقبل.","اشعر بالإحباط من المستقبل.","اشعر انه ليس لدي ما يمكن توقعه.","اشعر باليأس حيال المستقبل وان الأمور لا يمكن ان تتحسن.",
            "لا اشعر بالفشل.","اشعر بأنني فشلت أكثر من الشخص العادي","عندما القي نظرة إلى الوراء على حياتي, فجُلّ ما اراه هو العديد من الإخفاقات.","أشعر بأنني فشلت فشلا ذريعا كانسان.",
            "انا استمتع بالاشياء الان مثلما استمعت بها في الماضي.","انا لا استمتع بالاشياء الان مثلما استمعت بها في الماضي.","لا اشعر بالاستمتاع الحقيقي في أي شيء.","لا اشعر بالرضا من أي شيء، أو بأن كل شيء قد أصبح مملا.",
            "لا اشعر بالذنب بشكل خاص.","اشعر بالذنب احيانًا.","اشعر بالذنب في معظم الوقت.","اشعر بالذنب طوال الوقت.",
            "لا اشعر بأنني معاقـَب.","اشعر بأنني يمكن أن أعاقـَب","اتوقع بأنني سوف أعاقـَب.","اشعر بأنني معاقـَب.",
            "لا أفكر ابدًا بقتل نفسي.","تساورني الافكار بقتل نفسي ولكنني لن انفذها.","كنت اود قتل نفسي.","سأقتل نفسي إذا اتيحت لي الفرصة.",
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    String key,key2;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        toolbarTextView.setText("Quiz");
        key = getArguments().getString("key");
        //Intent intent = getIntent();
        submitbutton=(Button)view.findViewById(R.id.button3);
        tv=(TextView) view.findViewById(R.id.tvque);
        radio_g=(RadioGroup)view.findViewById(R.id.answersgrp);
        rb1=(RadioButton)view.findViewById(R.id.radioButton);
        rb2=(RadioButton)view.findViewById(R.id.radioButton2);
        rb3=(RadioButton)view.findViewById(R.id.radioButton3);
        rb4=(RadioButton)view.findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);


        if (key.equals("Java")){
            java_quiz();
        }
        if (key.equals("Python")){
            tv.setText("kfgerohtgiorehtiherpiothpoierhtpoierhtpoerhpotih");
            Toast.makeText(getActivity(), "  gfleglfdhgol ", Toast.LENGTH_SHORT).show();
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
        return view;
    }


    public void java_quiz(){
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java_quiz();
            }
        });
        if(radio_g.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(getActivity(), "الرجاء اختيار احد الاجابات", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton uans = (RadioButton) view.findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = uans.getText().toString();
        if(ansText.equals(answers[flag])) {
            correct++;
            Toast.makeText(getActivity(), "اجابة صحيحة", Toast.LENGTH_SHORT).show();
        }
        else {
            wrong++;
            String correctanswer = answers[flag];
            Toast.makeText(getActivity(), "الاجابة الصحيحة هية->"+correctanswer, Toast.LENGTH_LONG).show();
        }
        flag++;
        if(flag<questions.length)
        {
            tv.setText(questions[flag]);
            rb1.setText(opt[flag*4]);
            rb2.setText(opt[flag*4 +1]);
            rb3.setText(opt[flag*4 +2]);
            rb4.setText(opt[flag*4 +3]);
        }
        else
        {
            marks=correct;
            Toast.makeText(getActivity(), "صححح", Toast.LENGTH_SHORT).show();
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
            transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
            transaction.commit();
//                    Intent in = new Intent(getApplicationContext(), result.class);
//                    startActivity(in);
        }
        radio_g.clearCheck();
    }

}