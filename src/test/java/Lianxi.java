import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Map;

public class Lianxi {
    @Test
    public void readYml(){
        Yaml yaml=new Yaml();
        URL url=Lianxi.class.getClassLoader().getResource("");
        String file=url.getPath()+"properties/demo.yml";
        try {
            Map map=(Map) yaml.load(new FileInputStream(file));
            System.out.println(map);
            Map map1=(Map)map.get("Animal");
            String name= (String) map1.get("name");
            System.out.println(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(file);

    }

}
