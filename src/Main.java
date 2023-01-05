import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestObjectStream testObjectStream=new TestObjectStream();
        testObjectStream.write();
        testObjectStream.read();


//        for(String arg : args){
//            System.out.println(arg);
//        }

//        TestFileStream testFileStream=new TestFileStream();
//        testFileStream.write();
//        testFileStream.read();
    }
}
