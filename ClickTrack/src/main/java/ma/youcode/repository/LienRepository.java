package ma.youcode.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Lien;

public interface LienRepository {

    void save(Lien line);

    Optional<Lien> findById(Long id);

    List<Lien> findByPublisher(Long PublisherId);

}
