package com.wearablehealth.wearablehealth.controllers;

import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.entities.Users;
import com.wearablehealth.wearablehealth.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") String id){
        return usersService.getUserById(id);
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<Object> checkCredentials(@RequestBody Users users) {return usersService.checkCredentials(users);}

/*    @GetMapping("/getAllOfMedic/{id}")
    public ResponseEntity<Object> getAllOfMedic(@PathVariable("id") String id){
        return userService.getAllOfMedic(id);
    }

    @GetMapping("/getAllMedicsOfPacient/{id}")
    public ResponseEntity<Object> getAllMedicsOfPacient(@PathVariable("id") String id){
        return usersService.getAllMedicsOfPacient(id);
    }*/

    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Users users){
        return usersService.insert(users);
    }

}
