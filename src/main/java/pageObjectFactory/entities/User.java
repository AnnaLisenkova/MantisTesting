package pageObjectFactory.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by anna on 12.04.17.
 */

//@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    String login;
    String password;
}
