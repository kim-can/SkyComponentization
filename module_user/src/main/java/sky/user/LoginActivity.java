package sky.user;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import sky.OpenDisplay;
import sky.core.SKYActivity;
import sky.core.SKYBuilder;
import sky.core.SKYHelper;
import sky.core.SKYIDisplay;

public class LoginActivity extends SKYActivity<LoginBiz> {

	@OpenDisplay public static final void intent() {
		SKYHelper.display(SKYIDisplay.class).intent(LoginActivity.class);
	}

	@BindView(R2.id.btn_login) Button	btnLogin;

	@BindView(R2.id.btn_out) Button		btnOut;

	@BindView(R2.id.btn_close) Button	btnClose;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_login);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {}

	@OnClick(R2.id.btn_login) public void onBtnLoginClicked() {
		biz().login();
	}

	@OnClick(R2.id.btn_out) public void onBtnOutClicked() {
		biz().out();
	}

	@OnClick(R2.id.btn_close) public void onBtnCloseClicked() {
		onKeyBack();
	}
}