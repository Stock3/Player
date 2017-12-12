package methods;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import interfaces.IGenericMethods;
import parsers.LocalDateAdapter;

import java.io.File;
import java.util.List;

public class GenericMethodsXml<T> implements IGenericMethods{
    private static File fileName;
    private static GenericFile file;
    private static XStream xStream;

    public GenericMethodsXml(File filePath){

        fileName = filePath;
        file = new GenericFile();
        xStream = new XStream(new DomDriver());
        xStream.autodetectAnnotations(true);
        xStream.registerConverter(new LocalDateAdapter());
    }

    @Override
    public void serialize(List dataToSerialize) throws Exception {
        String studentsString = xStream.toXML(dataToSerialize);
        file.write(studentsString, fileName);
    }

    @Override
    public List deserialize() throws Exception {
        return (List<T>) xStream.fromXML(file.read(fileName));
    }
}
