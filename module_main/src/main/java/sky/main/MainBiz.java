package sky.main;

import jc.sky.SKYHelper;
import jc.sky.core.SKYBiz;
import sky.OpenBiz;

import android.os.Bundle;

@OpenBiz
public class MainBiz extends SKYBiz<MainActivity> {

    @Override protected void initBiz(Bundle bundle) {
        super.initBiz(bundle);
    }

    public void showTip(String value) {
        SKYHelper.toast().show("MainBiz:" + value);
    }
}