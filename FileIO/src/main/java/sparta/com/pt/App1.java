package sparta.com.pt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class App1 {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("src/main/resources/employees-corrupted.cs"))){
            bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //This should be replaced with more robust logging
        } catch (IOException e) {
            e.printStackTrace(); //This should be replaced with more robust logging
        } catch (Exception e) {
            e.printStackTrace(); //This should be replaced with more robust logging
        } finally {

        }

    }
}
