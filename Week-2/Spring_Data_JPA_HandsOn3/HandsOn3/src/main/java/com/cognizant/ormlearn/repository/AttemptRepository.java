package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("select distinct a from Attempt a " +
           "left join fetch a.attemptQuestions aq " +
           "left join fetch aq.question q " +
           "left join fetch q.optionsList o " +
           "left join fetch aq.attemptOptions ao " +
           "left join fetch ao.options " +
           "where a.user.id = :userId and a.id = :attemptId")
    Optional<Attempt> getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
