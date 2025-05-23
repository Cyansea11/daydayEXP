package com.bcvgh.utils;

import java.io.*;

public class  FileUtil {

    public static boolean Mkdir(String dirName){
        try {
            File file = new File(PocUtil.PocPath+File.separator+"json"+File.separator+dirName);
            file.mkdir();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String FileRead(String fileName){
        BufferedReader in = null;
        String strs = "";
        String str = "";
        try {
            in = new BufferedReader(new FileReader(fileName));
            while ((str = in.readLine()) != null) {
                strs = strs+str;
            }
            in.close();
            return strs;
        } catch (FileNotFoundException e) {
            PromptUtil.Alert("警告","请正确选择需要检测的漏洞名称");
            return null;
        } catch (IOException e) {
            PromptUtil.Alert("警告","文件读取出错啦!");
            return null;
        }
    }

    public static void FileWrite(String fileName,String content,String tag) throws IOException {
        content = content.replaceAll("\\\\n","\\\\r\\\\n");
        String filePath = System.getProperty("user.dir")+ File.separator + "poc" + File.separator + "json" + File.separator + tag + File.separator + fileName;
//        try {
//            FileWriter fileWriter = new FileWriter(filePath);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(content);
//            bufferedWriter.close();
//        } catch (Exception e) {
//            return false;
//        }
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
//        return true;
    }

    public static String[] FileList(String filePath){
        File file = new File(filePath);
        return file.list();
    }


}
