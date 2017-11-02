package Utils;

import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Rpath {

    public static String rfPath(String ipaddress){

        Properties properties=new Properties();
        try {
            System.out.println(Rpath.class.getClassLoader().getResource("properties//ip_path.properties").getPath());
            properties.load(new FileInputStream(Rpath.class.getClassLoader().getResource("properties//ip_path.properties").getPath()));
            String path=properties.getProperty(ipaddress);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  null;

    }
}
