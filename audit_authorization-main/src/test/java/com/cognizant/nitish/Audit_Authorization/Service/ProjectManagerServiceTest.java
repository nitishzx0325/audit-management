package com.cognizant.nitish.Audit_Authorization.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.Audit_Authorization.Exception.ProjectManagerNotFoundException;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManager;
import com.cognizant.nitish.Audit_Authorization.repository.ProjectManagerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerService.class})
@ExtendWith(SpringExtension.class)
class ProjectManagerServiceTest {
    @MockBean
    private ProjectManagerRepo projectManagerRepo;

    @Autowired
    private ProjectManagerService projectManagerService;

    /**
     * Method under test: {@link ProjectManagerService#getProjectManagerByUserName(String)}
     */
    @Test
    void testGetProjectManagerByUserName() throws ProjectManagerNotFoundException {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setPassword("javapwd");
        projectManager.setProjectName("Project Name");
        projectManager.setUsername("janedoe");
        when(projectManagerRepo.getProjectManagerByUserName((String) any())).thenReturn(projectManager);
        assertSame(projectManager, projectManagerService.getProjectManagerByUserName("janedoe"));
        verify(projectManagerRepo).getProjectManagerByUserName((String) any());
    }

    /**
     * Method under test: {@link ProjectManagerService#getProjectManagerByUserName(String)}
     */
    @Test
    void testGetProjectManagerByUserName2() throws ProjectManagerNotFoundException {
        when(projectManagerRepo.getProjectManagerByUserName((String) any()))
                .thenThrow(new ProjectManagerNotFoundException("An error occurred"));
        assertThrows(ProjectManagerNotFoundException.class,
                () -> projectManagerService.getProjectManagerByUserName("janedoe"));
        verify(projectManagerRepo).getProjectManagerByUserName((String) any());
    }
}

