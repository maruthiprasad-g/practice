package hiber;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data // it implements getters and setters automatically
@Entity // class can be mapped to a table.
@Table(name = "our_employee")
public class Employee1 implements Serializable {

	@Id // represent the primary key(combination of not null and unique) of an entity
	private int id;
	private String name;       
	private double salary;
}

//each table can have only one primary key. (for eg- one man consists of only one voter id) 
//serialisable-it will convert the object into bytecode
//disadvantage of JPA  -we cont access all the records(row) from the table