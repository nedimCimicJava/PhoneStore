package ba.shop.phonestore.ejb.user.service;

import ba.shop.phonestore.controller.register.RegisterModel;
import ba.shop.phonestore.ejb.service.AbstractService;
import ba.shop.phonestore.ejb.user.entity.User;
import ba.shop.phonestore.ejb.user.privilege.entity.Privilege;
import ba.shop.phonestore.ejb.user.privilege.service.PrivilegeService;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.logging.Logger;

@Local
@Stateless
public class UserService extends AbstractService<User> {

    @PersistenceContext(unitName = "phonestorePU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash; //jakarta.security

    @Inject
    private PrivilegeService privilegeService;


    public UserService() {
        super(User.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     *
     * @param email
     * @param plainPassword
     * @return user or null, in case of incorrect email or password
     */

    public User login(String email, String plainPassword) {
        User user = findByEmailorNull(email);
        if (user != null && pbkdf2PasswordHash.verify(plainPassword.toCharArray(), user.getPassword())) {
            return user;
        }
        return null;
    }

    public User findByEmailorNull(String email){
        Query query = getEntityManager().createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        try {
            return (User) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Not exist user or not unique: " + e.getMessage());
            return null;
        }
    }

    public User register(RegisterModel registerModel) {
        User user = new User();
        user.setFirstName(registerModel.getFirstName());
        user.setLastName(registerModel.getLastName());
        user.setEmail(registerModel.getEmail());
        String hashedPass = pbkdf2PasswordHash.generate(registerModel.getPlainPassword().toCharArray());
        user.setPassword(hashedPass);

        Privilege clientPrivilege = privilegeService.find(Privilege.CLIENT_PRIVILEGE_ID);
        user.setPrivilege(clientPrivilege);
        create(user);//getEntityManager.persist(user);
        return user;
    }
}
