package ma.youcode.service;

import java.util.List;
import java.util.Optional;

import ma.youcode.model.Lien;

public interface LienService {

    Lien creeLien(Long publisherId, String offre, String urlDestination);

    List<Lien> listerPublicher(Long publisherId);

    Optional<Lien> enregistrerClick(Long lienId);

}