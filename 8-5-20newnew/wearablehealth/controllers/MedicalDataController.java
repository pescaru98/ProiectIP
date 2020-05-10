package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.MedicalData;
import com.wearablehealth.wearablehealth.services.MedicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicaldata")
public class MedicalDataController {

    @Autowired
    MedicalDataService medicalDataService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody MedicalData medicalData){
        return medicalDataService.insert(medicalData);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody MedicalData medicalData){
        return medicalDataService.update(medicalData);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        return medicalDataService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return medicalDataService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") int id){return medicalDataService.getOne(id);}

    @GetMapping("/getAllOf/{id}")
    public ResponseEntity<Object> getAllOf(@PathVariable("id") String id){return medicalDataService.getAllOf(id);}
}
