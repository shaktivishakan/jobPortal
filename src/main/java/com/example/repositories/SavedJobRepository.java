package com.example.repositories;

import com.example.models.SavedJob;
import com.example.models.SavedJobId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedJobRepository extends JpaRepository<SavedJob, SavedJobId> {
}
