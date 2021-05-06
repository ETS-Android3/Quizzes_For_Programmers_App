package com.omarstudiolimited.programming_quizizz.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
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
    int arrss_index = 0;
    int question_number = 1;

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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_results, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        ImageView logo_in_tool_bar= (ImageView) ((MainActivity) this.getActivity()).findViewById(R.id.logo);
//        toolbarTextView.setText("Results");

        String name=getArguments().getString("name"); // Means quiz language name
        toolbarTextView.setText(name+" Quiz Results");
        switch (name){
            case "Java":
                logo_in_tool_bar.setImageResource(R.drawable.ic_java);
        }
        String correct_val=getArguments().getString("correct");
        String wrong_val=getArguments().getString("wrong");
        String outmark=getArguments().getString("outmark");
        String timem = getArguments().getString("time_m_Finish");
        String times = getArguments().getString("time_s_Finish");
        tvr=(TextView)view.findViewById(R.id.tvr);
        tvr.setText(
                "Results:"+"\n"+
                        "Your Score in "+name+" Quiz is ("+correct_val+") Out of ("+outmark+")"+
                        "\n"+"Correct answer ("+correct_val+")"+
                        "\n"+"Wrong answer ("+wrong_val+")"+
                        "\n"+"You Finished in: ("+timem+") Minutes and ("+times+") Seconds"
        );

        TextView final_answers=(TextView)view.findViewById(R.id.final_answers);
        if (name.equals("Java")) {
            arrss_index = 0;
            question_number = 1;
            for (int i=0;i<java_questions.length;i++){
            final_answers.setText(final_answers.getText()+"\n"+"\n"+
                    "Q" + question_number + ": " + java_questions[arrss_index] + "\n" + "Answer: " +"\n"+java_answers[arrss_index]

            );
                arrss_index++;
                question_number++;
            }
        }
        return view;
    }
}











//            final_answers.append(java_questions[i]);
//            final_answers.append("\n");
//            final_answers.append(java_answers[i]);

//            int arraySize = java_questions.length;
//            for(int i = 0; i < arraySize; i++) {
//                final_answers.append(java_questions[i]);
//                final_answers.append("\n");
//                final_answers.append(java_answers[i]);
//        }
