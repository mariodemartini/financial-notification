package br.com.geradordedevs.financialnotification.repositories;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpreadSheetRepository extends CrudRepository<SpreadSheetEntity, Long> {

}
