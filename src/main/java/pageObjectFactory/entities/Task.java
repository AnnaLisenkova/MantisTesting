package pageObjectFactory.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by anna on 12.04.17.
 */

@Setter
@AllArgsConstructor
@Getter
public class Task {
    String summary;
    String description;
}
