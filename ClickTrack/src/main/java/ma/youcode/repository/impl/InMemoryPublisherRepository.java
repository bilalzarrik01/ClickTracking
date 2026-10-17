package ma.youcode.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.model.Publicher;
import ma.youcode.model.Categorie;

import ma.youcode.repository.PublisherRepository;


public class InMemoryPublisherRepository  implements PublisherRepository{

    private final List<Publicher> publishers = new ArrayList<>();

    public InMemoryPublisherRepository(){
        publishers.add(new Publicher(1L, "bilal", "zarrik", "bilal@zarrik.com",Categorie.BLOGUEUR));
                publishers.add(new Publicher(2L, "Mohammed", "Allaoui", "mohammed6@maroc.ma",Categorie.INFLUENCEUR));

    }

    @Override
    public  List<Publicher> findAll() {
      
        return new ArrayList<>(publishers);
    }

    @Override
    public  Optional<Publicher> findById(Long id) { 

        return publishers.stream().filter(i->id.equals(i.getId())).findFirst();
    }

    @Override
    public void save(Publicher publicher) {
        publishers.add(publicher);
        
    }

    
    
}
