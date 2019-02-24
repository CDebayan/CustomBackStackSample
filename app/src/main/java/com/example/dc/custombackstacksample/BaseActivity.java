package com.example.dc.custombackstacksample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    protected TextView mHeader;
    protected FrameLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mHeader = findViewById(R.id.baseHeader);
        mContainer = findViewById(R.id.baseContainer);
    }

    public void doBackOperation(Activity activity) {
        if (StackSingleton.getInstance().getTopClass() == activity.getClass()) {
            StackSingleton.getInstance().removeTopClass();
            if (StackSingleton.getInstance().isStackEmpty()) {
                super.onBackPressed();
            } else {
                Intent intent = new Intent(activity, StackSingleton.getInstance().getTopClass());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(activity, StackSingleton.getInstance().getTopClass());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
