package _026_saveAudioFile;

/* 
Сохранить аудио файл в БД
*/

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import java.util.Map;

//напишите тут ваш код
@Entity
@Table(name = "audio_table", schema = "test")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Audio {
    @Id
    private  Long id;
    @Column(name = "file_name")
    private String  fileName;
    @Lob
    @Column(name = "audio_file")
    private byte[] audioFile;
   @Type(type = "json")
   @Column(name = "file_meta")
    private Map<String, String> fileProperties;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setAudioFile(byte[] audioFile) {
        this.audioFile = audioFile;
    }

    public void setFileProperties(Map<String, String> fileProperties) {
        this.fileProperties = fileProperties;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getAudioFile() {
        return audioFile;
    }

    public Map<String, String> getFileProperties() {
        return fileProperties;
    }
}
