package com.pjwstk.sakila.diagnostics.service.repositories;

import com.pjwstk.sakila.diagnostics.service.monitor.ServiceData;
import com.pjwstk.sakila.diagnostics.service.model.ServiceInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MonitoringRepository extends JpaRepository<ServiceInformation, Integer> {

}