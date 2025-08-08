package com.coffeespace.repository;

import com.coffeespace.entity.ProfileEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileEducationRepository extends JpaRepository<ProfileEducation, Long> {}
