package com.aca.filedb;

import java.io.*;
import java.util.Scanner;

public class StringRepositoryImpl implements Repository<String, String> {

    private static final String KEY_VALUE_DIVIDER = " - ";
    private static final String LINE_DIVIDER = "\n";

    private Scanner scanner;
    private FileWriter fileWriter;
    private String filePath;

    public StringRepositoryImpl(String filePath) {
        this.filePath = filePath;
    }

    public void open() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        fileWriter = new FileWriter(file, true);
        scanner = new Scanner(file);
    }

    @Override
    public void put(String key, String value) throws IOException {
        String s = key + KEY_VALUE_DIVIDER + value + LINE_DIVIDER;
        fileWriter.write(s);
        fileWriter.flush();
    }

    @Override
    public String get(String key) {
        while (scanner.hasNextLine()) {
            String next = scanner.nextLine();
            String[] split = next.split(KEY_VALUE_DIVIDER);
            if (split[0].equals(key)) {
                return split[1];
            }
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
        scanner.close();
    }
}
