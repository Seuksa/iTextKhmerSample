package org.seuksa.sample.khmeriText;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.languages.KhmerLigaturizer;

/**
 * Hello Sample Test PDF with iText
 * Website: http://ask.osify.com
 *
 * @author pongsametrey.sok
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Document document = new Document();
        String localFontPath = App.class.getClassLoader().getResource("kh_battambang.ttf").getPath();
        try {
        	File file = new File("C:/tmp/UnicodeExamplePDF-MT.pdf");
//        	if (!file.exists()) {
//        		file.createNewFile();
//        	}
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            KhmerLigaturizer d = new KhmerLigaturizer();
        	//String strProcess = d.process("\u0936\u093e\u0902\u0924\u094d\u093f");
            String strProcess = "Hello " + d.process("ហេតុនេះ​យើង​ត្រូវ​តែរួម​គ្នា​ដោះ​ស្រាយ ខ្លួន ស្វាគមន៍មកកាន់អូស៊ីហ្វាយ");

            BaseFont bfComic = BaseFont.createFont(localFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            //document.add(new Paragraph("Unicode: ការ​សិក្សា​ខាងបច្ចេក​វិទ្យា​នៅ​មាន​តម្រូវការខ្លាំង​លើ​ការ​ប្រើប្រាស់​ភាសា​ខ្មែរ", new Font(bfComic, 12)));
            document.add(new Paragraph(strProcess, new Font(bfComic, 22)));

            ColumnText columnText = new ColumnText(writer.getDirectContent());
            columnText.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
            //columnText.addElement(new Paragraph("Unicode: ហេតុនេះ​យើង​ត្រូវ​តែរូម​គ្នា​ដោះ​ស្រាយ......", new Font(bfComic, 12)));

            document.add(new Paragraph(d.process("\u1780\u17B6\u179A\u200B\u179F\u17B7\u1780\u17D2\u179F\u17B6\u200B\u1781\u17B6\u1784\u1794\u1785\u17D2\u1785\u17C1\u1780\u200B\u179C\u17B7\u1791\u17D2\u1799\u17B6\u200B\u1793\u17C5\u200B\u1798\u17B6\u1793\u200B\u178F\u1798\u17D2\u179A\u17BC\u179C\u1780\u17B6\u179A\u1781\u17D2\u179B\u17B6\u17C6\u1784\u200B\u179B\u17BE\u200B\u1780\u17B6\u179A\u200B\u1794\u17D2"), new Font(bfComic, 12)));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }
}
