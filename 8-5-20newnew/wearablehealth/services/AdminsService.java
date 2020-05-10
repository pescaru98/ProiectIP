package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.Admins;
import com.wearablehealth.wearablehealth.repositories.AdminsRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminsService {

    @Autowired
    AdminsRepository adminsRepository;

    public ResponseEntity<Object> insert(Admins admins) {
        try{
            adminsRepository.insert(admins);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(Admins admins) {
        try{
            adminsRepository.update(admins);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(String id) {
        try{
            adminsRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<Admins> list = adminsRepository.getAll();
            if(list != null && !list.isEmpty())
                return new ResponseEntity<>(list, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getOne(String id) {
        try{
            Optional<Admins> optional = adminsRepository.getOne(id);
            if(optional.isPresent())
                return new ResponseEntity<>(optional, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
