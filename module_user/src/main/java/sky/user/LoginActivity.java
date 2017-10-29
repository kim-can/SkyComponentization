package sky.user;

import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jc.sky.SKYHelper;
import jc.sky.display.SKYIDisplay;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;
import jc.sky.view.adapter.recycleview.SKYHolder;
import sky.common.SkyConstents;

@Route(path = "/user/login")
public class LoginActivity extends SKYActivity<LoginBiz> {

	public static final void intent(){
		SKYHelper.display(SKYIDisplay.class).intent(LoginActivity.class);
	}

	@BindView(R2.id.btn_login) Button btnLogin;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_login);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {}

	@OnClick(R2.id.btn_login) public void onViewClicked() {
        finish();
    }
}