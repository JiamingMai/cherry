package com.kapok.model.store;

import java.io.Serializable;

public class StoreResult implements Serializable {

    private String message;

    public StoreResult() {
    }

   public StoreResult(String message) {
        this.message = message;
   }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
