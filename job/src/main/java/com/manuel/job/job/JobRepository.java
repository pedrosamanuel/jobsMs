package com.manuel.job.job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Override
    Optional<Job> findById(Long id);

    void deleteById(Long id);
}
