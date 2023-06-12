# LoginPasswordUI

想要实现下图界面：

- 有两种登陆方式
  - 使用密码登陆，可点击忘记密码进入重设密码界面
  - 使用验证码登陆，TextView以及Button中文字有改动

![截屏2023-06-12 10.00.32](/Users/liuyu/Library/Application Support/typora-user-images/截屏2023-06-12 10.00.32.png)

- 忘记密码情况
  - 跳入单独的找回密码页面
  - 输入 & 确认新密码
  - 自动校验 密码合法性

<img src="/Users/liuyu/Library/Application Support/typora-user-images/截屏2023-06-12 10.04.59.png" zoom="60%" align="left"></img>



- 点击验证码登陆时，隐藏checkbox记住密码框

```java
cb_password = findViewById(R.id.cb_password);

// 设置不可见
cb_password.setVisibility(View.GONE);
  
// 设置可见
cd_password.setVisibility(View.VISIBLE);
```

