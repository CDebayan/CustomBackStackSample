package com.example.dc.custombackstacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends BaseActivity implements View.OnClickListener {

    private Button pageTwoButton;
    private Button pageThreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_first);
        LayoutInflater.from(this).inflate(R.layout.activity_first, mContainer, true);
        mHeader.setText("First Page");
        StackSingleton.getInstance().addCurrentClass(this);
        pageTwoButton = findViewById(R.id.pageTwoButton);
        pageThreeButton = findViewById(R.id.pageThreeButton);

        pageTwoButton.setOnClickListener(this);
        pageThreeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == pageTwoButton) {
            Intent intent = new Intent(FirstPageActivity.this, SecondPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (v == pageThreeButton) {
            Intent intent = new Intent(FirstPageActivity.this, ThirdPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        doBackOperation(this);
    }
}
