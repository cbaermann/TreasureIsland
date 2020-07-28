package com.treasureisland.player;

public enum Color {
    // Rendering text via ANSI escape codes
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_BLUE("\u001B[34m"),

    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLACK("\u001B[30m"),
    ANSI_WHITE("\u001B[37m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),

    ANSI_RESET("\033[0m");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}
