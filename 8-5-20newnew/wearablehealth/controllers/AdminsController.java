package com.wearablehealth.wearablehealth.controllers;


import com.wearablehealth.wearablehealth.entities.Admins;
import com.wearablehealth.wearablehealth.services.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    AdminsService adminsService;

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Admins admins){
        return adminsService.insert(admins);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Admins admins){
        return adminsService.update(admins);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
        return adminsService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){return adminsService.getAll();}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") String id){return adminsService.getOne(id);}
}
