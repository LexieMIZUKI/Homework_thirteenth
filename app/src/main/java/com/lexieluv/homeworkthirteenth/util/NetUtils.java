package com.lexieluv.homeworkthirteenth.util;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//从网站上下载数据工具类
public class NetUtils {
    public static byte[] getNetData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("GET");
            huc.setReadTimeout(5000);
            huc.setConnectTimeout(5000);

            byte[] result = null;
            if(huc.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream is = huc.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer))!= -1){
                    baos.write(buffer,0,len);
                }
                result = baos.toByteArray();
            }
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
