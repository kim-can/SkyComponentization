package sky.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

public class MainActivity extends SKYActivity<MainBiz> {

	@BindView(R2.id.btn_oder) Button	btnOder;

	@BindView(R2.id.btn_user) Button	btnUser;

	@BindView(R2.id.btn_login) Button	btnLogin;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_main);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {

	}

	@OnClick({ R2.id.btn_oder, R2.id.btn_user ,R2.id.btn_login}) public void onViewClicked(View id) {
		int i = id.getId();
		if (i == R.id.btn_oder) {
//			SKYHelper.moduleBiz("OderBiz").method("showTip").run("我被执行啦");

//			ARouter.getInstance().build("/oder1/list1").navigation();
		} else if (i == R.id.btn_user) {
			ARouter.getInstance().build("/user/info").withString("name", "jincan").withString("pwd", "jincan12345").withInt("age", 12).navigation();
		} else if (i == R.id.btn_login) {
			ARouter.getInstance().build("/user/login").navigation();

		}
//		ConcurrentHashMap<String,Object> stringObjectConcurrentHashMap = new ConcurrentHashMap<>();
//		stringObjectConcurrentHashMap.put("OderBiz",new String("aaaaa"));
//		stringObjectConcurrentHashMap.put("OderBiz1",new Integer(1));
//
//		L.i("jincan:"+new String("OderBiz").getClass().hashCode());
//		L.i("jincan:"+new String("OderBiz").getClass().hashCode());

	}
}