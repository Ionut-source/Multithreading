package ro.ctrln.java.concurrency;

import ro.ctrln.java.concurrency.model.AppTimerTask;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Timer;

public class AppTimer {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        AppTimerTask appTimerTask = new AppTimerTask();

        timer.schedule(appTimerTask, 1000);
        Thread.sleep(3000);

        timer.schedule(appTimerTask, Date.from(LocalDate.of(2021, 03, 01).atStartOfDay().toInstant(ZoneOffset.UTC)));

        timer.schedule(appTimerTask, Date.from(LocalDate.of(2021, 03, 01).atStartOfDay().toInstant(ZoneOffset.UTC)), 5000);

        timer.scheduleAtFixedRate(appTimerTask, 1000L, 1000L * 60L * 60L * 24L * 7L);
        timer.cancel();
    }
}

