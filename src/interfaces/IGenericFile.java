package interfaces;
import java.io.File;
import java.io.IOException;

public interface IGenericFile {

    void write(String value, File file) throws IOException;

    String read(File file) throws IOException;

}
