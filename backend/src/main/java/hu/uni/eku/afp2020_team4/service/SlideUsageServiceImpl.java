package hu.uni.eku.afp2020_team4.service;

import hu.uni.eku.afp2020_team4.dao.SlideUsageDao;
import hu.uni.eku.afp2020_team4.model.SlideUsage;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageAlreadyExistsException;
import hu.uni.eku.afp2020_team4.service.exceptions.SlideUsageNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlideUsageServiceImpl implements SlideUsageService {
    private final SlideUsageDao dao;

    @Override
    public void create(SlideUsage slideUsage) throws SlideUsageAlreadyExistsException {
        final boolean alreadyExists = dao.fetchAll()
            .stream()
            .anyMatch(slideUsage1 -> slideUsage1.getUsageId() == slideUsage.getUsageId());
        if(alreadyExists){
            throw new SlideUsageAlreadyExistsException(String.format("Slide usage (%s) already exists!", slideUsage.toString()));
        }

        dao.create(slideUsage);
    }

    @Override
    public Collection<SlideUsage> fetchAll(){
        return dao.fetchAll();
    }

    @Override
    public void update(Integer usageId, SlideUsage updatedSlideUsage) throws SlideUsageNotFoundException{
        dao.update(usageId, updatedSlideUsage);
    }

    @Override
    public void delete(Integer slideUsageId) throws SlideUsageNotFoundException {
        dao.delete(slideUsageId);
    }

}


