package com.binaryio.exercise;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ReadAndWrite {
    void read() throws IOException, ClassNotFoundException;
    void write() throws IOException;
}
