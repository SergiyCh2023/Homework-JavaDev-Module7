package org.example.homework;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private static final String ERROR = "There is not image for HTTP status ";

   public void askStatus() throws Exception {


        int statusCode = -1;
        try {
            Scanner console = new Scanner(System.in);
            System.out.println("Please, enter HTTP status code");
           statusCode = console.nextInt();
                new HttpStatusChecker().getStatusImage( statusCode);
                new HttpStatusImageDownloader().downloadStatusImage(statusCode);

        } catch (InputMismatchException ime) {
            System.out.println("Please enter valid number");

        }  catch (FileNotFoundException ex) {
            System.out.println(ERROR + statusCode);
        }

    }


}
