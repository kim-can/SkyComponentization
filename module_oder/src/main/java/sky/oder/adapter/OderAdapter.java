package sky.oder.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import jc.sky.view.SKYActivity;
import jc.sky.view.adapter.recycleview.SKYHolder;
import jc.sky.view.adapter.recycleview.SKYRVAdapter;
import sky.oder.R;
import sky.oder.R2;

public class OderAdapter extends SKYRVAdapter<OderAdapter.Model, OderAdapter.ItemHolder> {

	public OderAdapter(SKYActivity SKYActivity) {
		super(SKYActivity);
	}

	@Override public ItemHolder newViewHolder(ViewGroup viewGroup, int type) {
		// 修改布局文件
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_oder, viewGroup, false);
		ItemHolder itemHolder = new ItemHolder(view);
		return itemHolder;
	}

	public class ItemHolder extends SKYHolder<Model> {

		@BindView(R2.id.iv_item) ImageView ivItem;

		public ItemHolder(View itemView) {
			super(itemView);
		}

		@Override public void bindData(Model model, int position) {
			Glide.with(ivItem.getContext()).load(getItem(position).img).into(ivItem);
		}

		@OnClick(R2.id.iv_item) public void onViewClicked() {}

	}

	public static class Model {

		public String img;
	}
}