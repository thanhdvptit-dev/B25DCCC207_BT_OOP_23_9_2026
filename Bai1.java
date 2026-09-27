class Student {
    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;

    public Student(String mssv, String name, double diemCC, double diemGK, double diemCK) {
        this.mssv = mssv;
        this.name = name;
        setDiemCC(diemCC);
        setDiemGK(diemGK);
        setDiemCK(diemCK);
    }

    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double getDiemGK() {
        return diemGK;
    }

    public double getDiemCK() {
        return diemCK;
    }

    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10) {
            this.diemCC = diemCC;
        }
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) {
            this.diemGK = diemGK;
        }
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) {
            this.diemCK = diemCK;
        }
    }

    public double diemTrungBinh() {
        return (diemCC * 0.1) + (diemGK * 0.3) + (diemCK * 0.6);
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Student sv1 = new Student("SV01", "Nguyen Van A", 10.0, 8.0, 7.5);
        Student sv2 = new Student("SV02", "Tran Thi B", 9.0, 9.5, 9.0);
        Student sv3 = new Student("SV03", "Le Van C", 8.0, 7.5, 8.5);

        System.out.println("MSSV: " + sv1.getMssv() + " - Tên: " + sv1.getName() + " - ĐTB: " + sv1.diemTrungBinh());
        System.out.println("MSSV: " + sv2.getMssv() + " - Tên: " + sv2.getName() + " - ĐTB: " + sv2.diemTrungBinh());
        System.out.println("MSSV: " + sv3.getMssv() + " - Tên: " + sv3.getName() + " - ĐTB: " + sv3.diemTrungBinh());
    }
}