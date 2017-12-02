package sky.user;

import android.content.Intent;

import org.apache.commons.lang3.StringUtils;

import jc.sky.SKYExtraHelper;
import sky.OpenBiz;
import sky.core.SKYBiz;
import sky.core.SKYHelper;
import sky.core.SKYIDisplay;
import sky.user.model.UserModel;

/**
 * @author sky
 * @version 1.0 on 2017-12-02 下午10:09
 * @see CheckBiz
 */
@OpenBiz
public class CheckBiz extends SKYBiz {

	/**
	 * 检查是否登录
	 * 
	 * @return
	 */
	public boolean checkLogin() {
		UserModel userModel = SKYExtraHelper.fileCacheManage().readObjectFile("USER", UserModel.class);
		if (userModel == null || StringUtils.isBlank(userModel.token)) {
			SKYHelper.display(SKYIDisplay.class).start(LoginActivity.class);
			return false;
		}

		return true;
	}
}
