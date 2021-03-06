package com.codekrypt.retroifit.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CarCompanyList_POJO {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("carcompanies")
    @Expose
    private List<Carcompany> carcompanies = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Carcompany> getCarcompanies() {
        return carcompanies;
    }

    public void setCarcompanies(List<Carcompany> carcompanies) {
        this.carcompanies = carcompanies;
    }
}
