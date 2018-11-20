package app.controllers;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.view.CalendarView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class TimetableController implements Initializable {


  private CalendarView calendar;

  @FXML
  private GridPane pnlHost;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    loadCalendar();
  }

  private void loadCalendar() {
    calendar = new CalendarView();

    Calendar away = new Calendar("Away");
    Calendar home = new Calendar("Home");

    away.setStyle(Calendar.Style.STYLE7);
    home.setStyle(Calendar.Style.STYLE2);

    CalendarSource myCalendarSource = new CalendarSource("Timetable");
    myCalendarSource.getCalendars().addAll(away, home);

    calendar.getCalendarSources().addAll(myCalendarSource);

    calendar.setRequestedTime(LocalTime.now());

    Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
      @Override
      public void run() {
        while (true) {
          Platform.runLater(() -> {
            calendar.setToday(LocalDate.now());
            calendar.setTime(LocalTime.now());
          });

          try {
            // update every 10 seconds
            sleep(10000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }
      }
    };

    updateTimeThread.setPriority(Thread.MIN_PRIORITY);
    updateTimeThread.setDaemon(true);
    updateTimeThread.start();

    calendar.showMonthPage();
    pnlHost.getChildren().add(calendar);
  }


}
