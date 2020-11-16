package hu.uni.eku.afp2020_team4.dao;

import hu.uni.eku.afp2020_team4.dao.entity.SlideUsage;
import org.springframework.data.repository.CrudRepository;

public interface SlideUsageRepository extends CrudRepository<SlideUsage, Integer> {
    SlideUsage findByUsageId(Integer usageId);
}