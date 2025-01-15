package com.example.filechoser;

import android.os.Bundle;
import android.widget.BaseAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get //root

        sarchfile("root",0);
        Chooserfile chfile ;

    }



    List<String> listFF=new ArrayList<>();
    List<List<String>> lesfiles=new ArrayList<>();
    public void sarchfile(String lesdosiers, int level){
        List<String> lisx = new ArrayList<>();
        lisx.add("0");lisx.add("1");lisx.add("F");

        File file = new File(lesdosiers);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {

                lisx.set(0, String.valueOf(level));
                lisx.set(1, files[i].getName());

                if (files[i].isDirectory()) {
                    lisx.set(2,"D");}
                else{lisx.set(2,"F");}
                lesfiles.add(new ArrayList<>(lisx) );

                if (files[i].isDirectory()) {
                    sarchfile(files[i].getAbsolutePath(),level+1);
                }


            }
        }
    }
}