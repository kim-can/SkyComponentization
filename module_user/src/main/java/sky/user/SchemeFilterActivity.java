package sky.user;

import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

/**
 * @author sky
 * @version 1.0 on 2017-10-29 下午3:46
 * @see SchemeFilterActivity
 */
public class SchemeFilterActivity extends SKYActivity {

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {

		// 直接通过ARouter处理外部Uri
		Uri uri = getIntent().getData();
		ARouter.getInstance().build(uri).navigation(this, new NavCallback() {

			@Override public void onArrival(Postcard postcard) {
				finish();
			}
		});
	}
}
