package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import okhttp3.Address;
import scala.util.Random;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList)
            System.out.println(person);

        System.out.println("Size: " + personList.size());

        // create new person with sone data
        Adress address = new Address();
        Person person = new Person();
        Kreditkort creditCard = new Kreditkort();
        Bank bank = new Bank();
        Pinkode pincode = new Pinkode();

        Kreditkort pinkode;
        pinkode.setPincode("5678");
        pinkode.setCount(5);

        Random rand = new Random();
        address.setNumber(rand.nextInt(50) + 100);
        address.setStreet("Nordre Toppe 35");
        address.addPerson(person);

        person.addAddress(address);
        person.setName("Emilia");
        person.addCreditCard(creditCard);

        creditCard.setBalance(10000);
        creditCard.setLimit(1000000000);
        creditCard.setNumber(12341234);
        creditCard.setBank(bank);
        creditCard.setPincode(pincode);

        bank.addCreditCard(creditCard);
        bank.setName("Sparebaken Vest");

        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard);
        em.persist(bank);

        em.getTransaction().commit();
        em.close();
    }
}

