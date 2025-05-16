package utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) throws URISyntaxException, IOException {

        final Long MAX_FILE_SIZE_Byte = 10L << 20;
        System.out.println("MAX_FILE_SIZE_Byte = " + MAX_FILE_SIZE_Byte);
    }
}
