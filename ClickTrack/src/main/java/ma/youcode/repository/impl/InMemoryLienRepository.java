package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.model.Lien;
import ma.youcode.repository.LienRepository;

public class InMemoryLienRepository implements LienRepository {
    private final List<Lien> liens = new ArrayList<>();

    @Override
    public synchronized void save(Lien lien) {
        liens.add(lien);
    }

    @Override
    public synchronized Optional<Lien> findById(Long id) {
        return liens.stream().filter(i -> id.equals(id)).findFirst();
    }

     @Override
    public synchronized List<Lien> findByPublisher(Long publisherId) {
        return liens.stream()
                .filter(l -> publisherId.equals(l.getPublisherId()))
                .toList();
                
    }

}
