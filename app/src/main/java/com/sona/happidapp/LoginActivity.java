package com.sona.happidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sona.happidapp.base.BaseActivity;

import java.util.Objects;

public class LoginActivity extends BaseActivity {

    AppCompatEditText numEt;
    AppCompatButton otpBtn;
    AppCompatTextView txt;
    CardView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        removeStatusBarWithWhiteIcon();
        setContentView(R.layout.activity_login);
        numEt = findViewById(R.id.numEt);
        otpBtn = findViewById(R.id.otpBtn);
        txt = findViewById(R.id.txt);
        card = findViewById(R.id.card);
        card.setVisibility(View.GONE);
        otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numEt!=null && Objects.requireNonNull(Objects.requireNonNull(numEt).getText()).length() == 10){
                    String str = Objects.requireNonNull(numEt.getText()).toString();
                    char ch[] = str.toCharArray();

                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < str.length(); i++) {
                        if (i == 0 || i == 1 || i == str.length() - 1 || i == str.length() - 2) {
                            sb.append(str.charAt(i));
                        }
                    }
                    txt.setText(sb);
                }
                card.setVisibility(View.VISIBLE);
            }
        });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = Objects.requireNonNull(numEt.getText()).toString();
                String  s = txt.getText().toString();
                Intent intent = new Intent(LoginActivity.this,VerificationActivity.class);
                intent.putExtra("otp",s);
                intent.putExtra("num",num);
                startActivity(intent);
            }
        });
    }
}