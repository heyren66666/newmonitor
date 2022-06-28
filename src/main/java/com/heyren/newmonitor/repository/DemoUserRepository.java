package com.heyren.newmonitor.repository;

import com.heyren.newmonitor.entity.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUser,Integer>{
}
