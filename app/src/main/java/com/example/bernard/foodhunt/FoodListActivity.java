package com.example.bernard.foodhunt;

import android.support.v4.app.Fragment;

/**
 * Created by WongYeeKhang on 15/11/2017.
 */

public class FoodListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FoodListFragment();
    }
}
