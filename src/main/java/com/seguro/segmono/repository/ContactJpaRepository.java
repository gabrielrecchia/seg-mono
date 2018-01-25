package com.seguro.segmono.repository;

import org.springframework.stereotype.Repository;

import com.seguro.segmono.entity.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("contactJpaRepository")
public interface ContactJpaRepository extends JpaRepository<Contact, Serializable> {

}
