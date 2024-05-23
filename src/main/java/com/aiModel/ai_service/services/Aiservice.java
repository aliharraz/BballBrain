package com.aiModel.ai_service.services;

import com.aiModel.ai_service.model.Statistics;
import com.aiModel.ai_service.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class Aiservice {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StatisticsRepository statisticsRepository;

    private final String staticVideoUrl = "C:\\Users\\marou\\Downloads\\kyle-korvers-11-points-in-one-minute-scorches-bucks.mp4";
    private final String aiModelApiUrl = "http://localhost:5000/api/analyze";

    public void generateStatistics() {
        String[] statisticsArray = restTemplate.postForObject(aiModelApiUrl, staticVideoUrl, String[].class);

        if (statisticsArray != null) {
            Statistics statistics = new Statistics();
            statistics.setVideoId(staticVideoUrl);
            statistics.setAnalysisResult(Collections.singletonList(String.join(",", statisticsArray)));
            statisticsRepository.save(statistics);
        }
    }

    public Statistics getStatistics(Long id) {
        return statisticsRepository.findById(id).orElse(null);
    }

    public Statistics getLastStatistics() {
        return statisticsRepository.findTopByOrderByIdDesc();
    }
}
