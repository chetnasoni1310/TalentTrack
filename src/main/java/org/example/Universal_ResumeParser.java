package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;
import java.util.List;

public class Universal_ResumeParser {
    public static String extractText(String filePath) throws IOException {
        File file = new File(filePath);
        String fileType = getFileExtension(file);

        switch (fileType) {
            case "pdf":
                return extractTextFromPDF(filePath);
            case "doc":
                return extractTextFromDoc(filePath);
            case "docx":
                return extractTextFromDocx(filePath);
            case "txt":
                return extractTextFromTxt(filePath);
            default:
                throw new IOException("Unsupported file format: " + fileType);
        }
    }

    // Get file extension
    private static String getFileExtension(File file) {
        String name = file.getName();
        int lastIndex = name.lastIndexOf(".");
        return (lastIndex == -1) ? "" : name.substring(lastIndex + 1).toLowerCase();
    }

    // Extract text from PDF
    private static String extractTextFromPDF(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    // Extract text from DOC (Old Word format)
    private static String extractTextFromDoc(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             HWPFDocument doc = new HWPFDocument(fis);
             WordExtractor extractor = new WordExtractor(doc)) {
            return extractor.getText();
        }
    }

    // Extract text from DOCX (New Word format)
    private static String extractTextFromDocx(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             XWPFDocument doc = new XWPFDocument(fis)) {
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            for (XWPFParagraph para : paragraphs) {
                text.append(para.getText()).append("\n");
            }
        }
        return text.toString();
    }

    // Extract text from TXT file
    private static String extractTextFromTxt(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        }
        return text.toString();
    }

    // Main method to test
    public static void main(String[] args) {
        try {
            String text = extractText("D:\\ARMY\\Documentations\\Chetna_Soni.pdf");  // Change to any file (resume.docx, resume.txt, etc.)
            System.out.println("Extracted Resume Text:\n" + text);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
