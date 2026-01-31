package edu.au.cpsc.module4;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AirportDatabaseIO {

    public static void save(AirlineDatabase ad, OutputStream strm)
            throws IOException {

        if (ad == null || strm == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(ad);
        oos.flush();
    }

    public static AirlineDatabase load(InputStream strm)
            throws IOException, ClassNotFoundException {

        if (strm == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        ObjectInputStream ois = new ObjectInputStream(strm);
        return (AirlineDatabase) ois.readObject();
    }
}
