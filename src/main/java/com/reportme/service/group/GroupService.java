package com.reportme.service.group;

import com.reportme.model.Group;
import com.reportme.model.person.Person;
import com.reportme.repository.GroupRepository;
import com.reportme.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private PersonService personService;

    public Optional<Group> create(Group group) {
        Optional<Person> personToAddGroup = personService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(isGroupNameAvailable(group.getName()) && personToAddGroup.isPresent()){
            Group persistedGroup = groupRepository.save(group);
            personToAddGroup.get().getMyGroups().add(persistedGroup);
            return Optional.of(persistedGroup);
        }else{
            return Optional.empty();
        }
    }

    private boolean isGroupNameAvailable(final String groupName) {
        return !groupRepository.findByName(groupName).isPresent();
    }

    public Optional<Group> findByGroupName(final String groupName) {
        Optional<Group> group = groupRepository.findByName(groupName);
        if (group.isPresent()) return group;
        else return Optional.empty();
    }

    public void deleteByName(final String groupName) {
        Optional<Group> groupOptional = groupRepository.findByName(groupName);
        if(groupOptional.isPresent()) {
            personService.getAuthenticatedPerson().getMyGroups().remove(groupOptional.get());
            groupRepository.delete(groupOptional.get());
        }
    }
}
