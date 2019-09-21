import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class JavaObjectToJSON {
    public static void main(String[] args) {
        Student st1 = new Student(11, "Tom", 3.2, "acb@gmail.com");
        st1.addAdvisor("Tony");
        st1.addAdvisor("James");
        System.out.println(st1);

        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream("src/student.json"), "UTF-8");
            Gson gson = new GsonBuilder().create();
            gson.toJson(st1, writer);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student st2 = new Student(07, "Gorge", 3.8, "xyz@gmail.com");
        st2.addAdvisor("Tony Stark");
        st2.addAdvisor("Peter Parker");

        Course c1 = new Course("SWE690", "Data Science", 3);
        Course c2 = new Course("SWE601", "Software Architecture", 3);
        Course c3 = new Course("SWE650", "Software Improvement", 3);

        Registers regs = new Registers();
        regs.addRegister(new Register(st1, c1, "A"));
        regs.addRegister(new Register(st1, c2, "B"));
        regs.addRegister(new Register(st1, c3, "B"));
        regs.addRegister(new Register(st2, c1, "A"));
        regs.addRegister(new Register(st2, c2, "B+"));

        System.out.println(regs);

        try {
            Writer writer2 = new OutputStreamWriter(new FileOutputStream("src/register.json"), "UTF-8");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(regs, writer2);
            writer2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
