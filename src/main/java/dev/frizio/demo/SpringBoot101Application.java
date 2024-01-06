package dev.frizio.demo;

import java.text.NumberFormat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;

@Slf4j
@SpringBootApplication
public class SpringBoot101Application {

  /**
   * @param args
   */
  public static void main(String[] args) {

    SpringApplication.run(SpringBoot101Application.class, args);

    Runtime runtime = Runtime.getRuntime();
    final NumberFormat format = NumberFormat.getInstance();
    final long maxMemory = runtime.maxMemory();
    final long allocatedMemory = runtime.totalMemory();
    final long freeMemory = runtime.freeMemory();
    final long mb = 1024 * 1024;
    final String mega = " MB";
    log.info("===================== Runtime Memory Info =====================");
    log.info("Free memory: " + format.format(freeMemory / mb) + mega);
    log.info("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
    log.info("Max memory: " + format.format(maxMemory / mb) + mega);
    log.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
    log.info("===============================================================\n");
    
    log.info("====================== Runtime Version Info =====================");
    log.info("Java Feature Version = " + Runtime.version().feature());
    log.info("Java Interim Version = " + Runtime.version().interim());
    log.info("Java Update Version = " + Runtime.version().update());
    log.info("Java Version Build = " + Runtime.version().build().map(String::valueOf).orElse("Unknown"));
    log.info("Java Version Pre-Release Info = " + Runtime.version().pre().orElse("N/A"));
    log.info("===============================================================\n");

    log.info("====================== JAVA Properties Info =====================");
    log.info("java.home: " + System.getProperty("java.home"));
    log.info("java.version: " + System.getProperty("java.version"));
    log.info("java.vm.version: " + System.getProperty("java.vm.version"));
    log.info("===============================================================\n");

    log.info("===================== Spring Framework Info =====================");
    log.info("Java Version: " + JavaVersion.getJavaVersion());
    log.info("Spring Version: " + SpringVersion.getVersion());
    log.info("Spring Boot Version: " + SpringBootVersion.getVersion());
    log.info("===============================================================\n");

  }

}
