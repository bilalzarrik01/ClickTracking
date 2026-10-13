package ma.youcode.service.impl;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Publicher;
import ma.youcode.repository.PublisherRepository;
import ma.youcode.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publicher> listerPublicher() {
        // TODO Auto-generated method stub
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publicher> trouveParId() {
        // TODO Auto-generated method stub
        return publisherRepository.findById(null);
    }

    
}
