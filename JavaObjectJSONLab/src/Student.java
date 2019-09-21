import java.util.Vector;

public class Student {
    int id;
    String name;
    Double gpa;
    String email;
    Vector<String> advisor;

    public Student(int id, String name, Double gpa, String email) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.email = email;
        this.advisor = new Vector<String>();
    }

    public void addAdvisor(String advisorName) {
        advisor.add(advisorName);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                ", advisor='" + advisor +
                '}';
    }

}
