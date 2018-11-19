package cn.hao.component;


import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Tianbohao on 2018/11/7.
 */
public class JAXBUtil {
    public static <T> T xml2pojo(InputStream in, Class<T> classes) throws JAXBException, IOException {
        byte[] data = IOUtils.toByteArray(in);
        JAXBContext context = JAXBContext.newInstance(classes);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        T t = (T) unmarshaller.unmarshal(inputStream);
        return t;
    }
}
