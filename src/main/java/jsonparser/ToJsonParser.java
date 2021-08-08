package jsonparser;

import util.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToJsonParser implements Parser {
    List<User> users;

    public ToJsonParser() {
        users = new ArrayList<>();
    }

    @Override
    public void parseFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                if (!line.isEmpty() && count > 1) {
                    String[] arr = line.split(" ");
                    users.add(new User(arr[0], Integer.parseInt(arr[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJson(File file) {
        try (PrintWriter writer = new PrintWriter(file);) {
            writer.write("[\n");
            for (User user : users) {
                writer.write(user.toString());
            }
            writer.write("\n]");
            writer.flush();
            writer.close();
            System.out.println("Writing to JSON completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isAcceptableLine(String line) {
        return false;
    }

    public static void main(String[] args) {
        ToJsonParser parser = new ToJsonParser();
        parser.parseFile(new File("src/main/resources/file_json.txt"));
        parser.writeJson(new File("src/main/resources/file_json.json"));
    }
}
