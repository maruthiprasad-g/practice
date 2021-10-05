package hiber;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateByDynamic {
  public static void main(String[] args) {
	  Scanner scan=new Scanner(System.in);
	  System.out.println("enter your id:");
	  int id=scan.nextInt();
	  System.out.println("enter your name");
	  String str=scan.next();
	  EntityManagerFactory factory=null;
	  EntityManager manager=null;
	  EntityTransaction transaction=null;
	  
	  factory=Persistence.createEntityManagerFactory("emp");
	  manager=factory.createEntityManager();
	  transaction=manager.getTransaction();
	  transaction.begin();
	  String update="update Employee2 set name= :str where id= :id";
	  Query query=manager.createQuery(update);
	  query.setParameter("str", args[0]);
	  query.setParameter("id", Integer.parseInt(args[1]));
	
	  int result=query.executeUpdate();
	   
	  transaction.commit();
}
}
