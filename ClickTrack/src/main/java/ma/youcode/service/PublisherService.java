package ma.youcode.service;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Publicher;

public interface PublisherService {

    List<Publicher> listerPublicher();
    Optional<Publicher> trouveParId();
    
}
