package _026_saveAudioFile;

/* 
Сохранить аудио файл в БД
**
Add private fields to the public Audio classid (Long),fileName(String),audioFile(byte[])AndfileProperties(Map<String, String>).
The Audio class must have @Entity and @Table annotations (table name audio_table, schema - test).
All fields must have getters and setters.
All fields must have appropriate annotations.
By the field idThe @Id annotation must be present .
By the field fileName there must be a @Column annotation that specifies the column name "file_name".
By the field audioFileThe @Lob and @Column annotations must be present , which specifies the column name "audio_file".
By the field fileProperties there must be @Type annotations with the type "json" and @Column , which specifies the column name "file_meta".
In the saveAudioFile method of the Solution class , save the Audio class object and commit it using the getSessionFactory and getAudioBuffer methods .
The id number, file name and meta data are not included in testing.
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {
    public static void main(String[] args) {
        saveAudioFile();
    }

    public static void saveAudioFile() {

        Audio audio = new Audio();
        audio.setId(1L);
        audio.setFileName("name01");
        audio.setAudioFile(getAudioBuffer());
        audio.setFileProperties(null);

        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(audio);

        transaction.commit();
        session.close();
        sessionFactory.close();


    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.HBM2DDL_AUTO, "update");

        return new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Audio.class)
                .buildSessionFactory();
    }

    public static byte[] getAudioBuffer() {
        byte[] audioBuffer;
        try {
            audioBuffer = Files.readAllBytes(Paths.get("sound.wav"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return audioBuffer;
    }
}
