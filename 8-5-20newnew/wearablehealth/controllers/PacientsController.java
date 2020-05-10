package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.services.PacientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacients")
public class PacientsController {

    @Autowired
    PacientsService pacientsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Pacients pacients){
        return pacientsService.insert(pacients);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Pacients pacients){
        return pacientsService.update(pacients);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        return pacientsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return pacientsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") String id){return pacientsService.getOne(id);}

    @GetMapping("/getAllDoctorsOf/{id}")
    public ResponseEntity<Object> getAllDoctorsOf(@PathVariable("id") String id) {return pacientsService.getAllDoctorsOf(id);}
}
