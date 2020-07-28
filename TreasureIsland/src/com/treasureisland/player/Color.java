package com.treasureisland.player;

public enum Color {
    // Rendering text via ANSI escape codes
    // Primary Colors
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BLUE("\u001B[34m"),

    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_WHITE("\u001B[37m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),




    // Bold
    ANSI_BOLD("\u001B[1m"),
    ANSI_BLINK("\u001B[5m"),
    ANSI_WHITE_BOLD("\033[1;37m"),

    // Reset
    ANSI_RESET("\u001B[0m");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}
