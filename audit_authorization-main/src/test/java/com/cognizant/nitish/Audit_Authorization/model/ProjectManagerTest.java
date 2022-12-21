package com.cognizant.nitish.Audit_Authorization.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProjectManagerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProjectManager#ProjectManager()}
     *   <li>{@link ProjectManager#setId(int)}
     *   <li>{@link ProjectManager#setName(String)}
     *   <li>{@link ProjectManager#setPassword(String)}
     *   <li>{@link ProjectManager#setProjectName(String)}
     *   <li>{@link ProjectManager#setUsername(String)}
     *   <li>{@link ProjectManager#toString()}
     *   <li>{@link ProjectManager#getId()}
     *   <li>{@link ProjectManager#getName()}
     *   <li>{@link ProjectManager#getPassword()}
     *   <li>{@link ProjectManager#getProjectName()}
     *   <li>{@link ProjectManager#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ProjectManager actualProjectManager = new ProjectManager();
        actualProjectManager.setId(1);
        actualProjectManager.setName("Name");
        actualProjectManager.setPassword("iloveyou");
        actualProjectManager.setProjectName("Project Name");
        actualProjectManager.setUsername("janedoe");
        String actualToStringResult = actualProjectManager.toString();
        assertEquals(1, actualProjectManager.getId());
        assertEquals("Name", actualProjectManager.getName());
        assertEquals("iloveyou", actualProjectManager.getPassword());
        assertEquals("Project Name", actualProjectManager.getProjectName());
        assertEquals("janedoe", actualProjectManager.getUsername());
        assertEquals("ProjectManager(id=1, name=Name, username=janedoe, password=iloveyou, projectName=Project Name)",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ProjectManager#ProjectManager(int, String, String, String, String)}
     *   <li>{@link ProjectManager#setId(int)}
     *   <li>{@link ProjectManager#setName(String)}
     *   <li>{@link ProjectManager#setPassword(String)}
     *   <li>{@link ProjectManager#setProjectName(String)}
     *   <li>{@link ProjectManager#setUsername(String)}
     *   <li>{@link ProjectManager#toString()}
     *   <li>{@link ProjectManager#getId()}
     *   <li>{@link ProjectManager#getName()}
     *   <li>{@link ProjectManager#getPassword()}
     *   <li>{@link ProjectManager#getProjectName()}
     *   <li>{@link ProjectManager#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ProjectManager actualProjectManager = new ProjectManager(1, "Name", "janedoe", "iloveyou", "Project Name");
        actualProjectManager.setId(1);
        actualProjectManager.setName("Name");
        actualProjectManager.setPassword("iloveyou");
        actualProjectManager.setProjectName("Project Name");
        actualProjectManager.setUsername("janedoe");
        String actualToStringResult = actualProjectManager.toString();
        assertEquals(1, actualProjectManager.getId());
        assertEquals("Name", actualProjectManager.getName());
        assertEquals("iloveyou", actualProjectManager.getPassword());
        assertEquals("Project Name", actualProjectManager.getProjectName());
        assertEquals("janedoe", actualProjectManager.getUsername());
        assertEquals("ProjectManager(id=1, name=Name, username=janedoe, password=iloveyou, projectName=Project Name)",
                actualToStringResult);
    }
}

