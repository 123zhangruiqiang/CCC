import Utils.IpHost

class testIp {

    static void main(args){
        IpHost ipHost=new  IpHost();
        String file=ipHost.getCurrentFile();
        print file;
    }

}
