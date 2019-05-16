package com.aca.filedb;

import java.io.IOException;
import java.io.Serializable;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileRepositoryImpl<Long, User> repository = new FileRepositoryImpl<>(User.class);
        repository.put(1L, new User("name", "password"));
        User user = repository.get(1L);
        System.out.println(user);
    }

    private static class User implements Serializable {
        String name;
        String password;

        public User() {
        }

        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

}
