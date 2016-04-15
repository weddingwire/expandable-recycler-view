package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ChildType;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.Model.ParentType;

import java.util.ArrayList;
import java.util.List;

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CrimeExpandableAdapter crimeExpandableAdapter = new CrimeExpandableAdapter(getActivity(), generateCrimes());
        crimeExpandableAdapter.onRestoreInstanceState(savedInstanceState);

        List<ParentType> parentTypes = new ArrayList();
        parentTypes.add(new ParentType(CrimeExpandableAdapter.VIEW_TYPE_FELONY, Felony.class));
        crimeExpandableAdapter.addParentViewTypes(parentTypes);

        List<ChildType> childTypes = new ArrayList();
        childTypes.add(new ChildType(CrimeExpandableAdapter.VIEW_TYPE_CRIME_DETAIL, CrimeChildDetail.class));
        crimeExpandableAdapter.addChildViewTypes(childTypes);

        mCrimeRecyclerView.setAdapter(crimeExpandableAdapter);

        return view;
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((CrimeExpandableAdapter) mCrimeRecyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    private List<ParentListItem> generateCrimes() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        List<ParentListItem> parentListItems = new ArrayList<>();
        for (Crime crime : crimes) {
            List<CrimeChild> childItemList = new ArrayList<>();
            if (crime.getDetail() != null) {
                childItemList.add(new CrimeChildDetail(crime.getDate(), crime.isSolved(), crime.getDetail()));
            } else {
                childItemList.add(new CrimeChild(crime.getDate(), crime.isSolved()));
            }
            crime.setChildItemList(childItemList);
            parentListItems.add(crime);
        }
        return parentListItems;
    }
}
