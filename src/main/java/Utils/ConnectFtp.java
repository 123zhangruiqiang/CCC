package Utils;


import org.apache.commons.net.ftp.FTPClient;


import java.io.*;


public class ConnectFtp {



    public static void upFile(String filepath){
        FileInputStream fi= null;
        try {
            fi = new FileInputStream(new File(filepath));
            //fi = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean b=updateFile("172.19.60.187","feefile1","123456","feefile",filepath,fi);
        if(b){
            System.out.println("文件上传成功");
        }else{
            System.out.println("文件上传失败");
        }
    }

    public static boolean updateFile(String url, String username, String password, String path, String filename, InputStream inputstream ){
        boolean result=false;
        FTPClient ftp=new FTPClient();
        try {
            ftp.connect(url);
            ftp.login(username,password);
            ftp.changeWorkingDirectory(path);
            System.out.println(filename);
            ftp.storeFile(filename, inputstream);
            System.out.println("fileupdate");
            inputstream.close();
            ftp.logout();
            result=true;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

}
