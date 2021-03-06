package hu.uni.eku.afp2020_team4.dao;

import hu.uni.eku.afp2020_team4.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class WatchDaoImpl implements WatchDao {

    private final WatchRepository repository;

    @Override
    public void create(Watch watch) {
        repository.save(WatchEntityModelConverter.model2entity(watch));
    }

    @Override
    public Collection<Watch> fetchAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(entity -> WatchEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(String watchId, Watch newWatch) {
        hu.uni.eku.afp2020_team4.dao.entity.Watch toUpdate = repository.findByWatchId(watchId);
        toUpdate.setWatchId(newWatch.getWatchId());
        repository.save(toUpdate);
    }

    @Override
    public void delete(String watchId) {
        hu.uni.eku.afp2020_team4.dao.entity.Watch result = repository.findByWatchId(watchId);
        if(result != null)
            repository.delete(result);
    }

    private static class WatchEntityModelConverter {
        private static Watch entity2model(hu.uni.eku.afp2020_team4.dao.entity.Watch entity){
            return new Watch(entity.getWatchId());
        }

        private static hu.uni.eku.afp2020_team4.dao.entity.Watch model2entity(Watch model) {
            return hu.uni.eku.afp2020_team4.dao.entity.Watch.builder()
                    .watchId(model.getWatchId())
                    .build();
        }
    }
}
