package com.example.loginpasswordui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.transition.Hold;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg_login;
    TextView tv_passOrSMS;
    EditText et_pNumber;
    EditText et_passOrSMS;
    Button btn_forgetPass;
    Button btn_test;
    CheckBox cb_rememberPass;
    Button btn_login;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_login = findViewById(R.id.rg_login);
        tv_passOrSMS = findViewById(R.id.tv_passOrSMS);
        et_pNumber = findViewById(R.id.et_pNumber);
        et_passOrSMS = findViewById(R.id.et_passOrSMS);
        btn_forgetPass = findViewById(R.id.btn_forgetPass);
        btn_test = findViewById(R.id.btn_test);
        cb_rememberPass = findViewById(R.id.cb_rememberPass);
        btn_login = findViewById(R.id.btn_login);

        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);

        btn_test.setBackgroundResource(R.drawable.shape_oval);

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

        btn_login.setOnClickListener(this);

        reload();

    }

    private void reload() {
        String pNumber = preferences.getString("pNumber",null);
        if (pNumber != null){
            et_pNumber.setText(pNumber);
        }
        String password = preferences.getString("password",null);
        if (password != null){
            et_passOrSMS.setText(password);
        }
    }

    @Override
    public void onClick(View v) {
        if (cb_rememberPass.isChecked()){
            Log.d("cb_rememberPass", "isChecked");

            String pNumber = et_pNumber.getText().toString();
            String password = et_passOrSMS.getText().toString();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("pNumber",pNumber);
            editor.putString("password",password);
            editor.commit();
        }
    }
}