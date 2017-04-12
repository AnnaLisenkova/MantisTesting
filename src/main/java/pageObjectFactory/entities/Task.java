package pageObjectFactory.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by anna on 12.04.17.
 */

@Setter
@AllArgsConstructor
public class Task {
    String summary;
    String description;

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }
}
