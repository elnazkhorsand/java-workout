package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoader {
    public String readHelloWorld() throws IOException {
        return Files.readString(Paths.get("src/main/resources/hello.txt"));
    }

    public Boolean fileContainsText(String filename, String expectedText) throws IOException {
        try {
            String path = "src/main/resources/" + filename;

            String fileContent = Files.readString(Paths.get(path));

            if (fileContent.isEmpty())
                throw new FileLoaderException("Oops!The file is empty!");
            else return fileContent.contains(expectedText);
        }
        catch (NoSuchFileException noFileExist){
            return false;
        }
        catch (IOException ioException){
            throw new IOException("An Unknown Exception happened!", ioException);
        }
        finally {
            System.out.println("Checking the content of: " + filename);
        }
    }

    public Boolean fileHasText(String filename, String expectedText) throws IOException {
        try {
            String path = "src/main/resources/" + filename;
            String content = Files.readString(Paths.get(path));

            return content.contains(expectedText);
        }
        catch (NoSuchFileException noSuchFileException){
            throw new MissingWelcomeFileException("Oops! The file does not exist!", noSuchFileException);
        }
        catch (IOException ioException){
            throw new IOException("This is an unknown exception", ioException);
        }
    }
}
