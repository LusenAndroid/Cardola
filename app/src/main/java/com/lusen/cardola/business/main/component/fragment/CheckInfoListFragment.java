package com.lusen.cardola.business.main.component.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lusen.cardola.R;
import com.lusen.cardola.business.actionview.ActionViewFactory;
import com.lusen.cardola.business.base.CardolaBaseFragment;
import com.lusen.cardola.framework.uibase.UiModelActionBarHelper;
import com.lusen.cardola.framework.uibase.ui.actionbar.ActionBarLayout;
import com.lusen.cardola.framework.uibase.ui.actionbar.ActionView;
import com.lusen.cardola.framework.util.ContextUtil;
import com.lusen.cardola.framework.util.ToastUtil;

/**
 * Created by leo on 2017/7/23.
 */

public class CheckInfoListFragment extends CardolaBaseFragment {

    @Override
    protected View onContentViewInit(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflaterView(inflater, R.layout.fragment_checkinfo_list, container);
    }

    @Override
    public String initActionBarTitle() {
        return ContextUtil.getContext().getResources().getString(R.string.actionbar_title_checkinfo_list);
    }

    @Override
    public void onActionViewCreated(UiModelActionBarHelper helper) {
        super.onActionViewCreated(helper);
        ActionView actionViewSearch = ActionViewFactory.buildActionView(getLayoutInflater(), ActionViewFactory.SEARCH);
        helper.addActionViewToContainer(actionViewSearch, ActionBarLayout.ActionContainer.RIGHT, true);
        mActionViewBack.hide(false);
    }

    @Override
    public void onActionViewClick(ActionView actionView) {
        super.onActionViewClick(actionView);
        int id = actionView.getId();
        if (id == ActionViewFactory.SEARCH) {
            search();
        }
    }

    private void search() {
        ToastUtil.toast("搜索");
    }

}
