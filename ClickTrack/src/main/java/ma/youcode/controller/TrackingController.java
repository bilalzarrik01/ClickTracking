package ma.youcode.controller ;

import ma.youcode.model.Lien;
import ma.youcode.service.LienService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TrackingController{
    private LienService lienService ;

     public TrackingController(LienService lienService){
        this.lienService =lienService ;
     }

     @GetMapping("/t/{id}")
     public ResponseEntity<Lien> trackLien(@PathVariable("id") Long id){
        Optional<Lien>lien = lienService.enregistrerClick(id);
        if (lien.isPresent()) {
            return ResponseEntity.ok(lien.get());
        }
        return ResponseEntity.notFound().build();

     }



}
