package methods;

import com.fasterxml.jackson.databind.SerializationFeature;
import interfaces.IGenericMethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class GenericMethodsJson<T> implements IGenericMethods{
    private static File fileName;
    private ObjectMapper mapper;
    private Class<T> clases;

    public Class<T> getClases() {
        return clases;
    }

    public GenericMethodsJson(File filePath) {
        fileName = filePath;
        mapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        mapper.setDateFormat(sdf);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public void serialize(List dataToSerialize) throws Exception {
        mapper.writeValue(fileName, dataToSerialize);
    }

    @Override
    public List deserialize() throws Exception {
        TypeFactory typeFactory = mapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, clases);
        return mapper.readValue(fileName, collectionType);
    }
}
