import java.sql.*;
import com.itextpdf.layout.element.*;

public class PdfReportGenerator {
    public static void generateStudentsByClass(String className, String outputPath) throws Exception {
        // Initialize PDF
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add header
        PdfHeader.addHeader(document, "Student List - Class: " + className);

        // Fetch data from the database
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM students WHERE class = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, className);
        ResultSet rs = stmt.executeQuery();

        // Add table to PDF
        Table table = new Table(3); // Example for 3 columns
        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Class");
        while (rs.next()) {
            table.addCell(rs.getString("id"));
            table.addCell(rs.getString("name"));
            table.addCell(rs.getString("class"));
        }
        document.add(table);

        // Close PDF
        document.close();
        System.out.println("PDF created successfully!");
    }
}
