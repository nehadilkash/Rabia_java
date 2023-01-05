import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileStream implements ReadAndWrite {
    @Override
    public void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        int b;
        while ((b=fileInputStream.read())!=-1){
            System.out.print((char)b);
        }


    }

    @Override
    public void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.dat");
        String line = "my name is Neha";
        fileOutputStream.write(line.getBytes());


        FileWriter fileWriter=new FileWriter("abc.txt");
        fileWriter.write("My name is Neha");
    }
}
