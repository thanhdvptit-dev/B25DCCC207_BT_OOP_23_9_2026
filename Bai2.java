class Student {
    private static int counter = 0; 
    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;

    public Student(String name, double diemCC, double diemGK, double diemCK) {
        counter++; 
        this.mssv = String.format("B21DCCN%03d", counter); 
        this.name = name;
        this.diemCC = diemCC;
        this.diemGK = diemGK;
        this.diemCK = diemCK;
    }

    public String getMssv() {
        return mssv;
    }

    public Student capNhatEmail(String email) {
        this.email = email;
        return this;
    }

    public Student capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public static int getTotalStudents() {
        return counter;
    }
    
    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Student sv1 = new Student("Lan", 8, 7.5, 9);
        sv1.capNhatEmail("lan@ptit.edu.vn").capNhatSdt("0912345678");
        Student sv2 = new Student("Hùng", 7.0, 8.0, 8.5);
        Student sv3 = new Student("Mai", 9.0, 9.5, 9.0);
        System.out.println("MSSV sv1: " + sv1.getMssv() + " (Email: " + sv1.getEmail() + ", SĐT: " + sv1.getSdt() + ")");
        System.out.println("MSSV sv2: " + sv2.getMssv());
        System.out.println("MSSV sv3: " + sv3.getMssv());
        System.out.println("Tổng số sinh viên đã tạo: " + Student.getTotalStudents());
    }
}