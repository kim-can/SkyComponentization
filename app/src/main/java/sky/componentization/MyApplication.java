package sky.componentization;

import android.content.Context;
import android.support.multidex.MultiDex;

import sky.common.CommonApplication;

/**
 * @author sky
 * @version 1.0 on 2017-10-26 下午3:10
 * @see MyApplication
 */

public class MyApplication extends CommonApplication {

	@Override public void onCreate() {
		super.onCreate();
	}

	/**
	 * 不打印日志
	 * 
	 * @return
	 */
	@Override public boolean isLogOpen() {
		boolean bool = false;
		switch (BuildConfig.isDebug) {
			case 1:// 线上环境
				bool = super.isLogOpen();
				break;
			case 0:// 测试环境
				bool = false;
				break;
		}
		return bool;
	}

	@Override protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		// dex突破65535的限制
		MultiDex.install(this);
	}

}
