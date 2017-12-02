package sky.main;

import android.os.Bundle;

import sky.Background;
import sky.BackgroundType;
import sky.OpenBiz;
import sky.core.SKYBiz;
import sky.core.SKYHelper;

@OpenBiz
public class MainBiz extends SKYBiz<MainActivity> {

	@Override protected void initBiz(Bundle bundle) {
		super.initBiz(bundle);
	}

	@Background(BackgroundType.HTTP) public void showTip(String value) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		SKYHelper.toast().show("MainBiz:" + value);
	}
}