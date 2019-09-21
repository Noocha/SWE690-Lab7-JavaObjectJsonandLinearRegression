import java.util.Vector;

public class Registers {
    Vector<Register> registers;

    public Registers(Vector<Register> registers) {
        this.registers = registers;
    }

    public Registers() {
        registers = new Vector<Register>();
    }

    public void  addRegister(Register r) {
        registers.add(r);
    }

    public String toString() {
        String result = "";
        for (Register register : registers) {
            result += register.getStudent().toString() + " ";
            result += register.getCourse().toString() + " ";
            result += register.getGrade() + "\n";
        }
        return "Registers: {" + result + "}";
    }

}
