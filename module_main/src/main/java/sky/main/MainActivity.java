package sky.main;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import sky.core.SKYActivity;
import sky.core.SKYBuilder;
import sky.core.SKYHelper;

public class MainActivity extends SKYActivity<MainBiz> {

	@BindView(R2.id.btn_oder) Button	btnOder;

	@BindView(R2.id.btn_user) Button	btnUser;

	@BindView(R2.id.btn_login) Button	btnLogin;

	@Override protected sky.core.SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.main_activity_main);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {}

	@OnClick(R2.id.btn_oder) public void onBtnOderClicked() {
		SKYHelper.moduleDisplay("OderActivity").method("intent").run();
	}

	@OnClick(R2.id.btn_user) public void onBtnUserClicked() {
		SKYHelper.moduleDisplay("UserActivity").method("intent").run("sky","jc123",20);

	}

	@OnClick(R2.id.btn_login) public void onBtnLoginClicked() {
		SKYHelper.moduleDisplay("LoginActivity").method("intent").run();
	}
}