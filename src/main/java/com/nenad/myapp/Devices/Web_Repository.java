package com.nenad.myapp.Devices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Web_Repository extends JpaRepository<web, Long> {

}
