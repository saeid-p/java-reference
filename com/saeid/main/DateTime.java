package com.saeid.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTime {
        public static void workingWithDates() throws ParseException {
                Instant now = Instant.now();
                Period oneMonthPeriod = Period.ofMonths(1);
                Instant newTime = now.plus(oneMonthPeriod);

                Calendar someDateCalendar = Calendar.getInstance();
                /*
                 * Keep in mind that two important parts of the date/time are not defined:
                 * - Parameters are interpreted within the default timezone
                 * - The milliseconds are not set to zero, but filled from the system clock.
                 */
                someDateCalendar.set(1974, 6, 2, 8, 0, 0);
                Date someDate = someDateCalendar.getTime();

                String formatString = "yyyy/MM/dd hh:mm.ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
                String formattedDate = simpleDateFormat.format(someDate);

                DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
                final String dateStr = "02/25/2016"; // input String
                Date myDate = dateFormat.parse(dateStr);

                LocalDate lDate = LocalDate.now();
                // Creates a date from values
                lDate = LocalDate.of(2017, 12, 15);

                // create a date from string
                lDate = LocalDate.parse("2017-12-15");
                // creates a date from zone
                LocalDate.now(ZoneId.systemDefault());

                // Create a default date time
                LocalDateTime lDateTime = LocalDateTime.now();
                // Creates a date time from values
                lDateTime = LocalDateTime.of(2017, 12, 15, 11, 30);
                // create a date time from string
                lDateTime = LocalDateTime.parse("2017-12-05T11:30:30");
                // create a date time from zone
                LocalDateTime.now(ZoneId.systemDefault());

                long days = ChronoUnit.DAYS.between(lDateTime, lDate);

                Date date = Date.from(Instant.now());
                ZoneId defaultZoneId = ZoneId.systemDefault();
                // Date to LocalDate
                LocalDate localDate = date.toInstant().atZone(defaultZoneId).toLocalDate();
                // LocalDate to Date
                Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

                LocalTime localTime = LocalTime.now();

                // Date to LocalDateTime
                LocalDateTime localDateTime = date.toInstant().atZone(defaultZoneId).toLocalDateTime();
                // LocalDateTime to Date
                Date out = Date.from(localDateTime.atZone(defaultZoneId).toInstant());

                // Use of Calendar and Date objects
                final Date today = new Date();
                final Calendar calendar = Calendar.getInstance();
                calendar.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
                Date birthdate = calendar.getTime();
                final Calendar calendar2 = Calendar.getInstance();
                calendar2.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
                Date samebirthdate = calendar2.getTime();
                // Before example
                System.out.printf("Is %1$tF before %2$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(today.before(birthdate)));
                System.out.printf("Is %1$tF before %1$tF? %3$b%n", today, today, Boolean.valueOf(today.before(today)));
                System.out.printf("Is %2$tF before %1$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(birthdate.before(today)));
                // After example
                System.out.printf("Is %1$tF after %2$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(today.after(birthdate)));
                System.out.printf("Is %1$tF after %1$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(today.after(today)));
                System.out.printf("Is %2$tF after %1$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(birthdate.after(today)));
                // Compare example
                System.out.printf("Compare %1$tF to %2$tF: %3$d%n", today, birthdate,
                                Integer.valueOf(today.compareTo(birthdate)));
                System.out.printf("Compare %1$tF to %1$tF: %3$d%n", today, birthdate,
                                Integer.valueOf(today.compareTo(today)));
                System.out.printf("Compare %2$tF to %1$tF: %3$d%n", today, birthdate,
                                Integer.valueOf(birthdate.compareTo(today)));
                // Equal example
                System.out.printf("Is %1$tF == %2$tF? %3$b%n", today, birthdate,
                                Boolean.valueOf(today.equals(birthdate)));
                System.out.printf("Is %1$tF == %2$tF? %3$b%n", birthdate, samebirthdate,
                                Boolean.valueOf(birthdate.equals(samebirthdate)));
                System.out.printf(
                                "Because birthdate.getTime() -> %1$d is different from samebirthdate.getTime() -> %2$d, there are millisecondes!%n",
                                Long.valueOf(birthdate.getTime()), Long.valueOf(samebirthdate.getTime()));
                // Clear ms from calendars
                calendar.clear(Calendar.MILLISECOND);
                calendar2.clear(Calendar.MILLISECOND);
                birthdate = calendar.getTime();
                samebirthdate = calendar2.getTime();
                System.out.printf("Is %1$tF equal to %2$tF after clearing ms? %3$b%n", birthdate, samebirthdate,
                                Boolean.valueOf(birthdate.equals(samebirthdate)));

                // Use of LocalDate
                final LocalDate localNow = LocalDate.now();
                final LocalDate birthdate2 = LocalDate.of(2012, 6, 30);
                final LocalDate birthdate3 = LocalDate.of(2012, 6, 30);
                System.out.printf("Is %1$tF before %2$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.isBefore(birthdate2)));
                System.out.printf("Is %1$tF before %1$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.isBefore(localNow)));
                System.out.printf("Is %2$tF before %1$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(birthdate2.isBefore(localNow)));
                // isAfter example
                System.out.printf("Is %1$tF after %2$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.isAfter(birthdate2)));
                System.out.printf("Is %1$tF after %1$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.isAfter(localNow)));
                System.out.printf("Is %2$tF after %1$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(birthdate2.isAfter(localNow)));
                // compareTo example
                System.out.printf("Compare %1$tF to %2$tF %3$d%n", localNow, birthdate2,
                                Integer.valueOf(localNow.compareTo(birthdate2)));
                System.out.printf("Compare %1$tF to %1$tF %3$d%n", localNow, birthdate2,
                                Integer.valueOf(localNow.compareTo(localNow)));
                System.out.printf("Compare %2$tF to %1$tF %3$d%n", localNow, birthdate2,
                                Integer.valueOf(birthdate2.compareTo(localNow)));
                // equals example
                System.out.printf("Is %1$tF equal to %2$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.equals(birthdate2)));
                System.out.printf("Is %1$tF to %2$tF? %3$b%n", birthdate2, birthdate3,
                                Boolean.valueOf(birthdate2.equals(birthdate3)));
                // isEqual example
                System.out.printf("Is %1$tF equal to %2$tF? %3$b%n", localNow, birthdate2,
                                Boolean.valueOf(localNow.isEqual(birthdate2)));
                System.out.printf("Is %1$tF to %2$tF? %3$b%n", birthdate2, birthdate3,
                                Boolean.valueOf(birthdate2.isEqual(birthdate3)));

                ZoneId zoneId = ZoneId.of("UTC+2");
                ZonedDateTime dateTime = ZonedDateTime.of(2016, 5, 27, 7, 0, 0, 235, zoneId);
                ZonedDateTime composition = ZonedDateTime.of(localDate, localTime, zoneId);
                ZonedDateTime nowWithTimeZone = ZonedDateTime.now(); // Default time zone
                ZonedDateTime parsed = ZonedDateTime.parse("2016-07-27T07:00:00+01:00[Europe/Stockholm]");

                ZoneOffset zoneOffset = ZoneOffset.ofHours(2);
                OffsetDateTime dateTimeWithZone = OffsetDateTime.of(2016, 7, 27, 7, 0, 0, 235, zoneOffset);
                OffsetDateTime compositionWithZone = OffsetDateTime.of(localDate, localTime, zoneOffset);
                OffsetDateTime nowWithZone = OffsetDateTime.now(); // Offset taken from the default ZoneId
                OffsetDateTime parsedWithZone = OffsetDateTime.parse("2016-07-27T07:00:00+02:00");

        }
}