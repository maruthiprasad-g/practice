package hiber;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee2{
@Id
private int id;
private String name;

}