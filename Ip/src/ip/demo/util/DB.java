package ip.demo.util;

import com.mysql.jdbc.Driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Vector;

/**
 * Created by Administrator on 14-6-7.
 */
public class DB {

    private static final String URL = "jdbc:mysql:///test?user=root&password=123456&rewriteBatchedStatements=true";
    private static final String SQL = "insert into ip values(?, ?, ?)";
    private static Vector<String[]> records = new Vector<String[]>();

    public static void main(String[] args) throws Exception {
        parseFile();
        long start = System.currentTimeMillis();
        dump(records);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    private static void dump(Vector<String[]> records) throws Exception {
        new Driver();
        Connection connection = DriverManager.getConnection(URL);
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        for (String[] record : records) {
            for (int i = 0; i < 3; i++) {
                preparedStatement.setString(i + 1, record[i]);
            }
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }

    private static void parseFile() throws Exception {
        File file = new File("Ip/data/ip.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            records.add(line.split("\\s+", 3));
        }
        System.out.println(records.size());
        bufferedReader.close();
    }
}
