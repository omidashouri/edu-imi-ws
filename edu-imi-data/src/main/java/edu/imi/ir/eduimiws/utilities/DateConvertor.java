package edu.imi.ir.eduimiws.utilities;

import com.ghasemkiani.util.DateFields;
import com.ghasemkiani.util.SimplePersianCalendar;
import com.ghasemkiani.util.icu.PersianCalendar;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@MappingUtil.DateConvertor
@Component
@Slf4j
public class DateConvertor {

    public Date convertKhToGeorgianDate(String date) {
        Optional<String> miladiDate = null;
        if (date == null) {
            return null;
        }
        miladiDate = Optional.ofNullable(this.convertKhToMi(date));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Optional<Date> georgianDate = null;
        try {
            if (miladiDate != null) {
                georgianDate = Optional.of(dateFormat.parse(miladiDate.get()));
            }
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return georgianDate.orElse(null);
    }

    public String convertKhToMi(String date) {

        PersianCalendar persianCalendar = new PersianCalendar(1391, 8, 20);

        SimplePersianCalendar simplePersianCalendar = new SimplePersianCalendar();
        simplePersianCalendar.setDateFields(new DateFields(1399, 8, 12));
        simplePersianCalendar.getGregorianChange();

        String[] s = date.split("/");
        String finalDate = "";
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else
                    finalDate = convertKhToMi(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
        }

        return finalDate;
    }

    public String convertKhToMi1(String date) {
        String[] s = date.split("/");
        String finalDate = "";
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else
                    finalDate = convertKhToMi(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
        }

        return finalDate;
    }


    public String convertMiToKh(String date) {
        String[] s = date.split("-");
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else
                    convertMiToKh(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            } else
                return null;
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
        }

        return convertMiToKh(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
    }


    public String convertMiToKh1(String date)//****************MM/dd/yyyy
    {
        String[] s = date.split("/");
        String ret = "";
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else if (s[2].length() > 2)
                    ret = convertMiToKh(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
                else
                    ret = convertMiToKh(Integer.parseInt("20" + s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            } else
                return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return ret;
    }

    public String convertMiToKh2(String date)//****************yyyy/mm/dd
    {
        if (date == null || date.equals(""))
            return "";
        String[] str = date.split("/");
        String[] s = new String[3];
        s[0] = str[1];
        s[1] = str[2];
        s[2] = str[0];
        String ret = "";
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else if (s[2].length() > 2)
                    ret = convertMiToKh(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
                else
                    ret = convertMiToKh(Integer.parseInt("20" + s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            } else
                return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return ret;
    }

    public String dte(String date) {
        String[] s = date.split("/");
        date = s[2];
        s[2] = s[0];
        s[0] = date;
        date = s[0] + "/" + s[1] + "/" + s[2];
        return date;

    }

    public String convertMiToKh3(String date)//****************yyyy/mm/dd
    {
        if (date == null || date.equals(""))
            return "";
        String[] str = date.split("-");
        String[] s = new String[3];
        s[0] = str[1];
        s[1] = str[2];
        s[2] = str[0];
        String ret = "";
        try {
            if (s.length == 3) {
                if (Integer.parseInt(s[0]) < 1 && Integer.parseInt(s[1]) < 1 && Integer.parseInt(s[2]) < 1)
                    return null;
                else if (s[2].length() > 2)
                    ret = convertMiToKh(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
                else
                    ret = convertMiToKh(Integer.parseInt("20" + s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            } else
                return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return ret;
    }

    //#1
    public String convertKhToMi(int year, int month, int day) {

        SimplePersianCalendar c = new SimplePersianCalendar();
        // month : 0 to 11
        c.setDateFields(year, month - 1, day);

        int newYear = c.get(c.ERA) == c.AD ? c.get(c.YEAR) : -(c.get(c.YEAR) - 1);
        int newMonth = c.get(c.MONTH) + 1;
        int newDay = c.get(c.DAY_OF_MONTH);

        String sNewMonth = "" + newMonth;
        String sNewDay = "" + newDay;
        if (newMonth < 10)
            sNewMonth = "0" + newMonth;
        if (newDay < 10)
            sNewDay = "0" + newDay;
        return newYear + "-" + sNewMonth + "-" + sNewDay;

    }


    public String convertMiToKh(int year, int month, int day) {
        SimplePersianCalendar persianCalendar = new SimplePersianCalendar();
        persianCalendar.set(persianCalendar.YEAR, year);
        // month : 0 to 11
        persianCalendar.set(persianCalendar.MONTH, month - 1);
        persianCalendar.set(persianCalendar.DAY_OF_MONTH, day);
        DateFields dateFields = persianCalendar.getDateFields();
        int newMonth = dateFields.getMonth() + 1;

        String sNewDay = "" + dateFields.getDay();
        if (dateFields.getDay() < 10) {
            sNewDay = "0" + dateFields.getDay();
        }
        String sNewMonth = "" + newMonth;
        if (newMonth < 10) {
            sNewMonth = "0" + newMonth;
        }
        return dateFields.getYear() + "/" + sNewMonth + "/" + sNewDay;
    }

    public String todayDate() {
        Calendar c = Calendar.getInstance();
        Date todayDate = new Date(c.getTimeInMillis());
        String sDate = todayDate.toString();
        String[] mDate = sDate.split("-");
        return this.convertMiToKh(Integer.parseInt(mDate[0]), Integer.parseInt(mDate[1]), Integer.parseInt(mDate[2]));
    }

    @MappingUtil.JalaliDateFromLocalDateTime
    public String jalaliDateFromLocalDateTime(LocalDateTime localDateTime) {
        String georgianDate = localDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        String[] mDate = georgianDate.split("-");
        return this.convertMiToKh(Integer.parseInt(mDate[0]), Integer.parseInt(mDate[1]), Integer.parseInt(mDate[2]));
    }

    @MappingUtil.TimeFromLocalDateTime
    public String timeFromLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("HH:MM:SS"));
    }

    @MappingUtil.XMLGregorianCalendarToJalaliDate
    public String XMLGregorianCalendarToJalaliDate(XMLGregorianCalendar inputGregorianDate) {

        String jalaliDate = null;
        try {
            if (inputGregorianDate == null) {
                return jalaliDate;
            }

            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tehran");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            sdf.setTimeZone(timeZone);
            Date gregorianDate = null;

            gregorianDate = sdf.parse(inputGregorianDate.toString());

            PersianCalendar persianCalendar = new PersianCalendar(gregorianDate);
            int persianYear = persianCalendar.get(PersianCalendar.YEAR);
            int persianMonth = persianCalendar.get(PersianCalendar.MONTH) + 1;
            int persianDay = persianCalendar.get(PersianCalendar.DAY_OF_MONTH);

            jalaliDate = persianYear + "/" + String.format("%02d", persianMonth) + "/" + String.format("%02d", persianDay);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jalaliDate;
    }

    //#1
    public String todayDateMiladi() {
        Calendar c = Calendar.getInstance();
        Date todayDate = new Date(c.getTimeInMillis());
        String sDate = todayDate.toString();
        String[] mDate = sDate.split("-");
        return mDate[0] + "/" + mDate[1] + "/" + mDate[2];
    }

    public String getYear() {
        Calendar c = Calendar.getInstance();
        Date todayDate = new Date(c.getTimeInMillis());
        String sDate = todayDate.toString();
        String[] mDate = sDate.split("-");
        String khDate = convertMiToKh(Integer.parseInt(mDate[0]), Integer.parseInt(mDate[1]), Integer.parseInt(mDate[2]));
        String[] mDate1 = khDate.split("/");
        return mDate1[0];
    }

/*    public String getThisTime() {
        Calendar c = Calendar.getInstance();
        Long hour = (long) c.getTime().getHours();
        Long minute = (long) c.getTime().getMinutes();
        Long second = (long) c.getTime().getSeconds();
        String ho = hour.toString();
        String min = minute.toString();
        String sec = second.toString();
        if (c.get(Calendar.AM_PM) == 0)
            ;
        else
            hour += 12;
        if (hour < 10)
            ho = "0" + ho;
        if (minute < 10)
            min = "0" + min;
        if (second < 10)
            sec = "0" + sec;
        return ho + ":" + min + ":" + sec;
    }*/

    public String ConvertMiladyToFavoriteFormat(java.util.Date inputDate, String Format) {
        int dayNumber = inputDate.getDay();
        String[] toadays =
                {"يكشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه", "شنبه"};
        String dayOfWeek = "";
        for (int i = 0; i < 7; i++) {
            if (dayNumber == i)
                dayOfWeek = toadays[i];
        }
        // /////
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = dateFormat.format(inputDate);
        String[] mDate = sDate.split("-");
        DateConvertor dateConvertor = new DateConvertor();
        String khDate = dateConvertor.convertMiToKh(Integer.parseInt(mDate[0]), Integer.parseInt(mDate[1]), Integer.parseInt(mDate[2]));
        String[] khDates = khDate.split("/");

        int intmonth = Integer.parseInt(khDates[1]);
        String[] khmonthYear =
                {"يكشنبه", "دوشنبه", "سه شنبه", "چهارشنبه", "پنج شنبه", "جمعه", "شنبه"};
        String monthYear = "";
        for (int i = 1; i < 13; i++) {
            if (intmonth == i)
                monthYear = khmonthYear[i - 1];
        }

        return dayOfWeek + " " + khDates[2] + " " + monthYear + " " + khDates[0];
    }

    public String ConvertMiladyToFavoriteFormat_(java.util.Date inputDate, String Format) {
        int dayNumber = inputDate.getDay();
        String[] toadays =
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String dayOfWeek = "";
        for (int i = 0; i < 7; i++) {
            if (dayNumber == i)
                dayOfWeek = toadays[i];
        }
        // /////
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = dateFormat.format(inputDate);
        String[] sDates = sDate.split("-");

        int intmonth = Integer.parseInt(sDates[1]);
        String[] khmonthYear =
                {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String monthYear = "";
        for (int i = 1; i < 13; i++) {
            if (intmonth == i)
                monthYear = khmonthYear[i - 1];
        }

        return dayOfWeek + ", " + monthYear + " " + sDates[2] + ", " + sDates[0];
    }

    public String numberToString(String number) {
        String[] a =
                {"", "يك", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه"};
        String[] b =
                {"ده ", "يازده", "دوازده", "سيزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده"};
        String[] c =
                {" ", " ", "بيست", "سي", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};
        String[] d =
                {" ", "صد", "دويست", "سيصد", "چهارصد", "پانصد", "ششصد", "هفتصد", "هشتصد", "نهصد"};
        String[] e =
                {"", "هزار", "ميليون", "ميليارد", "بيليارد"};
        String input = number;
        String finall = " ";
        int m = 0;
        for (int n = 0; n < input.length(); n += 3) {
            int inputIndex = 0;
            if ((input.length() - (n + 3)) > 0)
                inputIndex = (input.length() - (n + 3));
            String length3 = input.substring(inputIndex, (input.length() - n));
            String length4 = input.substring(inputIndex, (input.length() - n));
            int length3Index = 0;
            if ((length3.length() - (2)) > 0)
                length3Index = (length3.length() - (2));
            String length2 = length3.substring(length3Index, (length3.length()));
            String length5 = input.substring(0, inputIndex);
            int inputNumber = Integer.parseInt(length2);
            String inputTxt = Integer.valueOf(length2).toString();
            if (inputNumber == 0 && length3.charAt(0) == '0' && length5.length() == 0) {
                m++;
                continue;
            }
            int d2Index = 0;
            if (inputTxt.length() - 2 > 0)
                d2Index = inputTxt.length() - 2;
            int d3Index = 0;
            if (length3.length() - 3 > 0)
                d3Index = length3.length() - 3;
            String d1 = "" + inputTxt.charAt(inputTxt.length() - 1);
            String d2 = "" + inputTxt.charAt(d2Index);
            String d3 = "" + length3.charAt(d3Index);
            String yekan = "";
            String dahgan = "";
            String sadgan = "";
            String total = "";
            String total1 = "";
            if (inputTxt.length() == 1) {
                for (int h = 0; h < a.length; h++) {
                    if (Integer.parseInt(d1) == h) {
                        total = a[h];
                        break;
                    }
                }
            } else if (Integer.parseInt(d2) >= 2) {
                for (int i = 0; i < a.length; i++) {
                    if (Integer.parseInt(d1) == i) {
                        yekan = a[i];
                        break;
                    }
                }
                for (int j = 0; j < c.length; j++) {
                    if (Integer.parseInt(d2) == j) {
                        dahgan = c[j];
                        if (!yekan.equals(""))
                            total = dahgan + " و" + yekan;
                        else
                            total = dahgan;
                        break;
                    }
                }
            } else {
                int k;
                for (k = 0; k < b.length; k++) {
                    if (Integer.parseInt(d1) == k) {
                        yekan = b[k];
                        break;
                    }
                }
                total = b[k];
            }
            if (length4.length() == 3 && length4.charAt(0) != '0') {
                for (int p = 0; p < d.length; p++) {
                    if (Integer.parseInt(d3) == p) {
                        sadgan = d[p];
                        if (!total.equals(""))
                            total1 = sadgan + " و" + total;
                        else
                            total1 = sadgan;
                        break;
                    }
                }
            } else {
                total1 = total;
            }
            String total3 = "";
            String re = "";
            if (total1.length() - 2 >= 0)
                re = "" + total1.charAt(total1.length() - 2);
            if (re.equals(" ")) {
                total3 = total1.substring(0, (total1.length() - 2));
            } else {
                total3 = total1;
            }
            if (!finall.equals(" "))
                if (!finall.equals("") && !total3.equals(""))
                    finall = total3 + " " + e[m] + " و" + finall;
                else if (finall.equals("") && !total3.equals(""))
                    finall = total3 + " " + e[m];
                else if (!finall.equals("") && total3.equals(""))
                    finall = finall;
                else
                    finall = total3;
            else
                finall = total3;
            m++;
        }
        return finall;
    }

/*    public String dateAdd(String currentDate, int add) {
        String miladiDate = convertKhToMi(currentDate);

        try {
            String[] all = miladiDate.split("-");
            Date mil = new Date(Integer.parseInt(all[0]) - 1900, Integer.parseInt(all[1]) - 1, Integer.parseInt(all[2]));
            mil.setDate(mil.getDate() + add);
            currentDate = convertMiToKh(mil.toString());
        } catch (Exception ex) {
            if (add > 0)
                currentDate = dateAdd(currentDate, add - 1);
        }

        return currentDate;
    }

    public String dateAddMi(String currentDate, int add) {
        String miladiDate = currentDate;

        try {
            String[] all = miladiDate.split("-");
            Date mil = new Date(Integer.parseInt(all[0]) - 1900, Integer.parseInt(all[1]) - 1, Integer.parseInt(all[2]));
            mil.setDate(mil.getDate() + add);
            currentDate = mil.toString();
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return currentDate;
    }*/

    public Long DateDifferent(String startDate, String endDate, String type) {

        String year, month, day;
        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        stringDate = new String[startDate.split(
                "-").length];

        stringDate = startDate.split("-");

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];
        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        stringDate = endDate.split("-");

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];

        calendar2.set(new Integer(year), new Integer(month), new Integer(day));
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (type.equals("d"))
            return diffDays;
        else if (type.equals("h"))
            return diffHours;
        else if (type.equals("m"))
            return diffMinutes;
        else return diffSeconds;

    }

    public Long DateDifferent(String startDate, String endDate, String type, String splitChar) {

        String year, month, day;
        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        stringDate = new String[startDate.split(
                splitChar).length];

        stringDate = startDate.split(splitChar);

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];
        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        stringDate = endDate.split(splitChar);

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];

        calendar2.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (type.equals("d"))
            return diffDays;
        else if (type.equals("h"))
            return diffHours;
        else if (type.equals("m"))
            return diffMinutes;
        else return diffSeconds;

    }

    public String NextDateKh(String paramDate) {

        String year, month, day;

        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();

        paramDate = convertKhToMi(paramDate);

        stringDate = new String[paramDate.split(
                "/").length];

        stringDate = paramDate.split("-");

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];
        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        calendar1.add(Calendar.DATE, 1);
        paramDate = calendar1.get(Calendar.YEAR) + "-" + calendar1.get(Calendar.MONTH) + "-" + calendar1.get(Calendar.DATE);
        paramDate = convertMiToKh(paramDate);
        return paramDate;

    }

    public String PreviousDateKh(String paramDate) {

        String year, month, day;

        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();

        paramDate = convertKhToMi(paramDate);

        stringDate = new String[paramDate.split(
                "-").length];

        stringDate = paramDate.split("-");

        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        calendar1.add(Calendar.DAY_OF_YEAR, -1);
        java.util.Date previousDate = calendar1.getTime();
        String result = dateFormat.format(previousDate);


        paramDate = calendar1.get(Calendar.YEAR) + "-" + calendar1.get(Calendar.MONTH) + "-" + calendar1.get(Calendar.DATE);
        paramDate = convertMiToKh(paramDate);
        return paramDate;

    }


    public String ConvertMiladiToShamsiFavoriteFormat(String inputDate, String separator) {
        String year, month, day;

        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();
        stringDate = new String[inputDate.split(
                separator).length];
        stringDate = inputDate.split(separator);
        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];
        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        int dayNumber = 2;
        dayNumber = calendar1.get(Calendar.DAY_OF_WEEK);
        String[] toadays =
                {"دوشنبه", "سه شنبه", "چهارشنبه", "پنجشنبه", "جمعه", "شنبه", "يکشنبه"};
        String dayOfWeek = "";
        for (int i = 1; i <= 7; i++) {
            if (dayNumber == i) {
                dayOfWeek = toadays[i - 1];
                break;
            }
        }
        // /////

        String khDate = convertMiToKh(new Integer(year), new Integer(month), new Integer(day));

        String[] khDates = khDate.split(separator);
        int intmonth = Integer.parseInt(khDates[1]);
        String[] khmonthYear =
                {"فروردين", "ارديبهشت", "خرداد", "تير", "مرداد", "شهريور", "مهر", "آبان", "آذر", "دي", "بهمن", "اسفند"};
        String monthYear = "";
        for (int i = 1; i < 13; i++) {
            if (intmonth == i) {
                monthYear = khmonthYear[i - 1];
                break;
            }
        }

        return dayOfWeek + ";" + khDates[2] + ";" + monthYear + ";" + intmonth + ";" + khDates[0];
    }

    public String ConvertMiladiToMiladiFavoriteFormat(String inputDate, String separator) {
        String year, month, day;

        String[] stringDate = null;
        Calendar calendar1 = Calendar.getInstance();
        stringDate = new String[inputDate.split(
                separator).length];
        stringDate = inputDate.split(separator);
        year = stringDate[0];
        month = stringDate[1];
        day = stringDate[2];
        calendar1.set(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        int dayNumber = 0;
        dayNumber = calendar1.get(Calendar.DAY_OF_WEEK);
        String[] toadays =
                {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String dayOfWeek = "";
        for (int i = 1; i <= 7; i++) {
            if (dayNumber == i) {
                dayOfWeek = toadays[i - 1];
                break;
            }
        }
        // /////

        int intmonth = calendar1.get(Calendar.MONTH);
        String[] khmonthYear =
                {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String monthYear = "";
        for (int i = 1; i < 13; i++) {
            if (intmonth == i) {
                monthYear = khmonthYear[i - 1];
                break;
            }
        }

        return dayOfWeek + ";" + Integer.toString(calendar1.get(Calendar.DATE)) + ";" + monthYear + ";" + intmonth + ";" + Integer.toString(calendar1.get(Calendar.YEAR));
    }

    public String returnDate(Long year, Long month, Long day, String seperator) {
        String ret = "";
        ret = year.toString() + seperator;
        if (month < 10)
            ret = ret + "0" + month.toString() + seperator;
        else
            ret = ret + month.toString() + seperator;
        if (day < 10)
            ret = ret + "0" + day.toString();
        else
            ret = ret + day.toString();
        return ret;
    }

    public String returnKhMonth(Long month) {
        String ret = "";
        if (month == 1) ret = "فروردين";
        else if (month == 2) ret = "ارديبهشت";
        else if (month == 3) ret = "خرداد";
        else if (month == 4) ret = "تير";
        else if (month == 5) ret = "مرداد";
        else if (month == 6) ret = "شهريور";
        else if (month == 7) ret = "مهر";
        else if (month == 8) ret = "آبان";
        else if (month == 9) ret = "آذر";
        else if (month == 10) ret = "دي";
        else if (month == 11) ret = "بهمن";
        else if (month == 12) ret = "اسفند";


        return ret;
    }

    public String returnKhMonthNumber(String month) {
        String ret = "";
        if (month.equalsIgnoreCase("فروردين")) ret = "01";
        else if (month.equalsIgnoreCase("ارديبهشت")) ret = "02";
        else if (month.equalsIgnoreCase("خرداد")) ret = "03";
        else if (month.equalsIgnoreCase("تير")) ret = "04";
        else if (month.equalsIgnoreCase("مرداد")) ret = "05";
        else if (month.equalsIgnoreCase("شهريور")) ret = "06";
        else if (month.equalsIgnoreCase("مهر")) ret = "07";
        else if (month.equalsIgnoreCase("آبان")) ret = "08";
        else if (month.equalsIgnoreCase("آذر")) ret = "09";
        else if (month.equalsIgnoreCase("دي")) ret = "10";
        else if (month.equalsIgnoreCase("بهمن")) ret = "11";
        else if (month.equalsIgnoreCase("اسفند")) ret = "12";


        return ret;
    }

    public String returnMiMonth(Long month) {

        String ret = "";
        if (month == 1) ret = "January";
        else if (month == 2) ret = "February";
        else if (month == 3) ret = "March";
        else if (month == 4) ret = "April";
        else if (month == 5) ret = "May";
        else if (month == 6) ret = "June";
        else if (month == 7) ret = "July";
        else if (month == 8) ret = "August";
        else if (month == 9) ret = "September";
        else if (month == 10) ret = "October";
        else if (month == 11) ret = "November";
        else if (month == 12) ret = "December";

        return ret;
    }

    public String[] getdatePart(String myDate) {
        String[] result = new String[3];
        result[0] = myDate.substring(0, 4);
        result[1] = myDate.substring(5, 7);
        result[2] = myDate.substring(8, 10);

        return result;

    }

    public String[] getMonthBetween2Date(String startDate, String finishDate) {
        String[] monthDate = null;
        try {
            int smonth = Integer.parseInt(startDate.substring(5, 7));
            int fmonth = Integer.parseInt(finishDate.substring(5, 7));
            int syear = Integer.parseInt(startDate.substring(0, 4));
            int fyear = Integer.parseInt(finishDate.substring(0, 4));
            int arrayLen = 0; // for start and end date
            int currentMonth = 0;
            int i, j;
            String temp = "";
            String[] datePart = new String[3];

            if (syear == fyear)
                arrayLen = fmonth - smonth;
            else {
                arrayLen = 12 - smonth;

                arrayLen = arrayLen + fmonth;
                if (fyear - syear > 1)
                    arrayLen = arrayLen + (fyear - syear - 1) * 12;

            }
            arrayLen = arrayLen + 2;
            monthDate = new String[arrayLen];
            monthDate[0] = startDate;
            monthDate[arrayLen - 1] = finishDate;
            if (monthDate.length > 2) {

                currentMonth = smonth;
                datePart = getdatePart(startDate);
                i = arrayLen;
                j = 1;

                while (i > 1) {
                    currentMonth = currentMonth + 1;
                    if (currentMonth < 13) {
                        if (currentMonth < 10)
                            temp = "0" + Integer.toString(currentMonth);
                        else
                            temp = Integer.toString(currentMonth);
                        monthDate[j] = datePart[0] + "/" + temp + "/01";

                    } else {
                        currentMonth = 1;
                        temp = "0" + Integer.toString(currentMonth);
                        datePart[0] = Integer.toString((Integer
                                .parseInt(datePart[0]) + 1));
                        monthDate[j] = datePart[0] + "/" + temp + "/01";
                    }
                    j = j + 1;
                    i = i - 1;
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return monthDate;
    }


    public int getTimeDiffrentBetweenTowTimesInMinute(String StartTime, String endTime) {
        int def = 0;

        try {
            int startTimeInMin = (Long.valueOf(StartTime
                    .split(":")[0]).intValue() * 3600 * 1000)
                    + (Long.valueOf(StartTime
                    .split(":")[1]).intValue() * 60 * 1000);
            int endTimeInMin = (Long.valueOf(
                            endTime.split(":")[0])
                    .intValue() * 3600 * 1000)
                    + (Long.valueOf(endTime
                    .split(":")[1]).intValue() * 60 * 1000);
            def = (endTimeInMin - startTimeInMin) / 60000;
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }

        return def;
    }

    /**
     * @author OmidAshouri
     * usage 3
     */
    public String addMonthToKhDate(String inputDate, Long month) {
        String DateMiladi = convertKhToMi1(inputDate);
        String[] seperateDate = DateMiladi.split("-");
        Calendar startDate = Calendar.getInstance();
        startDate.set(Integer.parseInt(seperateDate[0]),
                Integer.parseInt(seperateDate[1]),
                Integer.parseInt(seperateDate[2]));
        startDate.add(Calendar.MONTH, month.intValue());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String correctMilFormat = sdf.format(startDate.getTime()).toString();
        return convertMiToKh2(correctMilFormat);
    }

    //usage 2
    public int compareDates(String firstDate, String lastDate) {

        if (firstDate == lastDate)
            return 0;
        // compare year
        if (Long.valueOf(firstDate.substring(0, 4)) < Long.valueOf(lastDate.substring(0, 4)))
            return -1;
        else if (Long.valueOf(firstDate.substring(0, 4)) > Long.valueOf(lastDate.substring(0, 4)))
            return 1;
            // compare month
        else if (Long.valueOf(firstDate.substring(5, 7)) < Long.valueOf(lastDate.substring(5, 7)))
            return -1;
        else if (Long.valueOf(firstDate.substring(5, 7)) < Long.valueOf(lastDate.substring(5, 7)))
            return 1;
            // compare day
        else if (Long.valueOf(firstDate.substring(8, 10)) < Long.valueOf(lastDate.substring(8, 10)))
            return -1;
        else
            return 1;
    }

    /**
     * @param miladiDate (pattern:"yyyy-MM-dd HH:mm:ss")
     * @return Date
     * @author Omid Ashouri
     */
    public java.util.Date dateTimeConverter(String miladiDate) {
        try {
            DateFormat formatter;
            java.util.Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = formatter.parse(miladiDate);
            return date;
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * @param localDate LocalDate
     * @return String
     * @author Omid Ashouri
     */
    public String convertLocalDateToKh(LocalDate localDate) {
        return this.convertMiToKh(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    /**
     * @param date Date
     * @return LocalDate
     * @author Omid Ashouri
     */
    public LocalDate getLocaleDatefromDateTime(java.util.Date date) {
        //Attention OR use "Iran"
        ZoneId iran = ZoneId.of("Asia/Tehran");
        return Instant.ofEpochMilli(date.getTime()).atZone(iran).toLocalDate();
    }

    /**
     * @param localDate LocalDate
     * @return Date
     * @author Omid Ashouri
     */
    public java.util.Date getDateTimefromLocaleDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }

    /**
     * @param fromDate LocalDate
     * @param toDate   LocalDate
     * @param type     char (pattern:'d' for DAY, 'm' for MONTH, 'y' for YEAR)
     * @return int
     * @author Omid Ashouri
     */
    public int getDiffBetweenTwoLocalDate(LocalDate fromDate, LocalDate toDate, char type) {

        int result = 0;

        switch (type) {
            case 'd':
                result = Period.between(fromDate, toDate).getDays();
                break;
            case 'm':
                result = Period.between(fromDate, toDate).getMonths();
                break;
            case 'y':
                result = Period.between(fromDate, toDate).getYears();
        }
        return result;
    }

    /**
     * author Omid Ashouri (Attention: Hour in calculation is not mode 24)
     *
     * @param Milliseconds
     * @return String (HOURS:MINUTES)
     */
    public String getHourMinuteFromMillisecond(Long Milliseconds) {
        String result;
        if (null != Milliseconds && Milliseconds > 0) {
            String hourss, minutess, secondss;


            long days = TimeUnit.MILLISECONDS.toDays(Milliseconds);
            long hours = TimeUnit.MILLISECONDS.toHours(Milliseconds);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(Milliseconds) % 60;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(Milliseconds) % 60;

            hourss = 2 > (String.valueOf(hours)).length() ? "0".concat(String.valueOf(hours)) : String.valueOf(hours);
            minutess = 2 > (String.valueOf(minutes)).length() ? "0".concat(String.valueOf(minutes)) : String.valueOf(minutes);

            result = hourss + ":" + minutess;
            return result;
        } else {
            return "00:00";
        }
    }

    public Timestamp getCurrentTimeStampWithZoneIdTehran() {
        return Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Asia/Tehran")));
    }

    /**
     * author Omid Ashouri (Attention: Method is copied from Bank Melli Sample)
     *
     * @return
     */
    public String getBankMelliPaymentDate() {
        String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ").format(new Date());
        String tail = date.substring(date.indexOf("+") + 1);
        tail = tail.substring(0, 2) + ":" + tail.substring(2);
        return date.substring(0, date.indexOf("+") + 1) + tail;
    }

    public String getCurrentYear() {
        return this.jalaliDateFromLocalDateTime(LocalDateTime.now()).split("/")[0];
    }
}
