package com.wearablehealth.wearablehealth.services;

import com.wearablehealth.wearablehealth.entities.Doctors;
import com.wearablehealth.wearablehealth.entities.Pacients;
import com.wearablehealth.wearablehealth.repositories.DoctorsRepository;
import com.wearablehealth.wearablehealth.repositories.PacientsRepository;
import com.wearablehealth.wearablehealth.repositories.UsersRepository;
import com.wearablehealth.wearablehealth.utils.MyMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    DoctorsRepository doctorsRepository;

    @Autowired
    PacientsRepository pacientsRepository;

    public ResponseEntity<Object> insert(Doctors doctors) {
        try{
            doctorsRepository.insert(doctors);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> update(Doctors doctors) {
        try{
            doctorsRepository.update(doctors);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> delete(String id) {
        try{
            doctorsRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAll() {
        try{
            List<Doctors> list = doctorsRepository.getAll();
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
            Optional<Doctors> optional = doctorsRepository.getOne(id);
            if(optional.isPresent())
                return new ResponseEntity<>(optional, HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }

    public ResponseEntity<Object> getAllPacientsOf(String id) {
        try{
            List<String> allPacientsOfDoc = doctorsRepository.getAllPacientsOf(id);
            List<Pacients> pacientsList = new ArrayList<>();
            if(allPacientsOfDoc != null && !allPacientsOfDoc.isEmpty()) {
                for (String username : allPacientsOfDoc) {
                    Optional<Pacients> pacients = pacientsRepository.getOne(username);
                    if(pacients.isPresent())
                        pacientsList.add(pacients.get());
                }
                return new ResponseEntity<>(pacientsList,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new MyMessageResponse(e.getMessage()));
        }
    }
}
