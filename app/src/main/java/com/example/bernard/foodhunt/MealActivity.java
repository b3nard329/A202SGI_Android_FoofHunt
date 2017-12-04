package com.example.bernard.foodhunt;

import android.support.v4.app.Fragment;

public class MealActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new MealFragment();
    }

}
