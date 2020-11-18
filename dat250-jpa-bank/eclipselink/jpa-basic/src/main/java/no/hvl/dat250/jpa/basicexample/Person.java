package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;

import com.hazelcast.client.impl.connection.Addresses;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @ManyToMany
    private List<Address> addresses;

    @OneToMany
    private List<Kreditkort> creditCards;


    public Person() {
        Addresses = new ArrayList<>();
        creditCards = new ArrayList<>();
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    @Override
    public String toString() {
        String cards = "";
        for (CreditCard c : creditCards)
            cards += c.getNumber() + ", ";

        String addr = "";
        for (Address a : addresses)
            addr += a.getStreet() + " " + a.getNumber() + ", ";

        return "Person [name=" + name + ",\tcards=" + cards + "\taddresses=" + addr
                + "]";
    }
}



