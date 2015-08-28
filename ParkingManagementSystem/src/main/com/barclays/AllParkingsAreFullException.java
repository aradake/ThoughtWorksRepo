package com.barclays;

public class AllParkingsAreFullException extends RuntimeException {

    @Override
    public String getMessage() {
        return "All Parkings are Full";
    }


}
