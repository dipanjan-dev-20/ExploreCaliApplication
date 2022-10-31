package com.example.ec.exploreali.service;

import com.example.ec.exploreali.domain.Difficulty;
import com.example.ec.exploreali.domain.Region;
import com.example.ec.exploreali.domain.Tour;
import com.example.ec.exploreali.domain.TourPackage;
import com.example.ec.exploreali.repo.TourPackageRepository;
import com.example.ec.exploreali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }


    public Tour createTour(String title, String desc, String blurb,
                           Integer price, String duration, String bullets,
                           String keyword, String tourPackageName,
                           Difficulty difficulty, Region region
    ) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(() -> new RuntimeException("Tour package does not exist"));

        return tourRepository.save(new Tour(title, desc, blurb, price, duration, bullets, keyword, tourPackage, difficulty, region));
    }

    public long total() {
        return tourRepository.count();
    }
}
