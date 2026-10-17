package ma.youcode.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.Map;

import ma.youcode.model.Lien;
import ma.youcode.repository.LienRepository;
import ma.youcode.repository.PublisherRepository;
import ma.youcode.service.LienService;

public class LienServiceImpl implements LienService {

    private final PublisherRepository publisherRepository;
    private final LienRepository lienRepository;
    private final AtomicLong sequence = new AtomicLong(0);

    public LienServiceImpl(PublisherRepository publisherRepository, LienRepository lienRepository) {
        this.publisherRepository = publisherRepository;
        this.lienRepository = lienRepository;
    }

    @Override
    public Lien creeLien(Long publisherId, String offre, String urlDestination) {

        if (publisherRepository.findById(publisherId).isEmpty()) {
            throw new IllegalArgumentException(
                    "Publisher introuvable : " + publisherId);
        }

        Long id = sequence.incrementAndGet();
        Lien lien = new Lien(
                id,
                offre,
                urlDestination,
                publisherId);
        lienRepository.save(lien);
        return lien;
    }

    @Override
    public Optional<Lien> enregistrerClick(Long lienId) {

        Optional<Lien> lien = lienRepository.findById(lienId);
        lien.ifPresent(Lien::incrementerClicks);

        return lien;
    }

    @Override
    public List<Lien> listerPublicher(Long publisherId) {

        return lienRepository.findByPublisher(publisherId);
    }
    @Override 
     public Map<String, Long> statistiquesParOffre(Long publisherId){
     List<Lien> liens =lienRepository.findByPublisher(publisherId) ;
     System.out.println("Nombre de liens pour publisher " + publisherId + " : " + liens.size());

       Map<String ,Long> stats= liens.stream().collect(Collectors.groupingBy(Lien::getOffre ,Collectors.summingLong(Lien::getClicks)));

     return  stats ;
    }
    

}
