package com.vw.controller;

import com.vw.entity.VwOwnerDetail;
import com.vw.service.VwOwnerClientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vw/api")
public class VwOwnerClientController {

    Logger logger = LoggerFactory.getLogger(VwOwnerClientController.class);

    @Autowired
    VwOwnerClientService clientService;

    @PostMapping("/saveOwnerDetail") //localhost:8080/vw/api/save
    @ResponseStatus(HttpStatus.CREATED)
    public VwOwnerDetail saveOwnerDetails(@RequestBody @Valid VwOwnerDetail detail){
        logger.debug("Payload received by client: "+detail);
        return clientService.saveModel(detail);
    }

    @GetMapping("/getAllOwnersDetail") //localhost:8080/vw/api/getAllOwnersDetail
    public List<VwOwnerDetail> getAllOwnerDetails(){
        return clientService.getAllOwnerDetails();
    }

    @GetMapping("/getOwnerDetailById/{id}") //localhost:8080/vw/api/getOwnerDetailById/1
    public VwOwnerDetail getOwnerDetailById(@PathVariable int id){
        System.out.println(111111111);
        return clientService.getOwnerDetailByClientId(id);
    }

    @PutMapping("/updateOwnerDetail/{id}") //localhost:8080/vw/api/updateOwnerDetail/1
    public VwOwnerDetail updateOwnerdetail(@PathVariable int id, @Valid @RequestBody VwOwnerDetail obj){
        return clientService.updateExistingDetails(id,obj);
    }

    @PatchMapping("/updatePartialOwnerDetail/{id}") //localhost:8080/vw/api/updatePartialOwnerDetail/1
    public VwOwnerDetail updatePartialOwnerDetail(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return clientService.updatePartialOwnerDetails(id, updates);
    }


    @DeleteMapping("/deleteOwnerDetail") //localhost:8080/vw/api/deleteOwnerDetail?id=2
    public String deleteOwnerDetails(@RequestParam int id){
        return clientService.deleteOwnerDetailByClientId(id);
    }
}

/*

{
  "clientId":2,
  "ownerName": "John Doe",
  "ownerContactNumber": 9876543210,
  "ownerCityLocation": "Mumbai",
  "vwCarDetails": [
    {
      "modelName": "Volkswagen Polo",
      "variant": "Highline",
      "price": 800000,
      "chassisNo": 12345678,
      "kmsDriven": 50000,
      "registeredState": "MH",
      "registeredNumber": "MH12AB1234"
    }
  ]
}

{
  "clientId": 1,
  "ownerName": "Satyam Gopale",
  "ownerContactNumber": 1234567890,
  "ownerCityLocation": "Pune",
  "vwCarDetails": [
    {
      "modelName": "Vento",
      "variant": "Comfortline",
      "price": 700000,
      "chassisNo": 54321,
      "kmsDriven": 60000,
      "registeredState": "KA",
      "registeredNumber": "KA01CD5678"
    }
  ]
}


*/

