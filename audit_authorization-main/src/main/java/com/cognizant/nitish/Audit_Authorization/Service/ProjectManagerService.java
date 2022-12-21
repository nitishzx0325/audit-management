package com.cognizant.nitish.Audit_Authorization.Service;

import com.cognizant.nitish.Audit_Authorization.Exception.ProjectManagerNotFoundException;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManager;
import com.cognizant.nitish.Audit_Authorization.repository.ProjectManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagerService {

    @Autowired
    private ProjectManagerRepo projectManagerRepo;


    public ProjectManager getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException {
        ProjectManager projectManager=null;
        projectManager=projectManagerRepo.getProjectManagerByUserName(username);
        if(projectManager==null){
            throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
        }
        return projectManager;
    }
}
