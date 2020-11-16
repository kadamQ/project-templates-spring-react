package hu.uni.eku.afp2020_team4.dao;

import hu.uni.eku.afp2020_team4.model.SlideUsage;

import java.util.Collection;

public interface SlideUsageDao {
    void create(SlideUsage usageToCreate);
    Collection<SlideUsage> fetchAll();
    void update(Integer usageId, SlideUsage updatedSlideUsage);
    void delete(Integer usageId);

}