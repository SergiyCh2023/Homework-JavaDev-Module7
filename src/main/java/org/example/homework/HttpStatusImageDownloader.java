package org.example.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.homework.Utils.*;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws Exception {
        String url = new HttpStatusChecker().getStatusImage(code);
        try(InputStream in = new URL(url).openStream()) {
            File image = null;
            String path = DIRECTORY_FOR_SAVE + "\\image"+ code + EXTENSION;
            if (!(image = new File(path)).exists()) {
                Files.copy(in,  Paths.get(path));
            } else {
                System.out.println(String.format(FILE_ALREADY_EXIST_TEXT, code));
            }
        } catch(Exception e) {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        }
    }
}


