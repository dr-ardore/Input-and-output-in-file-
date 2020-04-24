package com.example.inputexperiment01;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Ardore extends AppCompatActivity {

    public static void salvaf( Context context, String message ) throws IOException {
        File file = new File ( "Marco.txt");
        String filename = file.getPath ();
        FileOutputStream fos = context.openFileOutput (filename, Context.MODE_PRIVATE );
        fos.write (message.getBytes ());
        fos.close ();
    }

    public static String leggi(Context context) throws FileNotFoundException {
        File file = new File ( "Marco.txt");
        String y=file.getPath ();
        FileInputStream fis =context .openFileInput(y.toString ());
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();

            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {

        }
        return  stringBuilder.toString();
    }





}
