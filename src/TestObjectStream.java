import java.io.*;
import java.util.Date;

public class TestObjectStream implements ReadAndWrite {
    @Override
    public void read() throws IOException, ClassNotFoundException {
      try(  FileInputStream fileInputStream = new FileInputStream("persons.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
          Object o;

          while ((o = objectInputStream.readObject()) != null) {
              System.out.println(o);
          }
      }catch (EOFException e){
          System.out.println("Reached End of the file");
      }

    }

    @Override
    public void write() throws IOException {
        Person p1 = new Person("neha", 26, 64982592352l);
        Person p2 = new Person("rabia", 26, 6498245432352l);


        try(   FileOutputStream fileOutputStream = new FileOutputStream("persons.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            objectOutputStream.writeObject(new Date());
            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
        }catch (NotSerializableException e){
            System.out.println("exception occurred");
        }
    }
}
