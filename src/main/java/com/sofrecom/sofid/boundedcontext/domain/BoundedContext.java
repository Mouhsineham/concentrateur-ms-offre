package com.sofrecom.sofid.boundedcontext.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @see <a href="https://smnomadg6.sofrecom.fr/sofid/sofid-wiki/wikis/nomad-msxx/boundedcontext/domain">BoundedContext</a>
 */
@Valid
@Slf4j
@Data
@Entity
@ToString(of = {"id","username"})
@Table(name = "boundedcontext")
public class BoundedContext implements Serializable {

    private static final long serialVersionUID = 8890163974066870179L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

}