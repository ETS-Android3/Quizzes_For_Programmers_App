package com.omarstudiolimited.programming_quizizz.ui.types_prog_lang;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Type_Prog_Lang_ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Type_Prog_Lang_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}