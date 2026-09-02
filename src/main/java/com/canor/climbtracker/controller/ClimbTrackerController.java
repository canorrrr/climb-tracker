package com.canor.climbtracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canor.climbtracker.dto.CreateClimbingProblemRequest;
import com.canor.climbtracker.dto.PaginatedClimbingProblemResponse;
import com.canor.climbtracker.service.ClimbingProblemService;
import com.canor.climbtracker.dto.ClimbingProblemResponse;
import com.canor.climbtracker.dto.UpdateClimbingProblemRequest;
import com.canor.climbtracker.dto.PatchClimbingProblemRequest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import jakarta.validation.Valid;

@RestController
public class ClimbTrackerController{

   private final ClimbingProblemService service;

   public ClimbTrackerController(ClimbingProblemService service) {
    this.service = service;
   }

    @GetMapping(path = "/problems")
    public PaginatedClimbingProblemResponse problems(
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "climbName") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        
        return service.getAllProblems(page, size, sortBy, direction);
    }

    //Searching problem by id(index)
    @GetMapping(path = "/problems/{id}")
    public ClimbingProblemResponse getProblemById(@PathVariable int id) {
        return service.getProblemById(id);
    }

    //Adding new problem
    @PostMapping(path = "/problems")
    public ClimbingProblemResponse addProblem(@Valid @RequestBody CreateClimbingProblemRequest request) {
        return service.addProblem(request);
    }

    //Searching problem by grade
    @GetMapping(path = "/problems/search")
    public List<ClimbingProblemResponse> searchProblems(@RequestParam String grade) {
        return service.searchByGrade(grade);
    }

    //Updates problem by ID
    @PutMapping(path = "/problems/{id}")
    public ClimbingProblemResponse updateProblem(@PathVariable int id, @Valid @RequestBody UpdateClimbingProblemRequest request) {
        return service.updateProblem(id, request);
    }

    @PatchMapping(path = "/problems/{id}")
    public ClimbingProblemResponse patchProblem(@PathVariable int id, @Valid @RequestBody PatchClimbingProblemRequest request) {
        return service.patchProblem(id, request);
    }

    // Deletes problem by ID
    @DeleteMapping(path = "/problems/{id}")
    public ClimbingProblemResponse deleteProblem(@PathVariable int id) {
        return service.deleteProblem(id); 
    }


    @GetMapping(path = "/sessions")
    public String sessions() {
        return "All climbing sessions";
    }
    
}