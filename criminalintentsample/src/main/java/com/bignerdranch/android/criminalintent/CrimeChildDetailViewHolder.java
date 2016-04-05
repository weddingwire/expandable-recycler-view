package com.bignerdranch.android.criminalintent;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

/**
 * Created by ryanbrooks on 6/17/15.
 */
public class CrimeChildDetailViewHolder extends ChildViewHolder {

    public TextView mCrimeDetailText;

    public CrimeChildDetailViewHolder(View itemView) {
        super(itemView);

        mCrimeDetailText = (TextView) itemView.findViewById(R.id.child_list_item_crime_detail_text_view);
    }
}
