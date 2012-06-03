package com.wabbit.selenium.auto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: andrey.osipov
 */
public class AutoSearchRequest {

    @NotNull
    @Size(min = 2, max = 4)
    private String make;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}