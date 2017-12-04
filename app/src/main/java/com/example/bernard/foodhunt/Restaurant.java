package com.example.bernard.foodhunt;

/**
 * Created by WongYeeKhang on 1/11/2017.
 */

public class Restaurant {

    private String Restaurant_name;
    private String Restaurant_location;

    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        Restaurant_name = restaurant_name;
    }

    public String getRestaurant_location() {
        return Restaurant_location;
    }

    public void setRestaurant_location(String restaurant_location) {
        Restaurant_location = restaurant_location;
    }

    public String getRestaurant_price_range() {
        return Restaurant_price_range;
    }

    public void setRestaurant_price_range(String restaurant_price_range) {
        Restaurant_price_range = restaurant_price_range;
    }

    public String getRestaurant_price_range_value() {
        return Restaurant_price_range_value;
    }

    public void setRestaurant_price_range_value(String restaurant_price_range_value) {
        Restaurant_price_range_value = restaurant_price_range_value;
    }

    public String getRestaurant_opening_hour() {
        return Restaurant_opening_hour;
    }

    public void setRestaurant_opening_hour(String restaurant_opening_hour) {
        Restaurant_opening_hour = restaurant_opening_hour;
    }

    private String Restaurant_price_range;
    private String Restaurant_price_range_value;
    private String Restaurant_opening_hour;
    private long id;



    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

}
