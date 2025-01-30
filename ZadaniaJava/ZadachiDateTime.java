import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class DateTimeTasks {

    public static void main(String[] args) {
        // Задача 1
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Текущая дата и время: " + currentDate.atTime(currentTime).format(formatter));

        // Задача 2
        LocalDate date1 = LocalDate.of(2023, 10, 1);
        LocalDate date2 = LocalDate.of(2023, 10, 15);
        System.out.println(compareDates(date1, date2));

        // Задача 3
        System.out.println("Дней до Нового года: " + daysUntilNewYear());

        // Задача 4
        System.out.println("2024 год високосный? " + isLeapYear(2024));

        // Задача 5
        System.out.println("Количество выходных в октябре 2023: " + countWeekends(2023, 10));

        // Задача 6
        measureExecutionTime();

        // Задача 7
        String dateStr = "15-10-2023";
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate newDate = date.plusDays(10);
        System.out.println("Новая дата: " + newDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        // Задача 8
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime moscowTime = convertToTimeZone(utcTime, "Europe/Moscow");
        System.out.println("Время в Москве: " + moscowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        // Задача 9
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        System.out.println("Возраст: " + calculateAge(birthDate) + " лет");

        // Задача 10
        printMonthCalendar(2023, 10);

        // Задача 11
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        System.out.println("Случайная дата: " + generateRandomDate(startDate, endDate));

        // Задача 12
        LocalDateTime eventDateTime = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        System.out.println("До события осталось: " + timeUntilEvent(eventDateTime));

        // Задача 13
        LocalDateTime startWork = LocalDateTime.of(2023, 10, 16, 9, 0);
        LocalDateTime endWork = LocalDateTime.of(2023, 10, 16, 18, 0);
        System.out.println("Рабочих часов: " + calculateWorkingHours(startWork, endWork));

        // Задача 14
        LocalDate today = LocalDate.now();
        System.out.println("Дата на русском: " + formatDateWithLocale(today, new Locale("ru")));

        // Задача 15
        System.out.println("День недели: " + getDayOfWeekInRussian(today));
    }

    // Задача 2
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return "Первая дата раньше второй";
        } else if (date1.isAfter(date2)) {
            return "Первая дата позже второй";
        } else {
            return "Даты равны";
        }
    }

    // Задача 3
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

    // Задача 4
    public static boolean isLeapYear(int year) {
        return Year.of(year).isLeap();
    }

    // Задача 5
    public static int countWeekends(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        int weekends = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                weekends++;
            }
        }
        return weekends;
    }

    // Задача 6
    public static void measureExecutionTime() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            // Пустой цикл для примера
        }
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) + " наносекунд");
    }

    // Задача 8
    public static ZonedDateTime convertToTimeZone(ZonedDateTime dateTime, String zoneId) {
        return dateTime.withZoneSameInstant(ZoneId.of(zoneId));
    }

    // Задача 9
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Задача 10
    public static void printMonthCalendar(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            String dayType = (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) ? "Выходной" : "Рабочий день";
            System.out.println(date + " - " + dayType);
        }
    }

    // Задача 11
    public static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = new Random().nextInt((int) daysBetween);
        return startDate.plusDays(randomDays);
    }

    // Задача 12
    public static String timeUntilEvent(LocalDateTime eventDateTime) {
        Duration duration = Duration.between(LocalDateTime.now(), eventDateTime);
        return duration.toHours() + " часов, " + duration.toMinutes() % 60 + " минут, " + duration.getSeconds() % 60 + " секунд";
    }

    // Задача 13
    public static long calculateWorkingHours(LocalDateTime startWork, LocalDateTime endWork) {
        return Duration.between(startWork, endWork).toHours();
    }

    // Задача 14
    public static String formatDateWithLocale(LocalDate date, Locale locale) {
        return date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", locale));
    }

    // Задача 15
    public static String getDayOfWeekInRussian(LocalDate date) {
        String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
        return days[date.getDayOfWeek().getValue() - 1];
    }
}
