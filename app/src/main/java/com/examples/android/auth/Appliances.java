package com.examples.android.auth;

public class Appliances {
    private String userId;
    private String itemName;
    private String PlaceName;
    private boolean status;

    public Appliances(){

    }

    public Appliances(String userId, String itemName, String placeName, boolean status) {
        this.userId = userId;
        this.itemName = itemName;
        PlaceName = placeName;
        this.status = status;

    }

    public String getUserId() {
        return userId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public boolean getStatus() {
        return status;
    }


}
