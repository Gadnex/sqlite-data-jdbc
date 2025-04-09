package net.binarypaper.sqlitedatajdbc.greeting;

import org.springframework.data.annotation.Id;

public record Greeting(@Id Long id, String message) {}
