package com.bignerdranch.android.criminalintent;

import java.util.Date;

/**
 * Created by ryanbrooks on 6/17/15.
 */
public class CrimeChildDetail extends CrimeChild{

    private String mDetail;

    public CrimeChildDetail(Date date, boolean solved, String detail) {
        super(date, solved);
        mDetail = detail;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        mDetail = detail;
    }
}
