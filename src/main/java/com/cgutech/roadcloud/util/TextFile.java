package com.cgutech.roadcloud.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Becan on 2017/5/8.
 */
public class TextFile extends ArrayList<String> {
    public static String read(File file) {
        BufferedReader in;
        try{
            in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try{}finally {
                if(in != null)
                in.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return read(in);
    }
    //Read a file as a single string:
    public static String read(String fileName) {
        return read(new File(fileName));
    }
    public static String read(BufferedReader reader){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader in = reader;
            try{
                String s;
                while((s=in.readLine())!=null){
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                in.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    public static String read(InputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return read(reader);
    }
    //Wirte a single file in one method call:
    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    //Read a file.split by any regular expression
    public TextFile(String filename, String splitter){
        super(Arrays.asList(read(filename).split(splitter)));
        //Regular expression split() often leaves an empty String at the first position
        if(get(0).equals("")) remove(0);
    }

    //Normally read by lines;
    public TextFile(String filename){
        this(filename,"\n");
    }

    public  void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for (String item:this)
                    out.println(item);
            }finally {
                out.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
