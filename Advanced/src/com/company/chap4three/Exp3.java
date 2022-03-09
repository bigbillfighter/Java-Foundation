package com.company.chap4three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

class Test{
    public static String sendGet(String url, String params){
        String result = "";
        BufferedReader in = null;
        try{
            String urlNameString = url + "?" +params;
            URL realURL = new URL(urlNameString);
            URLConnection connection = realURL.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.connect();

            // 通过 BufferedReader 输入流来读取 URL 的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result += line;
                System.out.println(line);
            }

        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (Exception e2){}
        }
        return result;
    }

    public static String sendPost(String url, String params){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try{
            URL realURL = new URL(url);
            URLConnection con = realURL.openConnection();
            // 设置一些通用的请求属性
            con.setRequestProperty("accept", "*/*");
            con.setRequestProperty("connection", "Keep-Alive");
            // 允许输出流
            con.setDoOutput(true);
            // 获取 URLConnection 对象对应的输出流
            out = new PrintWriter(con.getOutputStream());
            // 发送请求参数
            out.print(params);
            // flush 强制将缓冲区的流输出
            out.flush();

            // 读取返回信息
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = in.readLine())!=null){
                result += line;
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(out!=null) out.close();
                if(in!=null) in.close();
            }catch (IOException e){e.printStackTrace();}
        }

        return result;
    }
}


public class Exp3 {
    public static void main(String[] args) {
        Test.sendGet("https://www.sohu.com/a/462860227_162522", "spm=smpc.home.top-news2.2.1619353774198FSmllE0&_f=index_news_1");
    }
}
