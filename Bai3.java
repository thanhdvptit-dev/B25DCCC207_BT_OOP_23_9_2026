import java.util.ArrayList;

class Student {
    private String mssv;
    private String hoTen;
    private ArrayList<Double> diemCacMon; 
    public Student(String mssv, String hoTen) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemCacMon = new ArrayList<>();
    }

    public String getMssv() {
        return mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void themDiem(double diem) {
        diemCacMon.add(diem);
    }

    public double diemTrungBinh() {
        if (diemCacMon.isEmpty()) {
            return 0.0;
        }
        double tong = 0;
        for (double d : diemCacMon) {
            tong += d;
        }
        return tong / diemCacMon.size();
    }

    @Override
    public String toString() {
        return "MSSV: " + mssv + " - Họ tên: " + hoTen;
    }
}

class Classroom {
    private String tenLop;
    private ArrayList<Student> danhSachSinhVien;

    public Classroom(String tenLop) {
        this.tenLop = tenLop;
        this.danhSachSinhVien = new ArrayList<>();
    }

    public String getTenLop() {
        return tenLop;
    }

    public void addStudent(Student s) {
        for (Student sv : danhSachSinhVien) {
            if (sv.getMssv().equals(s.getMssv())) {
                throw new IllegalArgumentException(
                        "MSSV " + s.getMssv() + " đã tồn tại trong lớp!");
            }
        }
        danhSachSinhVien.add(s);
    }


    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8) {
            return "Giỏi";
        } else if (dtb >= 6.5) {
            return "Khá";
        } else if (dtb >= 5) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    public void inBangDiem() {
        System.out.println("===== BẢNG ĐIỂM LỚP " + tenLop + " =====");
        System.out.printf("%-10s %-20s %-10s %-12s%n", "MSSV", "Họ tên", "ĐTB", "Xếp loại");
        for (Student s : danhSachSinhVien) {
            System.out.printf("%-10s %-20s %-10.2f %-12s%n",
                    s.getMssv(), s.getHoTen(), s.diemTrungBinh(), xepLoai(s));
        }
        System.out.println("Sĩ số lớp: " + danhSachSinhVien.size());
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Classroom lop10A1 = new Classroom("10A1");

        Student sv1 = new Student("SV001", "Nguyễn Văn An");
        sv1.themDiem(9.0);
        sv1.themDiem(8.5);
        sv1.themDiem(8.0);

        Student sv2 = new Student("SV002", "Trần Thị Bình");
        sv2.themDiem(7.0);
        sv2.themDiem(6.5);
        sv2.themDiem(6.0);

        Student sv3 = new Student("SV003", "Lê Văn Cường");
        sv3.themDiem(5.5);
        sv3.themDiem(5.0);
        sv3.themDiem(4.5);

        Student sv4 = new Student("SV004", "Phạm Thị Dung");
        sv4.themDiem(3.0);
        sv4.themDiem(4.0);
        sv4.themDiem(3.5);

        lop10A1.addStudent(sv1);
        lop10A1.addStudent(sv2);
        lop10A1.addStudent(sv3);
        lop10A1.addStudent(sv4);

        try {
            Student svTrung = new Student("SV002", "Sinh Viên Trùng MSSV");
            lop10A1.addStudent(svTrung);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy sau khi bắt lỗi.\n");

        lop10A1.inBangDiem();
    }
}
