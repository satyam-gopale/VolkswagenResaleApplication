package com.vw.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Document(collection="VwOwnerDetail")
public class VwOwnerDetail {

    @Id
    private int clientId;

    @Field(name = "owner_name")
    @Indexed(unique = true)
    @NotBlank(message = "Owner name must not be blank")
    private String ownerName;

    @Field(name = "owner_contact_number")
    @Digits(integer = 15, fraction = 0, message = "Contact number must be a valid number")
    @Positive(message = "Contact number must be positive")
    private long ownerContactNumber;

    @Field(name = "owner_city_location")
    @NotBlank(message = "City location must not be blank")
    private String ownerCityLocation;

    @Field(name = "vw_car_detail_list")
    @NotEmpty(message = "Car detail list must not be empty")
    private List<VwCarDetail> vwCarDetails;

    public VwOwnerDetail(){
    }

    public int getClientId() {
        return clientId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(long ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public String getOwnerCityLocation() {
        return ownerCityLocation;
    }

    public void setOwnerCityLocation(String ownerCityLocation) {
        this.ownerCityLocation = ownerCityLocation;
    }

    public List<VwCarDetail> getVwCarDetails() {
        return vwCarDetails;
    }

    public void setVwCarDetails(List<VwCarDetail> vwCarDetails) {
        this.vwCarDetails = vwCarDetails;
    }

    public VwOwnerDetail(List<VwCarDetail> vwCarDetails, String ownerCityLocation, long ownerContactNumber, String ownerName) {
        this.vwCarDetails = vwCarDetails;
        this.ownerCityLocation = ownerCityLocation;
        this.ownerContactNumber = ownerContactNumber;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "VwOwnerDetail{" +
                "clientId=" + clientId +
                ", ownerName='" + ownerName + '\'' +
                ", ownerContactNumber=" + ownerContactNumber +
                ", ownerCityLocation='" + ownerCityLocation + '\'' +
                ", vwCarDetails=" + vwCarDetails +
                '}';
    }
}

//            (mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

