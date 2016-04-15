package com.ryanbrooks.expandablerecyclerviewsample.linear.horizontal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;

import java.util.List;

/**
 * An example custom implementation of the ExpandableRecyclerAdapter.
 */
public class HorizontalExpandableAdapter extends ExpandableRecyclerAdapter {

    private LayoutInflater mInflater;

    /**
     * Public primary constructor.
     *
     * @param parentItemList the list of parent items to be displayed in the RecyclerView
     */
    public HorizontalExpandableAdapter(Context context, List<? extends ParentListItem> parentItemList) {
        super(parentItemList);
        mInflater = LayoutInflater.from(context);
    }

    /**
     * OnCreateViewHolder implementation for parent items. The desired ParentViewHolder should
     * be inflated here
     *
     * @param parent for inflating the View
     * @return the user's custom parent ViewHolder that must extend ParentViewHolder
     */
    @Override
    public HorizontalParentViewHolder onCreateParentViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_parent_horizontal, parent, false);
        return new HorizontalParentViewHolder(view);
    }

    /**
     * OnCreateViewHolder implementation for child items. The desired ChildViewHolder should
     * be inflated here
     *
     * @param parent for inflating the View
     * @return the user's custom parent ViewHolder that must extend ParentViewHolder
     */
    @Override
    public HorizontalChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_child_horizontal, parent, false);
        return new HorizontalChildViewHolder(view);
    }

    /**
     * OnBindViewHolder implementation for parent items. Any data or view modifications of the
     * parent view should be performed here.
     *
     * @param parentViewHolder the ViewHolder of the parent item created in OnCreateParentViewHolder
     * @param position the position in the RecyclerView of the item
     * @param parentListItem the object for this position
     */
    @Override
    public void onBindParentViewHolder(ParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        if (parentViewHolder instanceof HorizontalParentViewHolder) {
            HorizontalParent horizontalParent = (HorizontalParent) parentListItem;
            ((HorizontalParentViewHolder) parentViewHolder).bind(horizontalParent.getParentNumber(), horizontalParent.getParentText());
        }
    }

    /**
     * OnBindViewHolder implementation for child items. Any data or view modifications of the
     * child view should be performed here.
     *
     * @param childViewHolder the ViewHolder of the child item created in OnCreateChildViewHolder
     * @param position the position in the RecyclerView of the item
     * @param childListItem the object for this position
     */
    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int position, Object childListItem) {
        HorizontalChild horizontalChild = (HorizontalChild) childListItem;
        HorizontalChildViewHolder horizontalChildViewHolder = (HorizontalChildViewHolder) childViewHolder;
        horizontalChildViewHolder.bind(horizontalChild.getChildText());
    }
}