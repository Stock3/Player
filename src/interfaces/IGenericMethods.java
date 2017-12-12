package interfaces;

import java.util.List;

public interface IGenericMethods<T> {
    void serialize(List<T> dataToSerialize)  throws Exception;
    List<T> deserialize()throws Exception;

}
