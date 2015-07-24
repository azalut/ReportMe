package com.reportme.repository;

import com.reportme.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByName(String name);
}
