package Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GetParam {

    public static Map<String,String> getPa(String paName){

        Class<?> clazz= null;
        try {
            clazz = Class.forName("Utils.Param");
            Method m1=clazz.getMethod(paName, Map.class);
            Param pa=(Param) clazz.newInstance();
            Map<String,String> param=(Map<String, String>)m1.invoke(pa,new HashMap<String,String>());
            return param;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }
    public static Map<String,String> getPabyPost(String paName){
        Class<?> clazz= null;
        try {
            clazz = Class.forName("Utils.Param");
            Method m1=clazz.getMethod(paName, Map.class);
            Param pa=(Param) clazz.newInstance();
            Map<String,String> param=(Map<String, String>)m1.invoke(pa,new HashMap<String,String>());
            System.out.println(param);
            return  param;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
