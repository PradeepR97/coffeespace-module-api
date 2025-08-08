package com.coffeespace.service;

import com.coffeespace.dto.*;
import com.coffeespace.entity.*;
import com.coffeespace.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final ProfileRepository profileRepo;
    private final ProfileAdditionalInfoRepository additionalInfoRepo;
    private final ProfileSkillSetRepository skillRepo;
    private final ProfileInterestedIndustriesRepository industryRepo;
    private final ProfileExperienceRepository experienceRepo;
    private final ProfileEducationRepository educationRepo;

    @Transactional
    public RegisterResponse register(RegisterRequest req) {
        // === 1. Basic Validation ===
        if (req.getEmail() == null || req.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        profileRepo.findByEmail(req.getEmail()).ifPresent(p -> {
            throw new IllegalArgumentException("Email already registered");
        });

        // === 2. Save Profile ===
        Profile profile = new Profile();
        profile.setFirstname(req.getFirstName());
        profile.setLastname(req.getLastName());
        profile.setEmail(req.getEmail());
        profile = profileRepo.save(profile);
        Long pid = profile.getId();

        // === 3. Save Additional Info ===
        ProfileAdditionalInfo info = new ProfileAdditionalInfo();
        info.setProfileid(pid);
        info.setGoal(req.getGoal());
        info.setExperience(req.getExperience());
        info.setLinkedinProfileUrl(req.getLinkedInProfileUrl());
        info.setLinkedinName(req.getLinkedInName());
        info.setLinkedInSummary(req.getLinkedInSummary());
        info.setLinkedInConnectionsCount(req.getLinkedInConnectionsCount());
        if (req.getPriorities() != null && !req.getPriorities().isEmpty()) {
            info.setPriorities(String.join(",", req.getPriorities()));
        }
        additionalInfoRepo.save(info);

        // === 4. Save Skills ===
        ProfileSkillSet skillSet = new ProfileSkillSet();
        skillSet.setProfileid(pid);
        fillSkillSlots(skillSet, req.getSkills());
        skillRepo.save(skillSet);

        // === 5. Save Industries ===
        ProfileInterestedIndustries industries = new ProfileInterestedIndustries();
        industries.setProfileid(pid);
        fillInterestSlots(industries, req.getIndustries());
        industryRepo.save(industries);

        // === 6. Save LinkedIn Experience ===
        if (req.getLinkedInExperience() != null) {
            for (LinkedInExperienceDTO e : req.getLinkedInExperience()) {
                ProfileExperience pe = new ProfileExperience();
                pe.setProfileid(pid);
                pe.setRole(e.getTitle());
                pe.setCompany(e.getCompany());
                pe.setStartdate(e.getStartDate());
                pe.setEnddate(e.getEndDate());
                pe.setLocation(e.getLocation());

                experienceRepo.save(pe);
            }
        }

        // === 7. Save LinkedIn Education ===
        if (req.getLinkedInEducation() != null) {
            for (LinkedInEducationDTO ed : req.getLinkedInEducation()) {
                ProfileEducation pe = new ProfileEducation();
                pe.setProfileid(pid);
                pe.setInstitutename(ed.getInstitutionName());
                pe.setDepartment(ed.getFieldOfStudy());
                pe.setDegree(ed.getDegree());
                pe.setStartdate(ed.getStartYear() != null ? ed.getStartYear().toString() : null);
                pe.setEnddate(ed.getEndYear() != null ? ed.getEndYear().toString() : null);
                educationRepo.save(pe);
            }
        }

        // === 8. Build Response ===
        LinkedInResponse linkedInResponse = LinkedInResponse.builder()
                .profileUrl(info.getLinkedinProfileUrl())
                .name(info.getLinkedinName())
                .summary(info.getLinkedInSummary())
                .connectionsCount(info.getLinkedInConnectionsCount())
                .experience(req.getLinkedInExperience())
                .education(req.getLinkedInEducation())
                .skills(req.getLinkedInSkills())
                .build();

        return RegisterResponse.builder()
                .userId(pid.toString())
                .firstName(profile.getFirstname())
                .lastName(profile.getLastname())
                .email(profile.getEmail())
                .goal(info.getGoal())
                .priorities(req.getPriorities())
                .experience(info.getExperience())
                .skills(req.getSkills())
                .industries(req.getIndustries())
                .linkedIn(linkedInResponse)
                .build();
    }

    private void fillSkillSlots(ProfileSkillSet s, List<String> skills) {
        if (skills == null) return;
        for (int i = 0; i < Math.min(5, skills.size()); i++) {
            String v = StringUtils.trimWhitespace(skills.get(i));
            switch (i) {
                case 0 -> s.setSkill1(v);
                case 1 -> s.setSkill2(v);
                case 2 -> s.setSkill3(v);
                case 3 -> s.setSkill4(v);
                case 4 -> s.setSkill5(v);
            }
        }
    }

    private void fillInterestSlots(ProfileInterestedIndustries ind, List<String> interests) {
        if (interests == null) return;
        for (int i = 0; i < Math.min(5, interests.size()); i++) {
            String v = StringUtils.trimWhitespace(interests.get(i));
            switch (i) {
                case 0 -> ind.setInterest1(v);
                case 1 -> ind.setInterest2(v);
                case 2 -> ind.setInterest3(v);
                case 3 -> ind.setInterest4(v);
                case 4 -> ind.setInterest5(v);
            }
        }
    }
}
