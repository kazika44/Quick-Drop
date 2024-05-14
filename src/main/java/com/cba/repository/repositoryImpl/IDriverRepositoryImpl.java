package com.cba.repository.repositoryImpl;

import java.util.List;



import com.cba.repository.IDriverRepository;
import com.cba.entities.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

/*a specialization of the @Component annotation which indicates that an annotated class is a â€œRepositoryâ€�,
 *  which can be used as a mechanism for encapsulating storage, retrieval,
 *  and search behavior which emulates a collection of objects.
 */
@Repository

//@Transactional should be used on specific methods where it is actually needed, not on the entire class.
@Transactional

public class IDriverRepositoryImpl implements IDriverRepository {
    /*PersistenceContext annotation, which is used to inject an EntityManager object
     *and establish the scope of the injected object (e.g., a transaction).28
     */
    @PersistenceContext
    private EntityManager entityManager;
    /* An EntityManager object manages a set of entities that are defined by a persistence unit.
     *  Each EntityManager instance is associated with a persistence context.
     */

    @Override
    public Driver insertDriver(Driver driver) {

        return entityManager.merge(driver);
    }

    //@Override
    //public Driver findDriverById(int driverId) {
    //return entityManager.find(Driver.class,driverId);
    //}


    @Override
    public Driver updateDriver(Driver driver) {
        return entityManager.merge(driver);

    }

    @Override
    public Driver deleteDriver(int driverId) {
        Driver driver = entityManager.find(Driver.class, driverId);
        entityManager.remove(driverId);
        return driver;
    }

    @Override
    public Driver viewDriver(int driverId) {
        Driver driver = entityManager.find(Driver.class, driverId);
        return driver;
    }


    @Override
    public List<Driver> viewBestDrivers() {
        // TODO Auto-generated method stub
        Query q = entityManager.createQuery("select e from Driver e where e.rating>4.5");
        List<Driver> list = q.getResultList();
        return list;
    }
}

