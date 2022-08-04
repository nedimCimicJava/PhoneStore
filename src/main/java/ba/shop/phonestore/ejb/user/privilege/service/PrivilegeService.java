package ba.shop.phonestore.ejb.user.privilege.service;

import ba.shop.phonestore.ejb.service.AbstractService;
import ba.shop.phonestore.ejb.user.privilege.entity.Privilege;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Local
@Stateless
public class PrivilegeService extends AbstractService<Privilege> {

    @PersistenceContext(unitName = "phonestorePU")
    private EntityManager entityManager;

    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
