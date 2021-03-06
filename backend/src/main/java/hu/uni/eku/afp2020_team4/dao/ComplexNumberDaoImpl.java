package hu.uni.eku.afp2020_team4.dao;

import hu.uni.eku.afp2020_team4.model.ComplexNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ComplexNumberDaoImpl implements ComplexNumberDao {

    private final ComplexNumberRepository repository;

    @Override
    public void create(ComplexNumber complexNumber) {
        repository.save(ComplexNumberEntityModelConverter.model2entity(complexNumber));
    }

    @Override
    public Collection<ComplexNumber> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> ComplexNumberEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(ComplexNumber original, ComplexNumber updated) {

    }

    @Override
    public void delete(ComplexNumber complexNumber) {

    }

    private static class ComplexNumberEntityModelConverter{

        private static ComplexNumber entity2model(hu.uni.eku.afp2020_team4.dao.entity.ComplexNumber entity){
            return new ComplexNumber(
                    entity.getRealPart(),
                    entity.getImaginaryPart()
            );
        }

        private static hu.uni.eku.afp2020_team4.dao.entity.ComplexNumber model2entity(ComplexNumber model){
            return hu.uni.eku.afp2020_team4.dao.entity.ComplexNumber.builder()
                    .realPart(model.getReal())
                    .imaginaryPart(model.getImaginary())
                    .build();
        }

    }
}
