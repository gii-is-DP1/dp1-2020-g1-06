package org.springframework.samples.petclinic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

    @Data
    @Entity
    @Table(name = "cuenta")
    public class UserAccount {

        @Id
        String username;

        String password;

        boolean enabled;

    }
