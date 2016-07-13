package org.group5;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

/**
 * Created by Bijay on 7/12/2016.
 */
public class Utility {

    private static String PATH = Utility.class.getResource("/static/uploads/").getPath(); //System.getProperty("user.dir");

    public static String uploadImage(MultipartFile file){
        String fileName = null;
        if (!file.isEmpty()) {
        try {
            fileName = new Random().nextInt(10000) + " - " +file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream buffStream =
                    new BufferedOutputStream(new FileOutputStream(new File(PATH + fileName)));
            buffStream.write(bytes);
            buffStream.close();
            return fileName;
        } catch (Exception e) {
            return "";
        }
    } else {
        return "";
    }}

    public static void log(Object o){
        System.out.println(o);
    }

    public static String getImage(String file){
        return PATH + file;
    }
}
