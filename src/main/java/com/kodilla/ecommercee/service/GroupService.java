package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Group getGroup(final Long id) {
        return repository.getOne(id);
    }

    public Group saveGroup(final Group group) {
        return repository.save(group);
    }

    @Transactional
    public void deleteGroup(final Long id){
        repository.deleteById(id);
    }
}
