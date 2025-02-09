package org.example;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ResumeParser_Only_PDF {
    public static String extractTextFromPDF(String filePath) {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void main(String[] args) {
        String text = extractTextFromPDF("D:\\ARMY\\Documentations\\Chetna_Soni.pdf");
        // Replace with your resume path

        System.out.println(text);
    }


}
