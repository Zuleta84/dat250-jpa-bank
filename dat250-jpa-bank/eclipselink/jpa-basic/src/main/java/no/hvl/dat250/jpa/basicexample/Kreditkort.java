package no.hvl.dat250.jpa.basicexample;

import javax.persistence.*;

@Entity
public class Kreditkort {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private int number;
    private int limit;
    private int balance;
    
    @ManyToOne
    private Person person;

    @ManyToOne
    private Bank bank;

    @Embedded
    private Pinkode pincode;


    public void setperson(Person person){
        this.person = person;
    }

    public Person getperson(){
        return person;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public void setLimit(int limit){
        this.limit = limit;
    }

    public int getLimit(){
        return limit;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Pinkode getPincode() {
        return pincode;
    }

    public void setPincode(Pinkode pinkode) {
        this.pinkode = pinkode;
    }

	public void setCount(int i) {
	}

	public void setPincode(String string) {
	}
}
