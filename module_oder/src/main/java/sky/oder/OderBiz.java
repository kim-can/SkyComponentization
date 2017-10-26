package sky.oder;

import jc.sky.core.SKYBiz;
import sky.Background;
import sky.BackgroundType;
import sky.oder.adapter.OderAdapter;

import android.os.Bundle;

import java.util.ArrayList;

public class OderBiz extends SKYBiz<OderActivity> {

	@Override protected void initBiz(Bundle bundle) {
		super.initBiz(bundle);
	}

	@Background(BackgroundType.WORK) public void load() {
        ArrayList<OderAdapter.Model> arrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
            OderAdapter.Model model = new OderAdapter.Model();
            model.img = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1509016656952&di=7ba1379ee3ea1983fe347b71bd46477e&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fac345982b2b7d0a223890680c1ef76094b369a6e.jpg";
            arrayList.add(model);
        }
        ui().setData(arrayList);
	}
}