package sky.user;

import android.os.Bundle;

import sky.Background;
import sky.BackgroundType;
import sky.core.SKYBiz;

public class UserBiz extends SKYBiz<UserActivity> {

	@Override protected void initBiz(Bundle bundle) {
		super.initBiz(bundle);
	}

	@Background(BackgroundType.WORK) public void loadUserInfo() {
		String name = "sky";
		String pwd = "sky";
		String age = "30";
		ui().setInfo(name, pwd, age);
	}

}