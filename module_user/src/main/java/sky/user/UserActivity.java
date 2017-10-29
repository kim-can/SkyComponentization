package sky.user;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;
import jc.sky.view.model.SKYConstants;
import sky.common.SkyConstents;

@Route(path = "/user/info", extras = SkyConstents.LOGIN_EXTRA)
public class UserActivity extends SKYActivity<UserBiz> {

	@BindView(R2.id.tv_name) TextView		tvName;

	@BindView(R2.id.tv_password) TextView	tvPassword;

	@BindView(R2.id.tv_age) TextView		tvAge;

	@BindView(R2.id.btn_login) Button		btnLogin;

	@Autowired(name = "name") public String	userName;

	@Autowired(name = "pwd") public String	password;

	@Autowired(name = "age") public int		age;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_user);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {
		ARouter.getInstance().inject(this);

		tvName.setText("用户名:" + userName);
		tvPassword.setText("密码:" + password);
		tvAge.setText("年龄:" + age);
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