package com.app.audioplayer;

import javafx.concurrent.Task;

import java.io.File;

public class AudioCollector extends Task {
    private void collect(File f) {
        String[] validExtensions = {".mp3", ".m4a"};
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String path = file.getPath();
                    if (path.endsWith(validExtensions[0]) || path.endsWith(validExtensions[1])) {
                        try {
                            AudioRepository.getInstance().addAudio(path);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }
                } else if (file.isDirectory()) {
                    collect(file);
                } else {
                    System.out.println("other type of files");
                }
            }
        }
    }

    @Override
    protected Object call() {
        File[] roots = {new File("C://Users//m"), new File("D://")};
        for (File file : roots)
            collect(file);
        return this;
    }
}
