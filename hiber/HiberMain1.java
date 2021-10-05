   package hiber;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class HiberMain1 {
	public static void main(String[] args) {
	    Employee1 employee=new Employee1();
	    employee.setId(104 );            //set-to store the values into the database
	    employee.setName("maruthi");
	    employee.setSalary(1000.0);
	    EntityManagerFactory factory=null;    //globally we were declared
	    EntityManager manager=null;
	    EntityTransaction transaction=null;
	    try {
			 factory=Persistence.createEntityManagerFactory("emp");//  it will create and return an EMf for the name persistence unit
			 manager=factory.createEntityManager();// with the reference of EMF we are creating the instance for entity manager 
			 transaction=manager.getTransaction();//it returns the resource(data base)level entity(table) transaction object.
			transaction.begin();//this method is used to start the transactions
			manager.persist(employee);//is used to make an instance managed and persistence  (insert the data)
			transaction.commit();//it is used to save all the transactions
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null) {
				transaction.rollback();//to vanish all the transactions made on the table
			}}
			finally {
				if(factory!=null) {
					factory.close();//close the EMF
				}
				if(manager!=null) {
					manager.close();//close the MF
				}
			}
	}
}   
//createEntityManagerFactory is an interface and we con't create an object of an interface  
//so we have an persistence class within the persistence class we have CEMF method which
//accepts persistence unit name-for eg(emp ).