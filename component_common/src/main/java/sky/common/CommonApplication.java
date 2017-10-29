package sky.common;

import android.app.Application;
import android.os.Environment;

import com.alibaba.android.arouter.launcher.ARouter;

import java.io.File;

import jc.sky.ISKYBind;
import jc.sky.SKYHelper;
import jc.sky.modules.SKYModulesManage;
import jc.sky.modules.log.L;
import jc.sky.modules.methodProxy.SKYMethods;
import retrofit2.Retrofit;

/**
 * @author sky
 * @version 1.0 on 2017-10-26 上午11:04
 * @see CommonApplication
 */
public class CommonApplication extends Application implements ISKYBind {

	@Override public void onCreate() {
		super.onCreate();
		// sky架构
		SKYHelper.newBind().setSkyBind(this).Inject(this);
		// 文件初始化
		File filesDir;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
			// We can read and write the media
			filesDir = getExternalFilesDir(null);
		} else {
			// Load another directory, probably local memory
			filesDir = getFilesDir();
		}
		if (filesDir != null) {
			SKYHelper.fileCacheManage().configureCustomerCache(filesDir);
		}

		// 路由器
		ARouter.init(this);
	}

	@Override public boolean isLogOpen() {
		L.plant(new L.DebugTree());
		ARouter.openDebug();
		ARouter.openLog();
		return true;
	}

	@Override public Retrofit getRestAdapter(Retrofit.Builder builder) {
		builder.baseUrl("https://www.jincanshen.com");
		return builder.build();
	}

	@Override public SKYMethods getMethodInterceptor(SKYMethods.Builder builder) {
		return builder.build();

	}

	@Override public SKYModulesManage getModulesManage() {
		return new SKYModulesManage();
	}
}
