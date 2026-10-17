package ma.youcode.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Publicher;

public interface PublisherRepository {

    List<Publicher> findAll();

    Optional<Publicher> findById(Long id);

    void save(Publicher publicher);

}
