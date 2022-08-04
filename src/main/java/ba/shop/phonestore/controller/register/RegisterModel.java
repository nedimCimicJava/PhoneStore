package ba.shop.phonestore.controller.register;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterModel {

    private String firstName;
    private String lastName;
    private String email;
    private String plainPassword;
}
