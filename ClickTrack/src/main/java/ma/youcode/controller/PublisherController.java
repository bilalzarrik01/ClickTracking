package ma.youcode.controller;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Publisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ma.youcode.model.Publicher;
import ma.youcode.service.PublisherService;
import ma.youcode.model.Lien;
import ma.youcode.service.LienService;

@RestController
public class PublisherController {

    private final PublisherService publisherService;
    private final LienService lienService;

    public PublisherController(PublisherService publisherService, LienService lienService) {
        this.publisherService = publisherService;
        this.lienService = lienService;
    }

    @GetMapping("/api/publishers")

    public List<Publicher> getAllPublishers() {
        return publisherService.listerPublicher();

    }

    @GetMapping("/api/publishers/{id}")

    public ResponseEntity<Publicher> getPublusherById(@PathVariable("id") Long id) {
        Optional<Publicher> publisher = publisherService.trouveParId(id);
        if (publisher.isPresent()) {
            return ResponseEntity.ok(publisher.get());

        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/publishers/{id}/liens")
    public ResponseEntity<Lien> creeLien(@PathVariable("id") Long id,
            @RequestBody Lien lien) {

        Lien nouveauLien = lienService.creeLien(id, lien.getOffre(), lien.getUrlDestination());
        return ResponseEntity.status(201).body(nouveauLien);
    }


}
