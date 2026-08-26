package com.canor.climbtracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

import com.canor.climbtracker.dto.ClimbingProblemResponse;
import com.canor.climbtracker.dto.CreateClimbingProblemRequest;
import com.canor.climbtracker.dto.PaginatedClimbingProblemResponse;
import com.canor.climbtracker.dto.PatchClimbingProblemRequest;
import com.canor.climbtracker.dto.UpdateClimbingProblemRequest;
import com.canor.climbtracker.model.ClimbingProblem;
import com.canor.climbtracker.model.Setter;
import com.canor.climbtracker.repository.ClimbingProblemRepository;


import com.canor.climbtracker.exception.ClimbingProblemNotFoundException;

@Service
public class ClimbingProblemService {
   
    private final ClimbingProblemRepository problemRepository;
    private final SetterService setterService;

    public ClimbingProblemService(ClimbingProblemRepository problemRepository, SetterService setterService) {
        this.problemRepository = problemRepository;
        this.setterService = setterService;
    }

    public PaginatedClimbingProblemResponse getAllProblems(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        
        Page<ClimbingProblem> problemPage = problemRepository.findAll(pageRequest);
        
        List<ClimbingProblemResponse> problemResponses = 
            problemPage.getContent()
                .stream()
                .map(this::toResponse)
                .toList();

        return new PaginatedClimbingProblemResponse(
            problemResponses,
            problemPage.getNumber(),
            problemPage.getSize(),
            problemPage.getTotalElements(),
            problemPage.getTotalPages(),
            problemPage.isFirst(),
            problemPage.isLast()
        );
    }

    public ClimbingProblemResponse getProblemById(int id) {
        ClimbingProblem problem = getClimbingProblemOrThrow(id);

        return toResponse(problem);
    }

    public ClimbingProblemResponse addProblem(CreateClimbingProblemRequest request) {
        Setter setter = setterService.getSetterEntityById(request.getSetterId());
    
        ClimbingProblem problem = new ClimbingProblem();

        problem.setClimbName(request.getClimbName());
        problem.setGrade(request.getGrade());
        problem.setSetter(setter);

        ClimbingProblem savedProblem = problemRepository.save(problem); 
        return toResponse(savedProblem);
    }

    public List<ClimbingProblemResponse> searchByGrade(String grade) {
        return problemRepository.findByGrade(grade)
            .stream()
            .map(this::toResponse)
            .toList();
    }

    public ClimbingProblemResponse deleteProblem(Integer id) {
        ClimbingProblem problem = getClimbingProblemOrThrow(id);

        problemRepository.deleteById(id);
        return toResponse(problem);
    }

    public ClimbingProblemResponse updateProblem(int id, UpdateClimbingProblemRequest request) {
        ClimbingProblem existingProblem = getClimbingProblemOrThrow(id);
        Setter setter = setterService.getSetterEntityById(request.getSetterId());

        existingProblem.setClimbName(request.getClimbName());
        existingProblem.setGrade(request.getGrade());
        existingProblem.setSetter(setter);
        
        ClimbingProblem savedProblem = problemRepository.save(existingProblem);
        return toResponse(savedProblem);
    }

    public ClimbingProblemResponse patchProblem(int id, PatchClimbingProblemRequest request) {
        ClimbingProblem existingProblem = getClimbingProblemOrThrow(id);

        if (request.getClimbName() != null) {
            existingProblem.setClimbName(request.getClimbName());
        }

        if (request.getGrade() != null) {
            existingProblem.setGrade(request.getGrade());
        }

        if (request.getSetterId() != null) {
            Setter setter = setterService.getSetterEntityById(request.getSetterId());
            existingProblem.setSetter(setter);
        }

        ClimbingProblem savedProblem = problemRepository.save(existingProblem);
        return toResponse(savedProblem);
    }

    private ClimbingProblem getClimbingProblemOrThrow(int id) {
        ClimbingProblem problem = problemRepository.findById(id).orElse(null);

        if (problem == null) {
            throw new ClimbingProblemNotFoundException(id);
        }
        return problem;
    }


    // Converts a ClimbingProblem entity into a response DTO
    private ClimbingProblemResponse toResponse(ClimbingProblem problem) {
        return new ClimbingProblemResponse(
            problem.getId(),
            problem.getClimbName(),
            problem.getGrade(),
            problem.getSetter().getName()
        );
    }
}
