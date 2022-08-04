package ba.shop.phonestore.controller.register;


import ba.shop.phonestore.ejb.user.entity.User;
import ba.shop.phonestore.ejb.user.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterController {

    private final UserService userService;
    private final RegisterModel registerModel;

    public boolean isEmailOccupied(){
        User user = userService.findByEmailorNull(registerModel.getEmail());
        return user != null;
    }

    public boolean isValidRegisterModel(){
        return !registerModel.getFirstName().isEmpty()
                && !registerModel.getLastName().isEmpty()
                && !registerModel.getEmail().isEmpty()
                && !registerModel.getPlainPassword().isEmpty();
    }
}
