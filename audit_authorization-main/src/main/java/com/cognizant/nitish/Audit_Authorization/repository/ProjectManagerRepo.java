package com.cognizant.nitish.Audit_Authorization.repository;

import com.cognizant.nitish.Audit_Authorization.model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectManagerRepo extends JpaRepository<ProjectManager, Integer>{

    @Query(value = "SELECT p FROM ProjectManager p WHERE p.username = ?1")
    public ProjectManager getProjectManagerByUserName(String username);
}
