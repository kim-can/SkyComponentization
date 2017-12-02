package sky.oder;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import sky.OpenDisplay;
import sky.core.SKYActivity;
import sky.core.SKYBuilder;
import sky.core.SKYHelper;
import sky.core.SKYIDisplay;
import sky.oder.adapter.OderAdapter;

public class OderActivity extends SKYActivity<OderBiz> {

	@OpenDisplay public static final void intent() {
		SKYHelper.display(SKYIDisplay.class).intent(OderActivity.class);
	}

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