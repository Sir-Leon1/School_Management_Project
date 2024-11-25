import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;

public class PdfHeader {
    public static void addHeader(Document document, String title) {
        Paragraph header = new Paragraph(title)
                .setFontSize(16)
                .setBold();
        document.add(header);
        document.add(new LineSeparator());
    }
}
