package hu.uni.eku.afp2020_team4.service;

import hu.uni.eku.afp2020_team4.model.SlideUsage;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageAlreadyExistsException;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageNotFoundException;

import java.util.Collection;

public interface SlideUsageService {
    void create(SlideUsage slideUsage) throws SlideUsageAlreadyExistsException;
    Collection<SlideUsage> fetchAll();
    void update(Integer usageId, SlideUsage updatedSlideUsage) throws SlideUsageNotFoundException;
    void delete(Integer SlideUsageId) throws SlideUsageNotFoundException;
}