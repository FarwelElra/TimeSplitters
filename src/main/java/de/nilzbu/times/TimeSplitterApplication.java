package de.nilzbu.times;

import com.google.gson.Gson;
import de.nilzbu.times.core.ui.MainMenue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.jar.JarFile;

@SpringBootApplication
@Slf4j
public class TimeSplitterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TimeSplitterApplication.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .run(args);

        EventQueue.invokeLater(() -> {
            MainMenue mainMenue = context.getBean(MainMenue.class);
            JFrame frame = new JFrame("⏱\uFE0F");
            frame.setContentPane(mainMenue.getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setSize(200,250);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }

}