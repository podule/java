package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MessagesHistory {

    private String filePath = "./file.txt";
    private FileWriter writer = null;
    private BufferedWriter bufferWriter;

    public String getLastMessages() {
        StringBuilder s = new StringBuilder();
        try {
            Process p = Runtime.getRuntime().exec("tail -100" + new File(filePath));
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = input.readLine()) != null) {
                s.append(line + '\n');
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(s);
    }

    public void readMessageHistory(String message) {
        try {
            writer = new FileWriter(filePath, true);
            bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(message);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
