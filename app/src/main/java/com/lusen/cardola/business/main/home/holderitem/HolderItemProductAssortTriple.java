package com.lusen.cardola.business.main.home.holderitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.lusen.cardola.R;
import com.lusen.cardola.business.main.home.data.ProductAssortData;
import com.lusen.cardola.business.main.home.data.ProductAssortTripleData;
import com.lusen.cardola.framework.adapter.HolderViewItem;
import com.lusen.cardola.framework.adapter.IAdapterData;
import com.lusen.cardola.framework.uikit.RemoteImageView;
import com.lusen.cardola.framework.uikit.RemoteTextView;
import com.lusen.cardola.framework.util.UiUtil;

import java.util.List;

/**
 * Created by leo on 2017/7/23.
 */

public class HolderItemProductAssortTriple extends HolderViewItem {

    private static final float COVER_RATIO = 1 / 1f;

    private View mItem0;
    private RemoteImageView mCover0;
    private RemoteTextView mName0;

    private View mItem1;
    private RemoteImageView mCover1;
    private RemoteTextView mName1;

    private View mItem2;
    private RemoteImageView mCover2;
    private RemoteTextView mName2;

    public HolderItemProductAssortTriple(@NonNull Context context) {
        super(context);
    }

    @Override
    public void bindView(View rootView) {
        mItem0 = UiUtil.findViewById(rootView, R.id.layout_item_0, View.class);
        mCover0 = UiUtil.findViewById(rootView, R.id.cover_0, RemoteImageView.class);
        mName0 = UiUtil.findViewById(rootView, R.id.name_0, RemoteTextView.class);
        mItem1 = UiUtil.findViewById(rootView, R.id.layout_item_1, View.class);
        mCover1 = UiUtil.findViewById(rootView, R.id.cover_1, RemoteImageView.class);
        mName1 = UiUtil.findViewById(rootView, R.id.name_1, RemoteTextView.class);
        mItem2 = UiUtil.findViewById(rootView, R.id.layout_item_2, View.class);
        mCover2 = UiUtil.findViewById(rootView, R.id.cover_2, RemoteImageView.class);
        mName2 = UiUtil.findViewById(rootView, R.id.name_2, RemoteTextView.class);
        rootView.post(new Runnable() {
            @Override
            public void run() {
                int width = mCover0.getMeasuredWidth();
                int height = (int) (width / COVER_RATIO);
                updateCoverHeight(mCover0, height);
                updateCoverHeight(mCover1, height);
                updateCoverHeight(mCover2, height);
            }
        });
    }

    @Override
    public void bindData(IAdapterData data, int position) {
        if (data instanceof ProductAssortTripleData) {
            List<ProductAssortData> datas = ((ProductAssortTripleData) data).mDatas;
            if (null != datas && datas.size() >= 3) {
                ProductAssortData data0 = datas.get(0);
                ProductAssortData data1 = datas.get(1);
                ProductAssortData data2 = datas.get(1);
                mCover0.load(data0.mCover);
                mName0.setText(data0.mName);
                mCover1.load(data1.mCover);
                mName1.setText(data1.mName);
                mCover2.load(data2.mCover);
                mName2.setText(data2.mName);
                UiUtil.bindClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = v.getId();
                        if (id == mItem0.getId()) {

                        } else if (id == mItem1.getId()) {

                        } else if (id == mItem2.getId()) {

                        }
                    }
                }, mItem0, mItem1, mItem2);
            }
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.holder_item_product_assort_triple;
    }

    private void updateCoverHeight(RemoteImageView view, int height) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
    }

}
