package _024_savingObject;

/* 
Сохраняем объект в БД
*/

import jakarta.persistence.*;

import java.time.Instant;
import java.time.ZonedDateTime;

//напишите тут ваш код
@Entity
@Table(name = "time_table", schema = "test")
public class TimeClass {
    //напишите тут ваш код
    @Id
    private Long id;
    @Column(name = "instant")
    private Instant instant;
    @Basic
    @Column(name = "zoned_time")
    private ZonedDateTime zonedDateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public Long getId() {
        return id;
    }

    public Instant getInstant() {
        return instant;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}