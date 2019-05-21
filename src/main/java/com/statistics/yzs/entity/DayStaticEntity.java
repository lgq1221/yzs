package com.statistics.yzs.entity;

import com.statistics.yzs.utils.DateUtil;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-15 10:35
 **/
@Entity
@Data
@Table(name="daily_stat")
public class DayStaticEntity implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "daily_activity")
    private long dailyActivity;

    @Column(name = "prescription_retail_activity")
    private long prescriptionRetailActivity;

    @Column(name = "prescription_activity")
    private long prescriptionActivity;

    @Column(name = "retail_activity")
    private long retailActivity;

    @Column(name = "repetition_activity")
    private long repetitionActivity;

    @Column(name = "behavior_activity")
    private long behaviorActivity;

    @Column(name = "date_created")
    private LocalDate dateCreated = LocalDate.now();

    @Column(name = "week_day")
    private String weekDay = DateUtil.getWeekDay(new Date());
}
