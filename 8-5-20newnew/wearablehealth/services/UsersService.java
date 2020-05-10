package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.Admins;
import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.entities.Users;
import com.wearablehealth.wearablehealth.repositories.UsersRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<Object> getAllUsers(){
        try {
            List<Users> usersList = usersRepository.getAllUsers();
            if(usersList!= null || !usersList.isEmpty()){
                return new ResponseEntity<>(usersList,HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getUserById(String id) {
        try{
            Optional<Users> user = usersRepository.getUserById(id);
            if(user.isPresent()){
                return new ResponseEntity<Object>(user,HttpStatus.OK);
            }
            else return new ResponseEntity<Object>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> checkCredentials(Users users) {
        try{
            Optional<Users> foundUsers = usersRepository.checkCredentials(users);
            if(foundUsers.isPresent()) return new ResponseEntity<>(foundUsers.get().getRole_id(),HttpStatus.OK);
            else return new ResponseEntity<>(0,HttpStatus.OK);

        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> insert(Users users) {
        try{
             usersRepository.insert(users);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
