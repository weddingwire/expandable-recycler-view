package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;


public class CrimeExpandableAdapter extends ExpandableRecyclerAdapter {

    private LayoutInflater mInflater;

    public static final int VIEW_TYPE_FELONY = 4;
    public static final int VIEW_TYPE_CRIME_DETAIL = 5;

    public CrimeExpandableAdapter(Context context, List<ParentListItem> itemList) {
        super(itemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_FELONY:
                view = mInflater.inflate(R.layout.list_item_felony_parent, viewGroup, false);
                return new FelonyParentViewHolder(view);
            default:
                view = mInflater.inflate(R.layout.list_item_crime_parent, viewGroup, false);
                return new CrimeParentViewHolder(view);
        }
    }

    @Override
    public CrimeChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_CRIME_DETAIL:
                view = mInflater.inflate(R.layout.list_item_crime_child, viewGroup, false);
                return new CrimeChildViewHolder(view);
            default:
                view = mInflater.inflate(R.layout.list_item_crime_child, viewGroup, false);
                return new CrimeChildViewHolder(view);
        }
    }

    @Override
    public void onBindParentViewHolder(ParentViewHolder parentViewHolder, int i, ParentListItem parentListItem) {
        if (parentViewHolder instanceof CrimeParentViewHolder) {
            Crime crime = (Crime) parentListItem;
            ((CrimeParentViewHolder) parentViewHolder).mCrimeTitleTextView.setText(crime.getTitle());
        } else if (parentViewHolder instanceof FelonyParentViewHolder) {
            Crime crime = (Crime) parentListItem;
            ((FelonyParentViewHolder) parentViewHolder).mCrimeTitleTextView.setText(crime.getTitle());
        }
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder childViewHolder, int position, Object childListItem) {
        CrimeChild crimeChild = (CrimeChild) childListItem;
        CrimeChildViewHolder crimeChildViewHolder = (CrimeChildViewHolder) childViewHolder;
        crimeChildViewHolder.mCrimeDateText.setText(crimeChild.getDate().toString());
        crimeChildViewHolder.mCrimeSolvedCheckBox.setChecked(crimeChild.isSolved());
    }

}
