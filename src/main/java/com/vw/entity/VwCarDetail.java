package com.vw.entity;


import org.springframework.data.mongodb.core.mapping.Field;

public class VwCarDetail {

    @Field(name = "car_model_name")
    private String modelName;

    @Field(name = "car_variant")
    private String variant;

    @Field(name = "car_price")
    private int price;

    @Field(name = "car_chassis_number")
    private int chassisNo;

    @Field(name = "car_kilometer_driver")
    private int kmsDriven;

    @Field(name = "car_registration_state")
    private String registeredState;

    @Field(name = "car_registered_number")
    private String registeredNumber;

    public VwCarDetail() {
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public String getRegisteredState() {
        return registeredState;
    }

    public void setRegisteredState(String registeredState) {
        this.registeredState = registeredState;
    }

    public int getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(int kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public int getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(int chassisNo) {
        this.chassisNo = chassisNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public VwCarDetail(String modelName, String variant, int price, int chassisNo, int kmsDriven, String registeredState, String registeredNumber) {
        this.modelName = modelName;
        this.variant = variant;
        this.price = price;
        this.chassisNo = chassisNo;
        this.kmsDriven = kmsDriven;
        this.registeredState = registeredState;
        this.registeredNumber = registeredNumber;
    }

    @Override
    public String toString() {
        return "VwCarDetail{" +
                ", modelName='" + modelName + '\'' +
                ", variant='" + variant + '\'' +
                ", price=" + price +
                ", chassisNo=" + chassisNo +
                ", kmsDriven=" + kmsDriven +
                ", registeredState='" + registeredState + '\'' +
                ", registeredNumber='" + registeredNumber + '\'' +
                '}';
    }
}


//    @JoinField(name = "owner_id")