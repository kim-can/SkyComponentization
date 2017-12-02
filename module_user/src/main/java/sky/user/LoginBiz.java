package sky.user;

import android.os.Bundle;

import jc.sky.SKYExtraHelper;
import sky.Background;
import sky.BackgroundType;
import sky.core.SKYBiz;
import sky.user.model.UserModel;

public class LoginBiz extends SKYBiz<LoginActivity> {

	@Override protected void initBiz(Bundle bundle) {
		super.initBiz(bundle);
	}

	@Background(BackgroundType.WORK) public void login() {
		UserModel userModel = new UserModel();
		userModel.token = "jincan";
		SKYExtraHelper.fileCacheManage().writeObjectFile("USER", userModel);
		SKYExtraHelper.toast().show("登录成功");
	}

	@Background(BackgroundType.WORK) public void out() {
		SKYExtraHelper.fileCacheManage().deleteFile("USER");
		SKYExtraHelper.toast().show("退出成功");
	}
}