package com.canor.climbtracker.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.canor.climbtracker.model.ClimbingProblem;

public interface ClimbingProblemRepository extends JpaRepository<ClimbingProblem, Integer> {
    
    List<ClimbingProblem> findByGrade(String grade);
}
