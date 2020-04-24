package com.example.inputexperiment01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        tv=findViewById (R.id.textv);

       try {
            Ardore.salvaf (this,"Mi piace la pasta tanto tanto");
        } catch (IOException e) {
            e.printStackTrace ();
        }

        String h="";
        try {
            h= Ardore.leggi (this);
        } catch (IOException e) {
            e.printStackTrace ();
        }
        tv.setText (h);

    }

    public void salvaf( String message ) throws IOException {
       File file = new File ( "Marco.txt");
        String filename = file.getPath ();
         FileOutputStream fos = openFileOutput (filename,Context.MODE_PRIVATE );
        fos.write (message.getBytes ());
        fos.close ();


    }



    public String leggi() throws FileNotFoundException {
        File file = new File ( "Marco.txt");
        String y=file.getPath ();
        FileInputStream fis = MainActivity.this.openFileInput(y.toString ());
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
