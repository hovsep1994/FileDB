package com.aca.filedb;

import java.io.IOException;

public class Main1 {

    public static void main(String[] args) {
        try (Repository<String, String> repository = new StringRepositoryImpl("blabla.txt")) {
            repository.open();
            repository.put("bla", "bla");
            repository.get("bla");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
