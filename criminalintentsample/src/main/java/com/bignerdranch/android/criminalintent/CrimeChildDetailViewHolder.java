package com.bignerdranch.android.criminalintent;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class CrimeChildDetailViewHolder extends ChildViewHolder {

    public TextView mCrimeDetailText;

    public CrimeChildDetailViewHolder(View itemView) {
        super(itemView);

        mCrimeDetailText = (TextView) itemView.findViewById(R.id.child_list_item_crime_detail_text_view);
    }
}
