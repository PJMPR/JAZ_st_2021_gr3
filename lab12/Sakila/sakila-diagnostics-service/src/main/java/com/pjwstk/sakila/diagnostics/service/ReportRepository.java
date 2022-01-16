package com.pjwstk.sakila.diagnostics.service;

import com.pjwstk.sakila.diagnostics.service.model.ServiceInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ReportRepository extends JpaRepository<ServiceInformation, Long> {

}
