package com.example.hpf.pomelo.mvp.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.hpf.pomelo.R;
import com.example.hpf.pomelo.mvp.model.entity.MyItem;

import java.util.List;

public class OneAdapter extends BaseQuickAdapter<MyItem,BaseViewHolder> {
    public OneAdapter() {
        super(R.layout.item_one_list);
    }

    public OneAdapter(int layoutResId, @Nullable List<MyItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyItem item) {
                helper.setText(R.id.tv_name,item.getName());
                helper.setText(R.id.tv_dec,item.getDescription());
    }
}
