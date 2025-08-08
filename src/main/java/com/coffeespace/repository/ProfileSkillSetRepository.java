package com.coffeespace.repository;

import com.coffeespace.entity.ProfileSkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileSkillSetRepository extends JpaRepository<ProfileSkillSet, Long> {}
