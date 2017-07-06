package com.delta.smt.ui.find.collectionInfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.UploadCollectionInfoResult;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.collectionInfo.di.DaggerUploadCollectionInfoComponent;
import com.delta.smt.ui.find.collectionInfo.di.UploadCollectionInfoModule;
import com.delta.smt.ui.find.collectionInfo.mvp.UploadCollectionInfoContract;
import com.delta.smt.ui.find.collectionInfo.mvp.UploadCollectionInfoPresenter;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

public class UploadCollectionInfoActivity extends BaseActivity<UploadCollectionInfoPresenter> implements UploadCollectionInfoContract.View, CommonBaseAdapter.OnItemClickListener<String> {


    private static final int REQUEST_CODE = 0;
    private static final int REQUEST_SHOW_IMAGE = 10;
    private static final int REQUEST_SHOW_IMAGE_RESULT = 11;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    @BindView(R.id.rvUploadCollection)
    RecyclerView rvUploadCollection;
    ImgSelConfig config;
    private List<String> dataSource = new ArrayList<>();
    private CommonBaseAdapter<String> mAdapter;
    private ImageLoader loader = new ImageLoader() {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            // TODO 在这边可以自定义图片加载库来加载ImageView，例如Glide、Picasso、ImageLoader等
            Glide.with(context).load(path).into(imageView);
        }
    };

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerUploadCollectionInfoComponent.builder()
                .appComponent(appComponent)
                .uploadCollectionInfoModule(new UploadCollectionInfoModule(this)) //请将UploadCollectionInfoModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);
        toolbar.setToolbarTitle("藏品信息");
        toolbar.setToolbarRightButton("提交");

        dataSource.add("");

        // 自由配置选项
        config = new ImgSelConfig.Builder(UploadCollectionInfoActivity.this, loader)
                // 是否多选, 默认true
                .multiSelect(true)
                // 是否记住上次选中记录, 仅当multiSelect为true的时候配置，默认为true
                .rememberSelected(false)
                // “确定”按钮背景色
                .btnBgColor(Color.WHITE)
                // “确定”按钮文字颜色
                .btnTextColor(Color.rgb(51, 51, 51))
                // 使用沉浸式状态栏
                .statusBarColor(Color.WHITE)
                // 返回图标ResId
                .backResId(android.support.v7.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha)
                // 标题
                .title("图片")
                // 标题文字颜色
                .titleColor(Color.rgb(51, 51, 51))
                // TitleBar背景色
                .titleBgColor(Color.WHITE)
                // 裁剪大小。needCrop为true的时候配置
                .cropSize(1, 1, 200, 200)
                .needCrop(true)
                // 第一个是否显示相机，默认true
                .needCamera(true)
                // 最大选择图片数量，默认9
                .maxNum(9)
                .build();

        mAdapter = new CommonBaseAdapter<String>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, String item, final int position) {

                ImageView iv = holder.getView(R.id.iv_show_images);
                Glide.with(UploadCollectionInfoActivity.this).load(item).placeholder(R.mipmap.iv_add_image).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, String item) {
                return R.layout.item_upload_collection_info;

            }
        };
        mAdapter.setOnItemClickListener(this);
        rvUploadCollection.setLayoutManager(new GridLayoutManager(this, 5));
        rvUploadCollection.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_upload_collection_info;
    }

    @Override
    public void onSendSuccess(UploadCollectionInfoResult uploadCollectionInfoResult) {

    }

    @Override
    public void onSendFailed(UploadCollectionInfoResult uploadCollectionInfoResult) {

    }

    @Override
    public void onSendFailed(Throwable throwable) {

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
            case R.id.toolbar_right_button:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 图片选择结果回调
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
            dataSource.remove(dataSource.size() - 1);
            dataSource.addAll(pathList);
            dataSource.add("");
            mAdapter.notifyDataSetChanged();
        } else if (resultCode == REQUEST_SHOW_IMAGE_RESULT) {
            List<String> pathList2 = data.getStringArrayListExtra("image_paths_result");
            dataSource.clear();
            dataSource.addAll(pathList2);
            dataSource.add("");
            mAdapter.notifyDataSetChanged();
            rvUploadCollection.setAdapter(mAdapter);
        }
    }

    @Override
    public void onItemClick(View view, String item, int position) {
        if (position == dataSource.size() - 1) {
            // 跳转到图片选择器
            ImgSelActivity.startActivity(this, config, REQUEST_CODE);
        } else {
            List<String> dataSourceShow = dataSource;
            dataSourceShow.remove(dataSourceShow.size() - 1);
            Intent intent = new Intent(UploadCollectionInfoActivity.this, ShowImagePage.class);
            intent.putStringArrayListExtra("image_paths", (ArrayList<String>) dataSourceShow);
            intent.putExtra("image_position", position);
            startActivityForResult(intent, REQUEST_SHOW_IMAGE);
        }
    }
}
