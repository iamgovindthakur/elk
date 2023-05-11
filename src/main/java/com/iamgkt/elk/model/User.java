package com.iamgkt.elk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

        @JsonProperty("id")
        private final String id;
        @JsonProperty("name")
        private final String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }
        // Constructors, getters, and setters

        // Optional: toString() method for logging or debugging
        @Override
        public String toString() {
            return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
        }
    }