package onetomany_manytoone_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_manytoone_bi.dto.BankAccount;
import onetomany_manytoone_bi.dto.Person;

public class Main {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setName("Sujit");
		p.setPhone(9876545);
		p.setAddress("Latur");
		
		
		BankAccount a = new BankAccount();
		a.setName("HDFC");
		a.setIfsc("12H34DFC");
		a.setBalance(12000.00);
		a.setP(p);
		
		BankAccount a1 = new BankAccount();
		a1.setName("IDFC");
		a1.setIfsc("12I34DFC");
		a1.setBalance(1000.00);
		a1.setP(p);
		
		BankAccount a2 = new BankAccount();
		a2.setName("SBI");
		a2.setIfsc("12S34BI");
		a2.setBalance(13000.00);
		a2.setP(p);
		
		BankAccount a3 = new BankAccount();
		a3.setName("Kotak");
		a3.setIfsc("12ko34tak");
		a3.setBalance(15000.00);
		a3.setP(p);
		
		List<BankAccount> list = new ArrayList<BankAccount>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		p.setAccount(list);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sujit");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(p);
		manager.persist(a);
		manager.persist(a1);
		manager.persist(a2);
		manager.persist(a3);
		transaction.commit();

	}

}
