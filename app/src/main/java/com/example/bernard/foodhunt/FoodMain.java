package com.example.bernard.foodhunt;

import android.support.v4.app.Fragment;

public class FoodMain extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new FoodMainFragment();
    }

}
