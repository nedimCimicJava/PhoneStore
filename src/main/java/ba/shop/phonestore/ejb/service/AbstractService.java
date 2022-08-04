package ba.shop.phonestore.ejb.service;
//treba ponoviti data access oko 1:10
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public abstract class AbstractService <E>{

    private Class<E> entityClass;

    public AbstractService(Class<E> entityClass){
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    //Create
    public void create(E entity){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<E>> constraintViolations = validator.validate(entity);
        if(constraintViolations.size() > 0){
            Iterator<ConstraintViolation<E>> iterator = constraintViolations.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<E> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());

                System.err.println(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            }
        }else{
            getEntityManager().persist(entity);
        }
    }

    //Retrieve -> by id -> all
    public E find(Object id){
        return getEntityManager().find(entityClass, id);
    }

    public List<E> findAll(){
        //CriteriaQuery -> not NamedQuery
        CriteriaQuery<E> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    //Update
    public void update(E entity){
        getEntityManager().merge(entity);
    }

    //Delete
    public void delete(E entity){
        getEntityManager().remove(entity);
    }
}
