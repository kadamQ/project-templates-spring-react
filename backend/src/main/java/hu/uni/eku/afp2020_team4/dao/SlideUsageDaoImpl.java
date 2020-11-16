package hu.uni.eku.afp2020_team4.dao;


import hu.uni.eku.afp2020_team4.model.SlideUsage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SlideUsageDaoImpl implements SlideUsageDao {

    private final SlideUsageRepository repository;

    @Override
    public void create(SlideUsage slideUsage){
        repository.save(SlideUsageEntityModelConverter.model2entity(slideUsage));
    }

    @Override
    public Collection<SlideUsage> fetchAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> SlideUsageEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer usageId, SlideUsage updatedSlideUsage){
        hu.uni.eku.afp2020_team4.dao.entity.SlideUsage toUpdate = repository.findByUsageId(usageId);
        toUpdate.setUsageId(updatedSlideUsage.getUsageId());
        repository.save(toUpdate);
    }

    @Override
    public void delete(Integer usageId) {
        hu.uni.eku.afp2020_team4.dao.entity.SlideUsage result = repository.findByUsageId(usageId);
        if (result != null)
            repository.delete(result);
    }


    private static class SlideUsageEntityModelConverter {
        private static SlideUsage entity2model(hu.uni.eku.afp2020_team4.dao.entity.SlideUsage entity) {
            return new SlideUsage(entity.getUsageId(), entity.getUserId(), entity.getSlideId(), entity.getTimestamp());
        }

        private static hu.uni.eku.afp2020_team4.dao.entity.SlideUsage model2entity (SlideUsage model) {
            return hu.uni.eku.afp2020_team4.dao.entity.SlideUsage.builder()
                    .usageId(model.getUsageId())
                    .userId(model.getUserId())
                    .slideId(model.getSlideId())
                    .timestamp(model.getTimestamp())
                    .build();
        }
    }
}