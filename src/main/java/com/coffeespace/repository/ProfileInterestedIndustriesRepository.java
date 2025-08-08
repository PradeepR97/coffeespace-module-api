package com.coffeespace.repository;

import com.coffeespace.entity.ProfileInterestedIndustries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileInterestedIndustriesRepository extends JpaRepository<ProfileInterestedIndustries, Long> {}
