package de.nilzbu.times.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class FileSystem {

    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem() {
        if (!Files.isDirectory(root)) {
            try {
                Files.createDirectory(root);
            } catch (IOException e) {
                log.error("could not create directory", e);
            }
        }
    }

    public long freeDiskSpace() {
        return root.toFile().getFreeSpace();
    }

    public byte[] load(String filename) {
        try {
            return Files.readAllBytes(root.resolve(filename));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void store(String filename, byte[] bytes) {
        try {
            Files.write(root.resolve(filename), bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
