package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    DoctorsService doctorsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Doctors doctors){
        return doctorsService.insert(doctors);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Doctors doctors){
        return doctorsService.update(doctors);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        return doctorsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return doctorsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") String id){return doctorsService.getOne(id);}

    @GetMapping("/getAllPacientsOf/{id}")
    public ResponseEntity<Object> getAllPacientsOf(@PathVariable("id") String id){
        return doctorsService.getAllPacientsOf(id);
    }
}
