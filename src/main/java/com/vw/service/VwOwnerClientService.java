package com.vw.service;

import com.vw.customException.InvalidVwOwnerDetailException;
import com.vw.customException.OwnerDetailsNotFoundException;
import com.vw.entity.VwOwnerDetail;
import com.vw.repository.VwOwnerClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class VwOwnerClientService {
    Logger logger = LoggerFactory.getLogger(VwOwnerClientService.class);

    @Autowired
    VwOwnerClientRepository repo;

    public VwOwnerDetail saveModel(VwOwnerDetail vwOwnerDetail){
        return repo.save(vwOwnerDetail);
    }

    public List<VwOwnerDetail> getAllOwnerDetails(){
        return repo.findAll();
    }

    public VwOwnerDetail getOwnerDetailByClientId(int clientId){
        VwOwnerDetail detail = repo.findById(clientId).get();
        if (detail==null){
            throw new OwnerDetailsNotFoundException("Owner with client ID "+ clientId +" not found in database");
        }
        return detail;
    }

    public VwOwnerDetail updateExistingDetails(int clientId, VwOwnerDetail vwOwnerDetail){
        VwOwnerDetail detail = getOwnerDetailByClientId(clientId);
        if(vwOwnerDetail==null){
            throw new InvalidVwOwnerDetailException("Invalid or null VwOwnerDetail provided");
        }
        detail.setOwnerCityLocation(vwOwnerDetail.getOwnerCityLocation());
        detail.setOwnerContactNumber(vwOwnerDetail.getOwnerContactNumber());
        detail.setOwnerName(vwOwnerDetail.getOwnerName());
        detail.setVwCarDetails(vwOwnerDetail.getVwCarDetails());
        return repo.save(detail);
    }

    public VwOwnerDetail updatePartialOwnerDetails(int clientId, Map<String, Object> updates) {
        VwOwnerDetail obj = getOwnerDetailByClientId(clientId);

        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(VwOwnerDetail.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, obj, value);
            }
        });
        return repo.save(obj);
    }

    public String deleteOwnerDetailByClientId(int clientId){
        getOwnerDetailByClientId(clientId);
        repo.deleteById(clientId);
        return "Owner with id "+clientId+" has successfully deleted";
    }
}
