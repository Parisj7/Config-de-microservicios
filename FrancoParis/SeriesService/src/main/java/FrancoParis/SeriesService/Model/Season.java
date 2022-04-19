package FrancoParis.SeriesService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Season {

    private Integer id;
    private Integer seasonNumber;
    private List<Chapter> chapters;
}
