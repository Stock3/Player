package methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import interfaces.IGenericFile;

public class GenericFile implements IGenericFile {

    @Override
    public void write(String value, File file) throws IOException {
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
        bufferWriter.write(value);
        bufferWriter.close();

    }

    @Override
    public String read(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        fileReader.close();
        return sb.toString();
    }

}
