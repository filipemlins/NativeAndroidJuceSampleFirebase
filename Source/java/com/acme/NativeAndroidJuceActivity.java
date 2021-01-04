package com.acme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.acme.NativeAndroidJuceSample.R;

public class NativeAndroidJuceActivity extends Activity
{
    //==============================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        // call the native C++ class contsructor
        constructNativeClass();

    }

    public void login(View view) {
        Intent intent = new Intent(this, activity2.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy()
    {
        // call the native C++ class destructor
        destroyNativeClass();
        super.onDestroy();
    }

    // called by NativeAndroidJuceActivity.cpp
    public void addToLog(String message)
    {
        //EditText editText = (EditText) findViewById(R.id.juceOutput);

        //editText.setText(message + "\n" + editText.getText());

        //Intent intent = new Intent(this, activity2.class);
        //startActivity(intent);

    }

    // called by mainlayout.xml and implemented in NativeAndroidJuceActivity.cpp

    public void addJuceComponentButtonClicked(View sender)
    {
        addRemoveJuceComponent(findViewById(R.id.juceStage));
    }

    //==============================================================================
    private native void constructNativeClass();
    private native void destroyNativeClass();
    private native void addRemoveJuceComponent(View container);

    private long cppCounterpartInstance;
};
