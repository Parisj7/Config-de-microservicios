package FrancoParis.SeriesService.Controller;

import FrancoParis.SeriesService.Model.Serie;
import FrancoParis.SeriesService.Service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<Serie>> findAllSerie(){
        return ResponseEntity.ok().body(serieService.getAllSeries());
    }

    @GetMapping("{genre}")
    public ResponseEntity<?> findAllByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }

    @PostMapping("save")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        return ResponseEntity.ok().body(serieService.saveSerie(serie));
    }
}