package sky.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;

public class MainActivity extends SKYActivity<MainBiz> {

	@BindView(R2.id.btn_oder) Button	btnOder;

	@BindView(R2.id.btn_user) Button	btnUser;

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_main);
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {

	}


	@OnClick({ R2.id.btn_oder, R2.id.btn_user }) public void onViewClicked(View view) {
		   switch (view.getId()) {
            case R2.id.btn_oder:
                break;
            case R2.id.btn_user:
                break;
        }
    }
}