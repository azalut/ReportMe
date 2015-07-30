package com.reportme.model.validation;

import com.reportme.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroupNameAvailableValidator implements ConstraintValidator<GroupNameAvailable, String> {
    @Autowired
    private GroupService groupService;

    @Override
    public void initialize(GroupNameAvailable groupNameAvailable) {

    }

    @Override
    public boolean isValid(String groupName, ConstraintValidatorContext constraintValidatorContext) {
        if(groupService == null){
            return true;
        }
        return !groupService.findByGroupName(groupName).isPresent();
    }
}
