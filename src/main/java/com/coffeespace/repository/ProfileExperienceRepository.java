package com.coffeespace.repository;

import com.coffeespace.entity.ProfileExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileExperienceRepository extends JpaRepository<ProfileExperience, Long> {}
