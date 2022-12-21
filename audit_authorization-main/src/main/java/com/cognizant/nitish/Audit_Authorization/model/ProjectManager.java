package com.cognizant.nitish.Audit_Authorization.model;

import lombok.*;

import javax.persistence.*;


/*
 * this contains the data for the project manager
 * we are using the table project_manager the table is a H2 table and runs in runtime
 * id
 * name
 * username
 * password
 * projectname
 * we are using lombok for the boilerplate code
 */

@Getter
@Setter
@ToString

@Entity
@Table(name="project_manager")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    private String projectName;


}
