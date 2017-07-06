package com.delta.smt.common;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import com.delta.commonlibs.animation.AnimationType;
import com.delta.commonlibs.utils.AnimationUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public abstract class CommonBaseAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {
    private static final String TAG = "CommonBaseAdapter";
    /**
     * Base config
     */
    public List<T> mData;
    private Context mContext;
    private LayoutInflater mInflater;
    /**
     * Listener
     */
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private OnRecyclerViewItemChildClickListener mChildClickListener;
    private OnRecyclerViewItemChildLongClickListener mChildLongClickListener;
    /**
     * View type
     */
    private Map<Integer, Integer> layoutIdMap, viewTypeMap;
    private int mCurrentViewTypeValue = 0x0107;
    /**
     * Animation
     */
    private AnimationType mAnimationType;
    private int mAnimationDuration = 300;
    private boolean showItemAnimationEveryTime = false;
    private Interpolator mItemAnimationInterpolator;
    private CustomAnimator mCustomAnimator;
    private int mLastItemPosition = -1;
    /**
     * header and footer
     */
    private LinearLayout mHeaderLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mCopyHeaderLayout = null;
    private LinearLayout mCopyFooterLayout = null;
    private SpanSizeLookup mSpanSizeLookup;

    public CommonBaseAdapter(Context context) {
        this(context, null);
    }

    public CommonBaseAdapter(Context context, List<T> data) {
        mData = null == data ? new ArrayList<T>() : data;
        layoutIdMap = new HashMap<>();
        viewTypeMap = new HashMap<>();
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder CommonViewHolder;
        switch (viewType) {
            case VIEW_TYPE.HEADER://header
                CommonViewHolder = new CommonViewHolder(mHeaderLayout, mContext);
                break;
            case VIEW_TYPE.FOOTER://footer
                CommonViewHolder = new CommonViewHolder(mFooterLayout, mContext);
                break;
            default:
                CommonViewHolder = new CommonViewHolder(mInflater.inflate(layoutIdMap.get(viewType),
                        parent, false), mContext);
                initItemClickListener(CommonViewHolder);
                break;
        }
        return CommonViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getHeaderViewCount()) {
            return VIEW_TYPE.HEADER;
        } else if (position >= mData.size() + getHeaderViewCount()) {
            return VIEW_TYPE.FOOTER;
        } else {
            int currentPosition = position - getHeaderViewCount();
            int currentLayoutId = getItemViewLayoutId(currentPosition, mData.get(currentPosition));
            if (!viewTypeMap.containsKey(currentLayoutId)) {
                mCurrentViewTypeValue++;
                viewTypeMap.put(currentLayoutId, mCurrentViewTypeValue);
                layoutIdMap.put(viewTypeMap.get(currentLayoutId), currentLayoutId);
            }
            return viewTypeMap.get(currentLayoutId);
        }
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE.HEADER:
                // Do nothing
                break;
            case VIEW_TYPE.FOOTER:
                // Do nothing
                break;
            default:
                convert(holder, getItem(position - getHeaderViewCount()), position -
                        getHeaderViewCount());
                addAnimation(holder);
                break;
        }
    }

    protected final void addAnimation(final CommonViewHolder holder) {
        int currentPosition = holder.getAdapterPosition();
        if (null != mCustomAnimator) {
            mCustomAnimator.getAnimator(holder.itemView).setDuration(mAnimationDuration).start();
        } else if (null != mAnimationType) {
            if (showItemAnimationEveryTime || currentPosition > mLastItemPosition) {
                new AnimationUtil()
                        .setAnimationType(mAnimationType)
                        .setTargetView(holder.itemView)
                        .setDuration(mAnimationDuration)
                        .setInterpolator(mItemAnimationInterpolator)
                        .start();
                mLastItemPosition = currentPosition;
            }
        }
    }

    /**
     * init the CommonViewHolder to register mOnItemClickListener and mOnItemLongClickListener
     *
     * @param holder
     */
    protected final void initItemClickListener(final CommonViewHolder holder) {
        if (null != mOnItemClickListener) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int position = holder.getAdapterPosition() - getHeaderViewCount();
                    mOnItemClickListener.onItemClick(view, mData.get(position), position);
                }
            });
        }

        if (null != mOnItemLongClickListener) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    final int position = holder.getAdapterPosition() - getHeaderViewCount();
                    mOnItemLongClickListener.onItemLongClick(v, mData.get(position), position);
                    return true;
                }
            });
        }
    }

    /**
     * Base api
     */
    protected abstract void convert(CommonViewHolder holder, T item, int position);

    protected abstract int getItemViewLayoutId(int position, T item);

    protected T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size() + getHeaderViewCount() + getFooterViewCount();
    }


    /**
     * Listener api
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * Register a callback to be invoked when childView in this AdapterView has
     * been clicked and held
     * {@link OnRecyclerViewItemChildClickListener}
     *
     * @param childClickListener The callback that will run
     */
    public void setOnItemChildClickListener(OnRecyclerViewItemChildClickListener childClickListener) {
        this.mChildClickListener = childClickListener;
    }

    /**
     * Register a callback to be invoked when childView in this AdapterView has
     * been longClicked and held
     * {@link OnRecyclerViewItemChildLongClickListener}
     *
     * @param childLongClickListener The callback that will run
     */
    public void setOnItemChildLongClickListener(OnRecyclerViewItemChildLongClickListener childLongClickListener) {
        this.mChildLongClickListener = childLongClickListener;
    }

    /**
     * Animation api
     */
    public void setItemAnimation(AnimationType animationType) {
        mAnimationType = animationType;
    }

    public void setItemAnimationDuration(int animationDuration) {
        mAnimationDuration = animationDuration;
    }

    public void setItemAnimationInterpolator(Interpolator animationInterpolator) {
        mItemAnimationInterpolator = animationInterpolator;
    }

    public void setShowItemAnimationEveryTime(boolean showItemAnimationEveryTime) {
        this.showItemAnimationEveryTime = showItemAnimationEveryTime;
    }

    public void setCustomItemAnimator(CustomAnimator customAnimator) {
        mCustomAnimator = customAnimator;
    }

    /**
     * Header and footer api
     */
    public LinearLayout getHeaderLayout() {
        return mHeaderLayout;
    }

    public LinearLayout getFooterLayout() {
        return mFooterLayout;
    }

    public void addHeaderView(View header) {
        addHeaderView(header, -1);
    }

    public void addHeaderView(View header, int index) {
        if (mHeaderLayout == null) {
            if (mCopyHeaderLayout == null) {
                mHeaderLayout = new LinearLayout(header.getContext());
                mHeaderLayout.setOrientation(LinearLayout.VERTICAL);
                mHeaderLayout.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
                mCopyHeaderLayout = mHeaderLayout;
            } else {
                mHeaderLayout = mCopyHeaderLayout;
            }
        }
        index = index >= mHeaderLayout.getChildCount() ? -1 : index;
        mHeaderLayout.addView(header, index);
        this.notifyDataSetChanged();
    }

    public void addFooterView(View footer) {
        addFooterView(footer, -1);
    }

    public void addFooterView(View footer, int index) {
        if (mFooterLayout == null) {
            if (mCopyFooterLayout == null) {
                mFooterLayout = new LinearLayout(footer.getContext());
                mFooterLayout.setOrientation(LinearLayout.VERTICAL);
                mFooterLayout.setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
                mCopyFooterLayout = mFooterLayout;
            } else {
                mFooterLayout = mCopyFooterLayout;
            }
        }
        index = index >= mFooterLayout.getChildCount() ? -1 : index;
        mFooterLayout.addView(footer, index);
        this.notifyDataSetChanged();
    }

    public void removeHeaderView(View header) {
        if (mHeaderLayout == null) return;

        mHeaderLayout.removeView(header);
        if (mHeaderLayout.getChildCount() == 0) {
            mHeaderLayout = null;
        }
        this.notifyDataSetChanged();
    }

    public void removeFooterView(View footer) {
        if (mFooterLayout == null) return;

        mFooterLayout.removeView(footer);
        if (mFooterLayout.getChildCount() == 0) {
            mFooterLayout = null;
        }
        this.notifyDataSetChanged();
    }

    public void removeAllHeaderView() {
        if (mHeaderLayout == null) return;

        mHeaderLayout.removeAllViews();
        mHeaderLayout = null;
    }

    public void removeAllFooterView() {
        if (mFooterLayout == null) return;

        mFooterLayout.removeAllViews();
        mFooterLayout = null;
    }

    public int getHeaderViewCount() {
        return null == mHeaderLayout ? 0 : 1;
    }

    public int getFooterViewCount() {
        return null == mFooterLayout ? 0 : 1;
    }

    /**
     * @param spanSizeLookup instance to be used to query number of spans occupied by each item
     */
    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    if (mSpanSizeLookup == null)
                        return (type == VIEW_TYPE.HEADER || type == VIEW_TYPE.FOOTER) ? gridManager.getSpanCount() : 1;
                    else
                        return (type == VIEW_TYPE.HEADER || type == VIEW_TYPE.FOOTER) ? gridManager.getSpanCount() : mSpanSizeLookup.getSpanSize(gridManager, position - getHeaderViewCount());
                }
            });
        }
    }

    /**
     * Some interface
     */
    public interface OnItemClickListener<T> {
        void onItemClick(View view, T item, int position);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLongClick(View view, T item, int position);
    }

    public interface OnRecyclerViewItemChildClickListener {
        void onItemChildClick(CommonBaseAdapter adapter, View view, int position);
    }

    public interface OnRecyclerViewItemChildLongClickListener {
        boolean onItemChildLongClick(CommonBaseAdapter adapter, View view, int position);
    }

    public interface CustomAnimator {
        Animator getAnimator(View itemView);
    }

    public interface SpanSizeLookup {
        int getSpanSize(GridLayoutManager gridLayoutManager, int position);
    }

    public static class VIEW_TYPE {
        public static final int HEADER = 0x0010;
        public static final int FOOTER = 0x0011;
    }

    public class OnItemChildClickListener implements View.OnClickListener {
        public RecyclerView.ViewHolder mViewHolder;

        @Override
        public void onClick(View v) {
            if (mChildClickListener != null)
                mChildClickListener.onItemChildClick(CommonBaseAdapter.this, v, mViewHolder.getLayoutPosition() - getHeaderViewCount() - 1);
        }
    }

    public class OnItemChildLongClickListener implements View.OnLongClickListener {
        public RecyclerView.ViewHolder mViewHolder;

        @Override
        public boolean onLongClick(View v) {
            if (mChildLongClickListener != null) {
                return mChildLongClickListener.onItemChildLongClick(CommonBaseAdapter.this, v, mViewHolder.getLayoutPosition() - getHeaderViewCount() - 1);
            }
            return false;
        }
    }
}
