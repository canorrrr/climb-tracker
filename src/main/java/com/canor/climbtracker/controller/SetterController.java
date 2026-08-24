package com.canor.climbtracker.controller;

import java.util.List; 

import org.springframework.web.bind.annotation.RestController;

import com.canor.climbtracker.dto.CreateSetterRequest;
import com.canor.climbtracker.dto.PatchSetterRequest;
import com.canor.climbtracker.model.Setter;
import com.canor.climbtracker.service.SetterService;
import com.canor.climbtracker.dto.SetterResponse;
import com.canor.climbtracker.dto.UpdateSetterRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import jakarta.validation.Valid;


@RestController
public class SetterController {
    private final SetterService service; 

    public SetterController(SetterService service) {
        this.service = service;
    }

    @GetMapping(path = "/setters")
    public List<SetterResponse> getAllSetters() {
        return service.getAllSetters();
    }

    @PostMapping(path = "/setters")
    public SetterResponse addSetter(@Valid @RequestBody CreateSetterRequest request) {
        return service.addSetter(request);
    }
    

    @GetMapping(path = "/setters/{id}")
    public SetterResponse getSetterById(@PathVariable int id) {
        return service.getSetterById(id);
    }

    @PutMapping(path = "/setters/{id}")
    public SetterResponse updateSetter(@PathVariable int id, @Valid @RequestBody UpdateSetterRequest updatedSetter) {
        return service.updateSetter(id, updatedSetter);
    } 

    @PatchMapping(path = "/setters/{id}")
    public SetterResponse patchSetter(@PathVariable int id, @Valid @RequestBody PatchSetterRequest request) {
        return service.patchSetter(id, request);
    }

    @DeleteMapping(path = "/setters/{id}")
    public Setter deleteSetter(@PathVariable int id) {
        return service.deleteSetter(id);
    }
}
