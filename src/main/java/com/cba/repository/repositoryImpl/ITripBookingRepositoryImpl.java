package com.cba.repository.repositoryImpl;

import java.util.List;



import com.cba.repository.ITripBookingRepository;
import com.cba.entities.TripBooking;
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
public class ITripBookingRepositoryImpl implements ITripBookingRepository {

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
    public void insertTripBooking(TripBooking pro) {
        entityManager.merge(pro);
    }

    @Override
    public List<TripBooking> ViewAllTripsCustomer(int id) {
        Query query = entityManager.createQuery("Select e from TripBooking e where e.customerId = :customerId");
        query.setParameter("customerId", id);
        List<TripBooking> q = query.getResultList();
        return q;
    }

    @Override
    public TripBooking updateTripBooking(TripBooking booking) {
        // TODO Auto-generated method stub
//		TripBooking book=entityManager.find(TripBooking.class,booking.getTripBookingId());
//		book.setBill(booking.getBill());
//		book.setDistanceInKm(booking.getDistanceInKm());
//		book.setDriverId(booking.getDriverId());
//		book.setFromLocalDateTime(booking.getFromLocalDateTime());
//		book.setFromLocation(booking.getFromLocation());
//		book.setStatus(booking.getStatus());
//		book.setToLocalDateTime(booking.getToLocalDateTime());
//		book.setToLocation(booking.getToLocation());
//		book.setCustomerId(booking.getCustomerId());
        entityManager.merge(booking);
        return booking;
    }

    @Override
    public String deleteTripBooking(int id) {
        TripBooking emp = entityManager.find(TripBooking.class, id);
        entityManager.remove(emp);

        return "Trip Deleted";
    }

    @Override
    public float calculateBill(int id) {
        Query query = entityManager.createQuery("Select sum(e.bill) from TripBooking e where e.customerId = :customerId");
        query.setParameter("customerId", id);
        System.out.println();
        try {
            Object a = query.getSingleResult();
            a.toString();
            float f = Float.parseFloat(a.toString());
            return f;
        } catch (Exception e) {
            System.out.println(e);
        }
        return (float) 0.0;
    }

}
