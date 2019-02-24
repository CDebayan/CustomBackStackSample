package com.example.dc.custombackstacksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class ThirdPageActivity extends BaseActivity implements View.OnClickListener {

    private Button pageOneButton;
    private Button pageTwoButton;
    private Button pageFourButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_third_page);
        LayoutInflater.from(this).inflate(R.layout.activity_third_page, mContainer, true);
        mHeader.setText("Third Page");
        StackSingleton.getInstance().addCurrentClass(this);
        pageOneButton = findViewById(R.id.pageOneButton);
        pageTwoButton = findViewById(R.id.pageTwoButton);
        pageFourButton = findViewById(R.id.pageFourButton);

        pageOneButton.setOnClickListener(this);
        pageTwoButton.setOnClickListener(this);
        pageFourButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == pageOneButton) {
            Intent intent = new Intent(ThirdPageActivity.this, FirstPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (v == pageTwoButton) {
            Intent intent = new Intent(ThirdPageActivity.this, SecondPageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else if (v == pageFourButton) {
            Intent intent = new Intent(ThirdPageActivity.this, FourthActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        doBackOperation(this);
    }

}
