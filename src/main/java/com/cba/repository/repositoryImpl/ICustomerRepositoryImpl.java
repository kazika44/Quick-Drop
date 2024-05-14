package com.cba.repository.repositoryImpl;

import java.util.List;


import com.cba.entities.ConfirmationToken;
import com.cba.repository.ICustomerRepository;
import com.cba.entities.Customer;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

//import com.corejava.entity.Customer;

/*Annotate all our DAO classes with @Repository.all our database access logic should be in Repository
 classes.*/
@AllArgsConstructor
@NoArgsConstructor
@Repository
/*configure our transactions with @Transactional spring annotation*/
@Transactional
public class ICustomerRepositoryImpl implements ICustomerRepository{
    /*Expresses a dependency on a  container managed  EntityManager

  Within the persistence context, the entity instances and their lifecycle are managed.
   The EntityManager API is used to create and remove persistent entity instances, to find
   entities by their primary key, and to query over entities*/

    @PersistenceContext
    /*This EntityManager manages entities (customer bean is defined as an entity)*/
    private EntityManager entityManager;


    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public ICustomerRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    /*@Override annotation assures that the subclass method is overriding the parent class method*/
    @Override
    public Customer insertCustomer(Customer customer) {
        return entityManager.merge(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Customer updatedCustomer = entityManager.find(Customer.class, customer.getCustomerId());

            if (customer != null) {
                // Update customer data
                customer.setEnabled(true);

                // No need to explicitly call merge since the customer is managed
                // and changes will be automatically persisted during transaction commit
            }
            customer=updatedCustomer;
            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

            entityManager.close();
        }
        return customer;

    }


    @Override
    public Customer deleteCustomer(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        entityManager.remove(customer);
        return customer;

    }

    @Override
    public List<Customer> viewCustomers() {
        Query q = entityManager.createQuery("select e from Customer  e");
        List<Customer> list = q.getResultList();

        return list;
    }

    @Override
    public Customer viewCustomer(int customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        return customer;
    }

    @Override
    public Customer validateCustomer(String username, String password) {

        Query q = entityManager.createQuery("select e from Customer e where e.username=:customerId");
        q.setParameter("customerId", username);
        Customer customer = (Customer) q.getSingleResult();
        System.out.println(customer.toString());
        if (customer != null) {
            if (password == customer.getPassword()) {
                return customer;
            }

        }
        return null;
    }
    @Override
    public Customer findByUserEmailIgnoreCase(String email)
    {
        return entityManager.find(Customer.class,email);
    }

    public boolean existsByUserEmail(String email) {
        Query q = entityManager.createQuery("SELECT COUNT(e) > 0 FROM Customer e WHERE e.email = :email");
        q.setParameter("email", email);

        try {
            return (Boolean) q.getSingleResult();
        } catch (NoResultException e) {
            return false; // No result means the email doesn't exist
        }
    }

//    @Override
//    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
//        try {
//            Query query = entityManager.createQuery("SELECT c FROM ConfirmationToken c WHERE c.confirmation_Token = :token");
//            query.setParameter("token", confirmationToken);
//            return (ConfirmationToken) query.getSingleResult();
//        } catch (NoResultException e) {
//            return null; // Token not found
//        }
//    }

}
	
	
	
	
	