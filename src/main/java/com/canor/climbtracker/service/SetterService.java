package com.canor.climbtracker.service;

import java.util.List;
import org.springframework.stereotype.Service;


import com.canor.climbtracker.dto.CreateSetterRequest;
import com.canor.climbtracker.dto.PatchSetterRequest;
import com.canor.climbtracker.dto.SetterResponse;
import com.canor.climbtracker.dto.UpdateSetterRequest;
import com.canor.climbtracker.exception.SetterNotFoundException;
import com.canor.climbtracker.model.Setter;
import com.canor.climbtracker.repository.SetterRepository;


@Service
public class SetterService {
    private final SetterRepository setterRepository;

    public SetterService(SetterRepository setterRepository) {
        this.setterRepository = setterRepository;
    }

    public SetterResponse addSetter(CreateSetterRequest request) {
        Setter setter = new Setter();

        setter.setName(request.getName());
        setter.setClimbingStyle(request.getClimbingStyle());
        setter.setYearsSetting(request.getYearsSetting());

        Setter savedSetter = setterRepository.save(setter);
        return toResponse(savedSetter);
    }

    public List<SetterResponse> getAllSetters() {
        return setterRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    public SetterResponse getSetterById(int id) {
        Setter setter = getSetterOrThrow(id);

        return toResponse(setter);
    }

    public SetterResponse updateSetter(int id, UpdateSetterRequest updatedSetter) {
        Setter existingSetter = getSetterOrThrow(id); 

        existingSetter.setName(updatedSetter.getName());
        existingSetter.setClimbingStyle(updatedSetter.getClimbingStyle());
        existingSetter.setYearsSetting(updatedSetter.getYearsSetting());

        Setter savedSetter = setterRepository.save(existingSetter);
        return toResponse(savedSetter);
    }

    public SetterResponse patchSetter(int id, PatchSetterRequest request) {
        Setter existingSetter = getSetterOrThrow(id);

        if (request.getName() != null) {
            existingSetter.setName(request.getName());
        }

        if (request.getClimbingStyle() != null) {
            existingSetter.setClimbingStyle(request.getClimbingStyle());
        }

        if (request.getYearsSetting() != null) {
            existingSetter.setYearsSetting(request.getYearsSetting());
        }

        Setter savedSetter = setterRepository.save(existingSetter);
        return toResponse(savedSetter);
    }

    public SetterResponse deleteSetter(int id) {
        Setter setter = getSetterOrThrow(id);

        setterRepository.delete(setter);

        return toResponse(setter);
    }

    public Setter getSetterEntityById(int id) {
        return getSetterOrThrow(id);
    }

    private Setter getSetterOrThrow(int id) {
        Setter setter = setterRepository.findById(id).orElse(null);

        if (setter == null) {
            throw new SetterNotFoundException(id);
        }

        return setter;
    }

    private SetterResponse toResponse(Setter setter) {
        return new SetterResponse(
            setter.getId(),
            setter.getName(),
            setter.getClimbingStyle(),
            setter.getYearsSetting()
        );
    }
}
