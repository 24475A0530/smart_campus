import java.sql.*;
import java.util.Scanner;

public class Complaint {

    Scanner sc = new Scanner(System.in);

    public void addComplaint() {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Complaint ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Complaint: ");
            String complaint = sc.nextLine();

            String query = "INSERT INTO complaints(complaint_id,student_name,complaint_text,status) VALUES(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, complaint);
            pst.setString(4, "Pending");

            pst.executeUpdate();

            System.out.println("Complaint Submitted Successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
