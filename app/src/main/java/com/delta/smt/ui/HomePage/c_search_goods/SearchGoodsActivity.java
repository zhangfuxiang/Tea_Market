package com.delta.smt.ui.HomePage.c_search_goods;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.find.systemShop.SystemShopActivity;
import com.xiaochendev.lib.HintAnimEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/4/18.
 */

public class SearchGoodsActivity extends BaseActivity {

    @BindView(R.id.hint_edittext)
    HintAnimEditText editText;
    @BindView(R.id.search_rv)
    RecyclerView search_rv;

    @OnClick(R.id.search_clean_tv)
    public void clear() {
        SpUtil.SetStringSF(this, "SearchHistory", "");
        list.clear();
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.back)
    public void back() {
        finish();
    }

    private List<String> list = new ArrayList<>();
    private CommonBaseAdapter<String> adapter;
    private String history;

    @Override
    protected void initView() {

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && !editText.getText().toString().equals("") && event.getAction() == KeyEvent.ACTION_UP) {
                    String history = SpUtil.getStringSF(SearchGoodsActivity.this, "SearchHistory");
                    if (history == null || history.equals("")) {
                        SpUtil.SetStringSF(SearchGoodsActivity.this, "SearchHistory", editText.getText().toString());
                    } else {
                        boolean hasSearch=false;
                        String resout=SpUtil.getStringSF(SearchGoodsActivity.this,"SearchHistory");
                        String[] resouts=resout.split("KNIEF_CCCC");
                        for(String a:resouts){
                            if(a.equals(editText.getText().toString())){
                                hasSearch=true;
                            }
                        }
                        if(!hasSearch) {
                            SpUtil.SetStringSF(SearchGoodsActivity.this, "SearchHistory", editText.getText().toString() + "KNIEF_CCCC" + history);
                            list.clear();
                            String trueHistory = SpUtil.getStringSF(SearchGoodsActivity.this, "SearchHistory");
                            if (trueHistory != null && !trueHistory.equals("")) {
                                Collections.addAll(list, trueHistory.split("KNIEF_CCCC"));
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    IntentUtils.showIntent(SearchGoodsActivity.this,
                            SystemShopActivity.class,
                            new String[]{"tea_classify", "key_word"},
                            new String[]{"商品搜索", editText.getText().toString()});

                    return true;

                }
                return false;
            }
        });
        editText.setHintString(" |搜索商品");
        history = SpUtil.getStringSF(this, "SearchHistory");
        if (history != null && !history.equals("")) {
            Collections.addAll(list, history.split("KNIEF_CCCC"));
        }
        adapter = new CommonBaseAdapter<String>(this, list) {
            @Override
            protected void convert(CommonViewHolder holder, final String item, int position) {

                holder.setText(R.id.name_tv, item);

            }

            @Override
            protected int getItemViewLayoutId(int position, String item) {
                return R.layout.item_search_history;
            }
        };

        search_rv.setLayoutManager(new LinearLayoutManager(this));
        search_rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(View view, String item, int position) {
                editText.setText(item);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search_goods;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        String action = SpUtil.getStringSF(this, "BayCar");
        if (action!=null) {
            if (action.equals("goto")) {
                finish();
            }
        }
    }
}
