package edu.au.cpsc.module4;

import java.io.*;

public class AirportDatabaseIO {

    public static void save(AirlineDatabase ad, OutputStream strm) throws IOException {
        if (ad == null || strm == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(strm)) {
            oos.writeObject(ad);
            oos.flush();
        }
    }

    public static AirlineDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        if (strm == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        try (ObjectInputStream ois = new ObjectInputStream(strm)) {
            return (AirlineDatabase) ois.readObject();
        }
    }
}
