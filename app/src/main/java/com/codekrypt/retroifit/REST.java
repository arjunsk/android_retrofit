package com.codekrypt.retroifit;

import com.codekrypt.retroifit.POJO.CarCompanyList_POJO;

import retrofit.Callback;
import retrofit.http.GET;


public class REST {

    public static String BASEURL="https://api.myjson.com";

    public interface api_carCompanies {

        @GET("/bins/1w1ac") // specify the sub url for the base url
        void getData(Callback<CarCompanyList_POJO> response); // will give you the json data
    }


}
