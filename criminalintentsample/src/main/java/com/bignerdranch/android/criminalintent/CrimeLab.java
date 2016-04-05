package com.bignerdranch.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private ArrayList<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 100; i++) {
            if(i % (ran.nextInt(3) + 1) == 0) {
                Crime crime = new Crime();
                crime.setTitle("Crime #" + i);
                crime.setSolved(i % 2 == 0);
                mCrimes.add(crime);
            } else {
                Felony crime = new Felony();
                crime.setTitle("Felony #" + i);
                crime.setSolved(i % 2 == 0);
                crime.setDetail("Details");
                mCrimes.add(crime);
            }
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
