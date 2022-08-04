package ba.shop.phonestore.ejb.products.service;

import ba.shop.phonestore.ejb.products.entity.Products;
import ba.shop.phonestore.ejb.service.AbstractService;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Local
@Stateless
public class ProductService extends AbstractService<Products> {

    @PersistenceContext(unitName = "phonestorePU")
    private EntityManager entityManager;

    public ProductService() {
        super(Products.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
