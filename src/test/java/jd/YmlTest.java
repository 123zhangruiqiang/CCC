package jd;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.net.URL;

public class YmlTest {
    @Test
    public void readYml(){

        Yaml yaml=new Yaml();
        System.out.println("hahahhaha");
        URL url=YmlTest.class.getClassLoader().getResource("");
        System.out.println(url);
    }

}
