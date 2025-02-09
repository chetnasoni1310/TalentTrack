module ResumeExtraction{

    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires java.sql;
    requires org.apache.pdfbox;
    requires org.apache.poi.scratchpad; // Add other necessary modules

    opens org.example   to javafx.fxml;
    exports org.example  ;
}