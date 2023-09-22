package com.sona.happidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sona.happidapp.base.BaseActivity;

import java.util.Objects;

public class VerificationActivity extends BaseActivity {
    AppCompatTextView getText;
    AppCompatEditText tv1,tv2,tv3,tv4;
    AppCompatButton submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeStatusBarWithWhiteIcon();
        setContentView(R.layout.activity_verification);
        submitBtn = findViewById(R.id.submitBtn);
        getText = findViewById(R.id.getText);
        getText.setText("+91"+getIntent().getStringExtra("num"));

        String otp = getIntent().getStringExtra("otp");
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = Objects.requireNonNull(tv1.getText()).toString();
                String s2 = Objects.requireNonNull(tv2.getText()).toString();
                String s3 = Objects.requireNonNull(tv3.getText()).toString();
                String s4 = Objects.requireNonNull(tv4.getText()).toString();
                String temp = s1+s2+s3+s4;
                if(otp.equals(temp)){
                    Toast.makeText(VerificationActivity.this, "successful", Toast.LENGTH_SHORT).show();
                }
                Log.e("TAG", "onCreate: "+"otp:"+otp+"\n"+"temp:"+temp+"\n"+s1+s2+s3+s4 );
            }
        });



    }
}