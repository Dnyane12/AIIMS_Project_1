package utils;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtilToReadPDFFile {

	    private PDFUtilToReadPDFFile() {
	        // utility class - prevent object creation
	    }

	    public static String readPdfText(File pdfFile) {

	        if (pdfFile == null || !pdfFile.exists()) {
	            throw new RuntimeException("PDF file is null or does not exist");
	        }

	        try (PDDocument document = PDDocument.load(pdfFile)) {

	            PDFTextStripper stripper = new PDFTextStripper();
	            stripper.setSortByPosition(true);

	            return stripper.getText(document);

	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read PDF file: " + pdfFile.getName(), e);
	        }
	    }
	}


