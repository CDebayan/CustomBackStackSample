package com.example.dc.custombackstacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class SecondPageActivity extends BaseActivity implements View.OnClickListener {

    private Button pageOneButton;
    private Button pageThreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_second_page);
        LayoutInflater.from(this).inflate(R.layout.activity_second_page, mContainer, true);
        mHeader.setText("Second Page");
        StackSingleton.getInstance().addCurrentClass(this);
        pageOneButton = findViewById(R.id.pageOneButton);
        pageThreeButton = findViewById(R.id.pageThreeButton);

        pageOneButton.setOnClickListener(this);
        pageThreeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == pageOneButton) {
            Intent intent = new Intent(SecondPageActivity.this, FirstPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (v == pageThreeButton) {
            Intent intent = new Intent(SecondPageActivity.this, ThirdPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        doBackOperation(this);
    }
}
