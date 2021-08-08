package com.homework.util;

import java.io.File;

public interface Parser {
    void parseFile(File file);
    boolean isAcceptableLine(String line);
}
