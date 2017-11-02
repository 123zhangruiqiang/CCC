package Utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpHost {

    public static String getCurrentFile(){
        try {
            InetAddress ip=Inet4Address.getLocalHost();
            String text=ip.toString();
            return  ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
