package com.coffeespace.service;

import com.coffeespace.dto.ApiResponse;
import com.coffeespace.enums.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MetadataService {

    public ApiResponse<Map<String, Object>> getMetadata() {
        Map<String, Object> data = new LinkedHashMap<>();

        // 1. Goals
        data.put("goals", Map.of(
                "header", "Goal",
                "options", Arrays.stream(Goal.values())
                        .map(g -> Map.of("id", g.name(), "value", g.getValue()))
                        .collect(Collectors.toList())
        ));

        // 2. Working Status
        data.put("workingStatus", Map.of(
                "header", "When do you want to start working on a startup full-time?",
                "options", Arrays.stream(WorkingStatus.values())
                        .map(ws -> Map.of("id", ws.name(), "value", ws.getValue()))
                        .collect(Collectors.toList())
        ));

        // 3. Experience
        data.put("experience", Map.of(
                "header", "Do you have any prior startup experience?",
                "options", Arrays.stream(ExperienceType.values())
                        .map(exp -> Map.of("id", exp.name(), "value", exp.getValue()))
                        .collect(Collectors.toList())
        ));

        // 4. Skills
        data.put("skills", Map.of(
                "header", "Which of the following skills do you have?",
                "options", Arrays.stream(Skill.values())
                        .map(skill -> Map.of("id", skill.name(), "value", skill.getValue()))
                        .collect(Collectors.toList())
        ));

        // 5. Industries (Grouped)
        Map<String, List<Map<String, String>>> groupedIndustries = Arrays.stream(Industry.values())
                .collect(Collectors.groupingBy(
                        Industry::getGroup,
                        LinkedHashMap::new,
                        Collectors.mapping(
                                i -> Map.of("id", i.name(), "value", i.getValue()),
                                Collectors.toList()
                        )
                ));

        List<Map<String, Object>> industryGroups = groupedIndustries.entrySet().stream()
                .map(entry -> Map.of(
                        "subHeader", entry.getKey(),
                        "options", entry.getValue()
                ))
                .collect(Collectors.toList());

        data.put("industries", Map.of(
                "header", "Select up to 5 industries that interest you",
                "groups", industryGroups
        ));

        // ✅ Return standard API response
        return ApiResponse.<Map<String, Object>>builder()
                .message("MetaData fetched successfully")
                .statusCode(200)
                .success(true)
                .data(data)
                .build();
    }
}
