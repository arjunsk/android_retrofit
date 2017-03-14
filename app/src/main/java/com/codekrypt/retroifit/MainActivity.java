package com.codekrypt.retroifit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.codekrypt.retroifit.POJO.CarCompanyList_POJO;
import com.codekrypt.retroifit.POJO.Carcompany;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    // NOTE: Global Declaration
    List<Carcompany> list_car_company;  // Hold the list of car companies
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NOTE : initializing
        lv=(ListView) findViewById(R.id.listView);
        restCall();
    }



    //---------------------------------REST-----------------------------------------------------//
    private void restCall() {

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                                             .setEndpoint(REST.BASEURL)
                                             .build();
        REST.api_carCompanies api = adapter.create(REST.api_carCompanies.class);

        //Defining the method
        api.getData(new Callback<CarCompanyList_POJO>() {
            @Override
            public void success( CarCompanyList_POJO  car_list_response , Response response) {
                if (car_list_response != null){

                    list_car_company = car_list_response.getCarcompanies();  // Takes list of car from Response

                    //Loads List View
                    Adapter arrayAdapter = new Adapter(getBaseContext(), list_car_company);
                    lv.setAdapter(arrayAdapter);

                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Failed to Connect REST",""+error.getCause());
            }
        });

    //---------------------*** END REST ***-----------------------------------------------------//


    }
}
