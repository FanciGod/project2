module com.controller.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;
    requires de.jensd.fx.glyphs.fontawesome;
    opens entity to javafx.base;

    opens com.controller.project to javafx.fxml;
    exports com.controller.project;
    exports entity;
}