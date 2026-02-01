package edu.au.cpsc.module4;

import java.io.*;

/*
 * Project: project4
 * Author: Christopher
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-01-31
 * Description: This class provides static methods to save and load an AirlineDatabase
 * using Java serialization. It ensures null safety and handles IO exceptions properly.
 * App title: Christopher's Flight Designator App
 */
public class AirlineDatabaseIO {

    // Save the AirlineDatabase to an OutputStream
    public static void save(AirlineDatabase ad, OutputStream strm) throws IOException {
        // Null check
        if (ad == null || strm == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(strm)) {
            oos.writeObject(ad);
            oos.flush();
        }
    }

    // Load the AirlineDatabase from an InputStream
    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        // Null check
        if (strm == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        try (ObjectInputStream ois = new ObjectInputStream(strm)) {
            return (AirlineDatabase) ois.readObject();
        }
    }
}
