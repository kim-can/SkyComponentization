package sky.oder;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import jc.sky.view.SKYActivity;
import jc.sky.view.SKYBuilder;
import sky.oder.adapter.OderAdapter;

public class OderActivity extends SKYActivity<OderBiz> {

	@Override protected SKYBuilder build(SKYBuilder initialSKYBuilder) {
		initialSKYBuilder.layoutId(R.layout.activity_oder);
		initialSKYBuilder.recyclerviewId(R.id.rv_oder);
		initialSKYBuilder.recyclerviewLinearLayoutManager(LinearLayoutManager.VERTICAL, null, null);
		initialSKYBuilder.recyclerviewAdapter(new OderAdapter(this));
		return initialSKYBuilder;
	}

	@Override protected void initData(Bundle savedInstanceState) {
		biz().load();
	}

	public void setData(ArrayList<OderAdapter.Model> data) {
		adapter().setItems(data);
	}
}