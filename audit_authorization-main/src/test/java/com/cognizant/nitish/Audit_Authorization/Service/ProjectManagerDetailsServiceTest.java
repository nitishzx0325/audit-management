package com.cognizant.nitish.Audit_Authorization.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cognizant.nitish.Audit_Authorization.Exception.ProjectManagerNotFoundException;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManager;
import com.cognizant.nitish.Audit_Authorization.model.ProjectManagerDetails;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerDetailsService.class})
@ExtendWith(SpringExtension.class)
class ProjectManagerDetailsServiceTest {
    @Autowired
    private ProjectManagerDetailsService projectManagerDetailsService;

    @MockBean
    private ProjectManagerService projectManagerService;

    /**
     * Method under test: {@link ProjectManagerDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws ProjectManagerNotFoundException, UsernameNotFoundException {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setPassword("javapwd");
        projectManager.setProjectName("Project Name");
        projectManager.setUsername("janedoe");
        when(projectManagerService.getProjectManagerByUserName((String) any())).thenReturn(projectManager);
        ProjectManagerDetails actualLoadUserByUsernameResult = projectManagerDetailsService.loadUserByUsername("janedoe");
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("Project Name", actualLoadUserByUsernameResult.getProjectName());
        assertEquals("Name", actualLoadUserByUsernameResult.getName());
        verify(projectManagerService, atLeast(1)).getProjectManagerByUserName((String) any());
    }

    /**
     * Method under test: {@link ProjectManagerDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername2() throws ProjectManagerNotFoundException, UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.security.core.userdetails.UsernameNotFoundException: Msg
        //       at com.cognizant.nitish.Audit_Authorization.model.ProjectManagerDetails.<init>(ProjectManagerDetails.java:51)
        //       at com.cognizant.nitish.Audit_Authorization.Service.ProjectManagerDetailsService.loadUserByUsername(ProjectManagerDetailsService.java:31)
        //   In order to prevent loadUserByUsername(String)
        //   from throwing UsernameNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   loadUserByUsername(String).
        //   See https://diff.blue/R013 to resolve this issue.

        ProjectManager projectManager = mock(ProjectManager.class);
        when(projectManager.getProjectName()).thenThrow(new UsernameNotFoundException("Msg"));
        when(projectManager.getId()).thenReturn(1);
        when(projectManager.getName()).thenReturn("Name");
        when(projectManager.getPassword()).thenReturn("javapwd");
        when(projectManager.getUsername()).thenReturn("janedoe");
        doNothing().when(projectManager).setId(anyInt());
        doNothing().when(projectManager).setName((String) any());
        doNothing().when(projectManager).setPassword((String) any());
        doNothing().when(projectManager).setProjectName((String) any());
        doNothing().when(projectManager).setUsername((String) any());
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setPassword("javapwd");
        projectManager.setProjectName("Project Name");
        projectManager.setUsername("janedoe");
        when(projectManagerService.getProjectManagerByUserName((String) any())).thenReturn(projectManager);
        projectManagerDetailsService.loadUserByUsername("janedoe");
    }
}

