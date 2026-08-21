package com.canor.climbtracker.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.canor.climbtracker.dto.CreateSetterRequest;
import com.canor.climbtracker.dto.SetterResponse;
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

    public List<Setter> getAllSetters() {
        return setterRepository.findAll();
    }

    public Setter getSetterById(int id) {
        return getSetterOrThrow(id);
    }

    public Setter updateSetter(int id, Setter updatedSetter) {
        Setter setter = getSetterOrThrow(id);

        setter.setName(updatedSetter.getName());
        setter.setClimbingStyle(updatedSetter.getClimbingStyle());
        setter.setYearsSetting(updatedSetter.getYearsSetting());

        return setterRepository.save(setter);
    }

    public Setter deleteSetter(int id) {
        Setter setter = getSetterOrThrow(id);

        setterRepository.delete(setter);

        return setter;
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
