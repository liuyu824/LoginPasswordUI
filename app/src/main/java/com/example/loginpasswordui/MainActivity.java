package com.example.loginpasswordui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.transition.Hold;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_login;
    TextView tv_passOrSMS;
    EditText et_passOrSMS;
    Button btn_forgetPass;
    CheckBox cb_rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_login = findViewById(R.id.rg_login);
        tv_passOrSMS = findViewById(R.id.tv_passOrSMS);
        et_passOrSMS = findViewById(R.id.et_passOrSMS);
        btn_forgetPass = findViewById(R.id.btn_forgetPass);
        cb_rememberPass = findViewById(R.id.cb_rememberPass);

        rg_login.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // 系统能否获取到RadioGroup的点击事件改变
                Log.d("RadioGroup焦点改变", String.valueOf(checkedId));

                if (checkedId == R.id.rb_password){

                    // 系统能否获取到RadioGroup密码登陆被点击
                    Log.d("rb_password被点击", "onCheckedChanged: ");
                    tv_passOrSMS.setText("登陆密码：");
                    et_passOrSMS.setHint("请输入登陆密码");
                    btn_forgetPass.setText("忘记密码");

                    // 隐藏 checkBox框 以及 记住密码文字
                    cb_rememberPass.setVisibility(View.VISIBLE);

                } else {

                    // 系统能否获取到RadioGroup验证码登陆被点击
                    Log.d("rb_vCode被点击", "onCheckedChanged: ");
                    tv_passOrSMS.setText("验证码：");
                    et_passOrSMS.setHint("请输入验证码");
                    btn_forgetPass.setText("获取验证码");

                    // 隐藏 checkBox框 以及 记住密码文字
                    cb_rememberPass.setVisibility(View.GONE);
                }
            }
        });
    }
}