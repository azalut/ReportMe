package com.reportme.repository;

import com.reportme.model.person.ConfirmTokenPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmTokenPersonRepository extends JpaRepository<ConfirmTokenPerson, Integer> {
    Optional<ConfirmTokenPerson> findByPersonId(int personId);
    ConfirmTokenPerson findByToken(String token);
}
