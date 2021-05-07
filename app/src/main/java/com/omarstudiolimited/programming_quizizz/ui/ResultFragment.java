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


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_results, container, false);
        TextView toolbarTextView  = (TextView) ((MainActivity) this.getActivity()).findViewById(R.id.tbtv);
        ImageView logo_in_tool_bar= (ImageView) ((MainActivity) this.getActivity()).findViewById(R.id.logo);
        TextView final_answers=(TextView)view.findViewById(R.id.final_answers);
        String name=getArguments().getString("name"); // Means quiz language name
        toolbarTextView.setText(name+" Quiz Results");

//        if (name.equals("Java")){
//
//                logo_in_tool_bar.setImageResource(R.drawable.ic_java);
//        }
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


        if (name.equals("Java")) {
            logo_in_tool_bar.setImageResource(R.drawable.ic_java);
            arrss_index = 0;
            question_number = 1;
            for (int i=0;i<java_questions.length;i++){
            final_answers.setText(final_answers.getText()+"\n"+"\n"+
                    "Q" + question_number + ": " + java_questions[arrss_index] + "\n" + "Answer: " +"\n"+java_answers[arrss_index]);
                arrss_index++;
                question_number++;
            }
        }

        if (name.equals("Python")) {
            logo_in_tool_bar.setImageResource(R.drawable.ic_python);
            arrss_index = 0;
            question_number = 1;
            for (int i=0;i<python_questions.length;i++){
                final_answers.setText(final_answers.getText()+"\n"+"\n"+
                        "Q" + question_number + ": " + python_questions[arrss_index] + "\n" + "Answer: " +"\n"+python_answers[arrss_index]);
                arrss_index++;
                question_number++;
            }
        }

        return view;
    } // on create end
} // calss end











//            final_answers.append(java_questions[i]);
//            final_answers.append("\n");
//            final_answers.append(java_answers[i]);

//            int arraySize = java_questions.length;
//            for(int i = 0; i < arraySize; i++) {
//                final_answers.append(java_questions[i]);
//                final_answers.append("\n");
//                final_answers.append(java_answers[i]);
//        }
