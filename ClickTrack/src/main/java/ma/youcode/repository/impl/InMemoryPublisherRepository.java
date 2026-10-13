package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.model.Publicher;

import ma.youcode.repository.PublisherRepository;

public class InMemoryPublisherRepository  implements PublisherRepository{
    private final List<Publicher> publishers = new ArrayList<>();

    @Override
    public synchronized List<Publicher> findAll() {
      
        return publishers;
    }

    @Override
    public synchronized Optional<Publicher> findById(Long id) { 

        return publishers.stream().filter(i->id.equals(id)).findFirst();
    }

    @Override
    public synchronized void save(Publicher publicher) {
        publishers.add(publicher);
        
    }

    
    
}
