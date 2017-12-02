package sky.common;

import android.app.Application;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Method;

import jc.sky.SKYExtraHelper;
import jc.sky.modules.SKYExtraModulesManage;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sky.common.display.CheckDisplay;
import sky.core.ISky;
import sky.core.SKYHelper;
import sky.core.SKYModulesManage;
import sky.core.SKYPlugins;
import sky.core.plugins.DisplayStartInterceptor;

/**
 * @author sky
 * @version 1.0 on 2017-10-26 上午11:04
 * @see CommonApplication
 */
public class CommonApplication extends Application implements ISky {

	@Override public void onCreate() {
		super.onCreate();
		// sky架构
		SKYExtraHelper.newSky().setSky(this).Inject(this);
	}

	@Override public boolean isLogOpen() {
		return true;
	}

	@Override public Retrofit.Builder httpAdapter(Retrofit.Builder builder) {
		builder.baseUrl("https://api.github.com");

		Gson gson = new GsonBuilder().setLenient().create();
		builder.addConverterFactory(GsonConverterFactory.create(gson));
		return builder;
	}

	@Override public SKYPlugins.Builder pluginInterceptor(SKYPlugins.Builder builder) {
		builder.setDisplayStartInterceptor(new DisplayStartInterceptor() {

			@Override public <T> boolean interceptStart(String s, Class<T> aClass, Method method, int i, String s1, Bundle bundle) {
				if (aClass.equals(CheckDisplay.class)) {
					return SKYHelper.moduleBiz("CheckBiz").method("checkLogin").run();

				}
				return true;
			}
		});
		return builder;
	}

	@Override public SKYModulesManage modulesManage() {
		return new SKYExtraModulesManage();
	}

}
