package com.example.bernard.foodhunt;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by WongYeeKhang on 15/11/2017.
 */

public class FoodListFragment extends Fragment {


    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private FoodDataSource datasource;

    private List<Restaurant> mRestaurants;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_food_list,container,false);

        final String name = getActivity().getIntent().getStringExtra("name");
        final String location_selected = getActivity().getIntent().getStringExtra("location_selected");
        final String price_range_selected = getActivity().getIntent().getStringExtra("price_range_selected");
        final String meal = getActivity().getIntent().getStringExtra("meal");

        final TextView display_user_name = (TextView) view.findViewById(R.id.display_user_name);

        display_user_name.setText(name);

        Log.d("aaa","loca"+location_selected);
        Log.d("aaa","price"+price_range_selected);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //updateUI();

        datasource = new FoodDataSource(getActivity());
        datasource.open();

        //mRestaurants = datasource.getAllComments();
        mRestaurants = datasource.get_searchRestaurant(location_selected,price_range_selected,meal);
        mAdapter = new CrimeAdapter(mRestaurants);

        mCrimeRecyclerView.setAdapter(mAdapter);

        return view;
    }



    private class CrimeHolder extends RecyclerView.ViewHolder{

        private LinearLayout list_linear;
        private TextView restaurant_location,restaurant_name,price_range;
        ImageView img1;

        public CrimeHolder(View itemView){
            super(itemView);

            list_linear = (LinearLayout) itemView.findViewById(R.id.list_linear);
            restaurant_location = (TextView) itemView.findViewById(R.id.restaurant_location);
            restaurant_name = (TextView) itemView.findViewById(R.id.restaurant_name);
            price_range = (TextView) itemView.findViewById(R.id.price_range);
//            list_course_requirement = (TextView) itemView.findViewById(R.id.list_course_requirement);
//            list_course_requirement_grade = (TextView) itemView.findViewById(R.id.list_course_requirement_grade);
            img1 = (ImageView) itemView.findViewById(R.id.img_view);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

            private List<Restaurant> mRestaurants;

            public CrimeAdapter(List<Restaurant>crimes){
                mRestaurants = crimes;
            }

            @Override
            public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType){
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View view = layoutInflater.inflate(R.layout.list_item_food,parent,false);
                return new CrimeHolder(view);
            }

            @Override
            public void onBindViewHolder(CrimeHolder holder, int position) {
                final Restaurant restaurant = mRestaurants.get(position);

                holder.restaurant_location.setText(restaurant.getRestaurant_location());
                holder.restaurant_name.setText(restaurant.getRestaurant_name());
                holder.price_range.setText(restaurant.getRestaurant_price_range());

                if(restaurant.getRestaurant_name().equals("Ah Lai Kopitiam"))
                {
                    holder.img1.setImageResource(R.drawable.ahlai);
                }

                else if(restaurant.getRestaurant_name().equals("Pie Harbour"))
                {
                    holder.img1.setImageResource(R.drawable.pieharbour);
                }

                else if(restaurant.getRestaurant_name().equals("Permatang Food Court"))
                {
                    holder.img1.setImageResource(R.drawable.permatang);
                }

                else if(restaurant.getRestaurant_name().equals("Garden Feel Cafe"))
                {
                    holder.img1.setImageResource(R.drawable.garden);
                }

                else if(restaurant.getRestaurant_name().equals("Sungai Pinang Food Court"))
                {
                    holder.img1.setImageResource(R.drawable.sungai);
                }

                else if(restaurant.getRestaurant_name().equals("Sakae Shusi"))
                {
                    holder.img1.setImageResource(R.drawable.sakae);
                }

                else if(restaurant.getRestaurant_name().equals("Alma Food Court"))
                {
                    holder.img1.setImageResource(R.drawable.alma);
                }

                else if(restaurant.getRestaurant_name().equals("Kopitan Classic"))
                {
                    holder.img1.setImageResource(R.drawable.kopitan);
                }

                else if(restaurant.getRestaurant_name().equals("Karpal Sigh Food Court"))
                {
                    holder.img1.setImageResource(R.drawable.karpalsigh);
                }

                else if(restaurant.getRestaurant_name().equals("Spade Burger"))
                {
                    holder.img1.setImageResource(R.drawable.spade);
                }

                else if(restaurant.getRestaurant_name().equals("Lau You Food Court"))
                {
                    holder.img1.setImageResource(R.drawable.lauyou);
                }

                else if(restaurant.getRestaurant_name().equals("Texas Chicken"))
                {
                    holder.img1.setImageResource(R.drawable.texas);
                }


                holder.list_linear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        final Dialog dialog = new Dialog(getContext());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_food_detail);

                        final TextView dialog_restaurant_name = (TextView) dialog.findViewById(R.id.dialog_restaurant_name);
                        final TextView dialog_location = (TextView) dialog.findViewById(R.id.dialog_location);
                        final TextView dialog_price = (TextView) dialog.findViewById(R.id.dialog_price);
                        final ImageView dialog_image = (ImageView) dialog.findViewById(R.id.dialog_image);
                        final TextView dialog_opening_hour = (TextView) dialog.findViewById(R.id.dialog_opening_hour);

                        dialog_restaurant_name.setText(restaurant.getRestaurant_name());
                        dialog_location.setText(restaurant.getRestaurant_location());
                        dialog_price.setText(restaurant.getRestaurant_price_range_value());
                        dialog_opening_hour.setText(restaurant.getRestaurant_opening_hour());


                        if(restaurant.getRestaurant_name().equals("Ah Lai Kopitiam"))
                        {
                            dialog_image.setImageResource(R.drawable.ahlai);
                        }

                        else if(restaurant.getRestaurant_name().equals("Pie Harbour"))
                        {
                            dialog_image.setImageResource(R.drawable.pieharbour);
                        }

                        else if(restaurant.getRestaurant_name().equals("Permatang Food Court"))
                        {
                            dialog_image.setImageResource(R.drawable.permatang);
                        }

                        else if(restaurant.getRestaurant_name().equals("Garden Feel Cafe"))
                        {
                            dialog_image.setImageResource(R.drawable.garden);
                        }

                        else if(restaurant.getRestaurant_name().equals("Sungai Pinang Food Court"))
                        {
                            dialog_image.setImageResource(R.drawable.sungai);
                        }

                        else if(restaurant.getRestaurant_name().equals("Sakae Shusi"))
                        {
                            dialog_image.setImageResource(R.drawable.sakae);
                        }

                        else if(restaurant.getRestaurant_name().equals("Alma Food Court"))
                        {
                            dialog_image.setImageResource(R.drawable.alma);
                        }

                        else if(restaurant.getRestaurant_name().equals("Kopitan Classic"))
                        {
                            dialog_image.setImageResource(R.drawable.kopitan);
                        }

                        else if(restaurant.getRestaurant_name().equals("Karpal Sigh Food Court"))
                        {
                            dialog_image.setImageResource(R.drawable.karpalsigh);
                        }

                        else if(restaurant.getRestaurant_name().equals("Spade Burger"))
                        {
                            dialog_image.setImageResource(R.drawable.spade);
                        }

                        else if(restaurant.getRestaurant_name().equals("Lau You Food Court"))
                        {
                            dialog_image.setImageResource(R.drawable.lauyou);
                        }

                        else if(restaurant.getRestaurant_name().equals("Texas Chicken"))
                        {
                            dialog_image.setImageResource(R.drawable.texas);
                        }

                        //set the dialog width and height
                        dialog.getWindow().setLayout(
                                (int) (getScreenWidth(getActivity()) * 1.0), ViewGroup.LayoutParams.WRAP_CONTENT
                        );

                        dialog.show();
                    }
                });
            }

            @Override
            public int getItemCount(){
                return mRestaurants.size();
            }
    }


    public static int getScreenWidth(Activity activity) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        return size.x;
    }


}

