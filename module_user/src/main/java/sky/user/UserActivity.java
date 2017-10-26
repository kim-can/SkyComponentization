package sky.user;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

public class UserActivity extends SKYActivity<UserBiz> {

	@BindView(R2.id.tv_name) TextView		tvName;

	@BindView(R2.id.tv_password) TextView	tvPassword;

	@BindView(R2.id.tv_age) TextView			tvAge;

	@BindView(R2.id.btn_login) Button		btnLogin;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_user);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {

	}

	@OnClick(R2.id.btn_login) public void onViewClicked() {
        biz().loadUserInfo();
    }

    public void setInfo(String name, String pwd, String age) {
        tvName.setText("用户名:" + name);
        tvPassword.setText("密码:" + pwd);
        tvAge.setText("年龄:" + age);

        btnLogin.setText("登录完成");
    }
}