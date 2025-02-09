package org.example;

import java.util.regex.*;

public class ResumeDataExtractor {
    public static String extractEmail(String text) {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = emailPattern.matcher(text);
        return matcher.find() ? matcher.group() : "Email not found";
    }

    public static String extractPhoneNumber(String text) {
        Pattern phonePattern = Pattern.compile("\\b\\d{10}\\b"); // Simple 10-digit phone number
        Matcher matcher = phonePattern.matcher(text);
        return matcher.find() ? matcher.group() : "Phone number not found";
    }

    public static void main(String[] args) {
        String text = ResumeParser_Only_PDF.extractTextFromPDF("D:\\ARMY\\Documentations\\Chetna_Soni.pdf");

        System.out.println("Extracted Email: " + extractEmail(text));
        System.out.println("Extracted Phone: " + extractPhoneNumber(text));
    }
}