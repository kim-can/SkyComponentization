package sky.componentization;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;

import java.io.File;

import jc.sky.SKYHelper;
import jc.sky.modules.log.L;
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
	 * @return
	 */
	@Override public boolean isLogOpen() {
		return false;
	}

	@Override protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		// dex突破65535的限制
		MultiDex.install(this);
	}

}
