package org.zidioschool.services.pdfGenerator;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.ILineDrawer;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.*;
import com.itextpdf.layout.element.*;

public class PdfHeader {
    public static void addHeader(Document document, String topic) {
        String title = "ZIDIO INTERNATIONAL SCHOOL\n" +
                "Where Dreams Begin and Leaders Are Made\n";
        String contact = "\uD83D\uDCCD Address: 123 Knowledge Lane, Scholar City, ED 45678\n" +
                "\uD83D\uDCDE Phone: +123-456-7890\n" +
                "\uD83D\uDCE7 Email: info@zidiointernationalschool.edu\n" +
                "\uD83C\uDF10 Website: www.zidiointernationalschool.edu" +
                "\n";
        String moto = "Committed to Academic Excellence | Nurturing Creativity | Inspiring Tomorrow’s Leaders";

        Paragraph headerTitle = new Paragraph(title)
                .setFontSize(12)
                .setBold();
        Paragraph headerContact = new Paragraph(contact)
                .setFontSize(8);
        Paragraph headerMoto = new Paragraph(moto)
                .setFontSize(8)
                .setItalic();
        document.add(headerTitle);
        document.add(headerContact);
        document.add(headerMoto);
        document.add(new LineSeparator(new ILineDrawer() {
            @Override
            public void draw(PdfCanvas pdfCanvas, Rectangle rectangle) {
                pdfCanvas.setStrokeColor(new DeviceRgb(0, 0, 0))
                        .setLineWidth(0.5f)
                        .moveTo(rectangle.getLeft(), rectangle.getBottom())
                        .lineTo(rectangle.getRight(), rectangle.getBottom())
                        .stroke();
            }

            @Override
            public float getLineWidth() {
                return 0;
            }

            @Override
            public void setLineWidth(float v) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color color) {

            }
        }));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph(topic).setBold().setFontSize(12));
    }
}
