package com.cba.repository.repositoryImpl;

import com.cba.entities.Admin;
import com.cba.entities.TripBooking;
import com.cba.repository.IAdminRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

/*a specialization of the @Component annotation which indicates that an annotated class is a â€œRepositoryâ€�,
 *  which can be used as a mechanism for encapsulating storage, retrieval,
 *  and search behavior which emulates a collection of objects.
 */
@Repository

//@Transactional should be used on specific methods where it is actually needed, not on the entire class.
@Transactional
public class IAdminRepositoryImpl implements IAdminRepository {

    /*PersistenceContext annotation, which is used to inject an EntityManager object
     *and establish the scope of the injected object (e.g., a transaction).28
     */
    @PersistenceContext
    private EntityManager entityManager;
    /* An EntityManager object manages a set of entities that are defined by a persistence unit.
     *  Each EntityManager instance is associated with a persistence context.
     */

    //@Override annotation indicates that the child class method is over-writing its base class method
    @Override
    public Admin insertAdmin(Admin admin) {
        entityManager.merge(admin);
        return admin;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        entityManager.merge(admin);
        return admin;
    }

    @Override
    public Admin deleteAdmin(int adminId) {
        Admin emp = entityManager.find(Admin.class, adminId);
        entityManager.remove(emp);
        return emp;
    }

    @Override
    public List<TripBooking> getAllTrips(int customerId) {
        Query query = entityManager.createQuery("Select e from TripBooking e where e.customerId = :customerId");
        query.setParameter("customerId", customerId);
        List<TripBooking> q = query.getResultList();
        return q;

    }

    @Override
    public List<TripBooking> getTripsCabwise() {
        // TODO Auto-generated method stub
        Query query = entityManager.createQuery("Select e from TripBooking e group by driverId");
        List<TripBooking> q = query.getResultList();
        return q;
    }

    @Override
    public List<TripBooking> getTripsCustomerwise() {
        // TODO Auto-generated method stub
        Query query = entityManager.createQuery("Select e from TripBooking e group by customerId");
        List q = query.getResultList();
        return q;
    }

    @Override
    public List<TripBooking> getTripsDatewise() {
        // TODO Auto-generated method stub
        Query query = entityManager.createQuery("Select e from TripBooking e group by fromLocalDateTime");
        List<TripBooking> q = query.getResultList();
        return q;
    }

    //select m from PartnerData m where eventTimestamp >= :fromDatetime and eventTimestamp < :toDatetime"
    @Override
    public List<TripBooking> getAllTripsForDays(int customerid, LocalDateTime fromdate, LocalDateTime todate) {
        Query query = entityManager.createQuery("SELECT e FROM TripBooking e WHERE e.customerId = :customerId AND e.eventTimestamp >= :fromDatetime AND e.eventTimestamp < :toDatetime");
        query.setParameter("customerId", customerid);
        query.setParameter("fromDatetime", fromdate);
        query.setParameter("toDatetime", todate);
        List<TripBooking> q = query.getResultList();
        return q;
    }


}
