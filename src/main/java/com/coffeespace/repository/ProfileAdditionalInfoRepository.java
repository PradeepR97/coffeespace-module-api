package com.coffeespace.repository;

import com.coffeespace.entity.ProfileAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileAdditionalInfoRepository extends JpaRepository<ProfileAdditionalInfo, Long> {}
