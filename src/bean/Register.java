package bean;
public class Register implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String course;

	public int getId(){return id;}
	public String getName(){return name;}
	public String getCourse(){return course;}

	public void setId(int id){this.id=id;}
	public void setName(String name){this.name=name;}
	public void setCourse(String course){this.course=course;}
}