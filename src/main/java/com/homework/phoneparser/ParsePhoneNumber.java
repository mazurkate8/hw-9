package com.homework.phoneparser;

import com.homework.util.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

public class ParsePhoneNumber implements Parser {
    private File file;
    private final List<String> phoneList;
    private static final String PHONE_PATTERN
            = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-.]?\\d{4}$";

    public ParsePhoneNumber() {
        this.phoneList = new ArrayList<>();
    }

    @Override
    public void parseFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
               if(isAcceptableLine(line)){
                   phoneList.add(line);
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAcceptableLine(final String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public void printAcceptablePhoneNumbers() {
        System.out.println(phoneList);
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public static void main(String[] args) {
        ParsePhoneNumber phones = new ParsePhoneNumber();
        phones.parseFile(new File("src/main/resources/file.txt"));
        phones.printAcceptablePhoneNumbers();
    }
}
