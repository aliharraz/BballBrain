package com.aiModel.ai_service.controllers;

import com.aiModel.ai_service.model.Statistics;
import com.aiModel.ai_service.services.Aiservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/statistics")
public class AiController {

    @Autowired
    private Aiservice aiService;

    @PostMapping("/analyze")
    public Statistics analyzeVideo() {
        aiService.generateStatistics();
        return aiService.getLastStatistics();
    }

    @GetMapping("/{id}")
    public Statistics getStatistics(@PathVariable Long id) {
        return aiService.getStatistics(id);
    }
}
