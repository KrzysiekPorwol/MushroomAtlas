package logic.file;

import exception.InvalidFileReadException;
import exception.InvalidFileSaveException;
import model.Mushroom;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class FileCreator {

  String fileName = "/Users/krzysztofporwol/javastart/Atlas_Grzybow/mushrooms.txt";
  File file = new File(fileName);

  public void saveMushroom(Set<Mushroom> mushrooms) throws InvalidFileSaveException {
    try (
          var fs = new FileOutputStream(file);
          var os = new ObjectOutputStream(fs);
    ) {
      os.writeObject(mushrooms);
      System.out.println("Zapisano wszystkie grzyby do pliku");

    } catch (IOException e) {
      throw new InvalidFileSaveException(e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public Set<Mushroom> readMushroom() throws InvalidFileReadException {

    if (!file.exists()) {
      return new TreeSet<>();
    }
    try (
          var fs = new FileInputStream(file);
          var os = new ObjectInputStream(fs);
    ) {

      Set<Mushroom> mushrooms = (Set<Mushroom>) os.readObject();
      System.out.println("odczytano grzyby z pliku");
      return mushrooms;

    } catch (IOException | ClassNotFoundException e) {
      throw new InvalidFileReadException(e.getMessage());
    }

  }


}
