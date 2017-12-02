package sky.user;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import sky.OpenDisplay;
import sky.common.display.CheckDisplay;
import sky.core.SKYActivity;
import sky.core.SKYBuilder;
import sky.core.SKYHelper;

public class UserActivity extends SKYActivity<UserBiz> {

	@OpenDisplay public static final void intent(String name, String pwd, int age) {
		Bundle bundle = new Bundle();
		bundle.putString("name", name);
		bundle.putString("pwd", pwd);
		bundle.putInt("age", age);
		SKYHelper.display(CheckDisplay.class).intent(UserActivity.class, bundle);
	}

	@BindView(R2.id.tv_name) TextView		tvName;

	@BindView(R2.id.tv_password) TextView	tvPassword;

	@BindView(R2.id.tv_age) TextView		tvAge;

	@BindView(R2.id.btn_login) Button		btnLogin;

	@Override protected sky.core.SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_user);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {

		if (savedInstanceState == null) {
			return;
		}
		tvName.setText("用户名:" + savedInstanceState.getString("name"));
		tvPassword.setText("密码:" + savedInstanceState.getString("pwd"));
		tvAge.setText("年龄:" + savedInstanceState.getInt("age"));
	}

	@OnClick(R2.id.btn_login) public void onViewClicked() {
		// biz().loadUserInfo();
		SKYHelper.moduleBiz("MainBiz").method("showTip").run(tvName.getText().toString());
	}

	public void setInfo(String name, String pwd, String age) {
		tvName.setText("用户名:" + name);
		tvPassword.setText("密码:" + pwd);
		tvAge.setText("年龄:" + age);

		btnLogin.setText("登录完成");
	}
}