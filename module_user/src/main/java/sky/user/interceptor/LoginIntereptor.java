package sky.user.interceptor;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import android.content.Context;

import jc.sky.SKYHelper;
import jc.sky.modules.log.L;
import sky.common.SkyConstents;
import sky.user.LoginActivity;

/**
 * @author sky
 * @version 1.0 on 2017-10-27 上午9:53
 * @see LoginIntereptor
 */
//@Interceptor(priority = 1, name = "登录拦截器")
public class LoginIntereptor implements IInterceptor {

	@Override public void process(Postcard postcard, InterceptorCallback interceptorCallback) {
        switch (postcard.getExtra()){
			case SkyConstents.LOGIN_EXTRA:
				LoginActivity.intent();
				interceptorCallback.onInterrupt(new RuntimeException("需要登录"));
				break;
			default:
				interceptorCallback.onContinue(postcard);
				break;
		}
	}

	@Override public void init(Context context) {

	}
}
