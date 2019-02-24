package com.example.dc.custombackstacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends BaseActivity implements View.OnClickListener {

    private Button pageThreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fourth);
        LayoutInflater.from(this).inflate(R.layout.activity_fourth, mContainer, true);
        mHeader.setText("Fourth Page");

        pageThreeButton = findViewById(R.id.pageThreeButton);
        pageThreeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == pageThreeButton){
            Intent intent = new Intent(this, ThirdPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        doBackOperation(this);
    }
}
