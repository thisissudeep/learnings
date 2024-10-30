package CBA;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveToFile(String filename, ArrayList<Item> items) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(items);
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Item> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (ArrayList<Item>) ois.readObject();
        }
    }
}