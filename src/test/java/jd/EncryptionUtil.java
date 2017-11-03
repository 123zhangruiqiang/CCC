package jd;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.junit.Test;

public class EncryptionUtil {
	
	
	/**
	 * 获取文件HASH值
	 * @param fileName
	 * @param hashType
	 * @return
	 * @throws Exception
	 */
	@Test
	public  void test1(){
		File file=new File("C:\\Users\\Administrator\\XML.zip");
		String s=getMd5FileHash(file);
		System.out.println(s);
	}
	public  static String getFileHash(File file, String hashType)  
	        
	    {  
		try {
			
		  InputStream fis = new FileInputStream(file);  
	       
	        byte buffer[] = new byte[1024];  
	        MessageDigest md5 = MessageDigest.getInstance(hashType);  
	        for(int numRead = 0; (numRead = fis.read(buffer)) > 0;)  
	        {  
	            md5.update(buffer, 0, numRead);  
	        }  
	        byte[] b = md5.digest();
	        StringBuffer sb = new StringBuffer();
	        for(int i = 0;i<b.length;i++){
	        	int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
	        }
	          return sb.toString();
	      } catch (Exception e) {
			// TODO: handle exception
	    }
		return  "";
	  } 
	/**
	 * 
	 * @param file file
	 * @return
	 */
	public  static String getMd5FileHash(File file)  {
		
		return getFileHash(file,"MD5");
	}
	// 对字符串进行md5加密
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());

			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
			}

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}
	
	// 对字符串进行sha256加密
	public static String sha256(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());

			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
			}

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}
	// 对字符串进行sha1加密
	public static String sha1(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());

			byte[] b = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				int v = (int) b[i];
				v = v < 0 ? 0x100 + v : v;
				String cc = Integer.toHexString(v);
				if (cc.length() == 1)
					sb.append('0');
				sb.append(cc);
			}

			return sb.toString();
		} catch (Exception e) {
		}
		return "";
	}
	
}
