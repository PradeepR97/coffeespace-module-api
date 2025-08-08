package com.coffeespace.controller;

import com.coffeespace.dto.ApiResponse;
import com.coffeespace.service.MetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/metadata")
@RequiredArgsConstructor
public class MetadataController {

    private final MetadataService metadataService;

    @GetMapping
    public ResponseEntity<ApiResponse<Map<String, Object>>> getMetadata() {
        return ResponseEntity.ok(metadataService.getMetadata());
    }
}
