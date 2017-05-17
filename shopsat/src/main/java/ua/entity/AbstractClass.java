package ua.entity;




import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractClass {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	public AbstractClass() {
		
	}
	
	
	
	public AbstractClass(Integer id) {
		super();
		this.id = id;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}



}
