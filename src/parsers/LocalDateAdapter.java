package parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateAdapter implements Converter {

    @Override
    public boolean canConvert(Class arg0) {
        // TODO Auto-generated method stub
        return arg0.equals(LocalDate.class);
    }

    @Override
    public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
        LocalDate zdt = (LocalDate) arg0;
        arg1.setValue(zdt.format(DateTimeFormatter.ISO_LOCAL_DATE));

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
        return LocalDate.parse(arg0.getValue(), DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
