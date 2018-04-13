import org.junit.Test;
import pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CalculatingComponentsOfTheNextAnniversaryTest {
    @Test
    public void calculateDateOfTheNextAnniversary_1(){
        // Birth date: 21/02/1996.
        Calendar calendarBirthDate = Calendar.getInstance();
        calendarBirthDate.set(Calendar.YEAR, 1996);
        calendarBirthDate.set(Calendar.MONTH, 2 - 1);
        calendarBirthDate.set(Calendar.DAY_OF_MONTH, 21);
        Date birthDate = calendarBirthDate.getTime();

        ViewExtendedPersonAnniversary personAnniversary = new ViewExtendedPersonAnniversary();
        personAnniversary.setAnniversaryDate(birthDate);

        // Today: 21/02/2018.
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.YEAR, 2018);
        calendarToday.set(Calendar.MONTH, 3 - 1);
        calendarToday.set(Calendar.DAY_OF_MONTH, 21);
        personAnniversary.calculateNextAnniversaryFields(calendarToday);

        // Expected date of next anniversary: 21.02.2019.
        Calendar calendarExpectedDate = Calendar.getInstance();
        calendarExpectedDate.set(Calendar.YEAR, 2019);
        calendarExpectedDate.set(Calendar.MONTH, 2 - 1);
        calendarExpectedDate.set(Calendar.DAY_OF_MONTH, 21);

        assertEquals(calendarExpectedDate.getTime().getTime(), personAnniversary.getNextAnniversaryDate().getTime());
    }

    @Test
    public void calculateDaysBetweenTodayAndTheNextAnniversary_1(){
        // Birth date: 24/02/1996.
        Calendar calendarBirthDate = Calendar.getInstance();
        calendarBirthDate.set(Calendar.YEAR, 1996);
        calendarBirthDate.set(Calendar.MONTH, 3-1);
        calendarBirthDate.set(Calendar.DAY_OF_MONTH, 24);
        Date birthDate = calendarBirthDate.getTime();

        ViewExtendedPersonAnniversary personAnniversary = new ViewExtendedPersonAnniversary();
        personAnniversary.setAnniversaryDate(birthDate);

        // Today: 24/02/2018.
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.YEAR, 2018);
        calendarToday.set(Calendar.MONTH, 3-1);
        calendarToday.set(Calendar.DAY_OF_MONTH, 24);
        personAnniversary.calculateNextAnniversaryFields(calendarToday);

        assertEquals(new Integer(0), personAnniversary.getNumberOfDaysToNextAnniversary());
    }

    @Test
    public void calculateDaysBetweenTodayAndTheNextAnniversary_2(){
        // Birth date: 24/02/1996.
        Calendar calendarBirthDate = Calendar.getInstance();
        calendarBirthDate.set(Calendar.YEAR, 1996);
        calendarBirthDate.set(Calendar.MONTH, 3-1);
        calendarBirthDate.set(Calendar.DAY_OF_MONTH, 24);
        Date birthDate = calendarBirthDate.getTime();

        ViewExtendedPersonAnniversary personAnniversary = new ViewExtendedPersonAnniversary();
        personAnniversary.setAnniversaryDate(birthDate);

        // Today: 23/02/2018.
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.YEAR, 2018);
        calendarToday.set(Calendar.MONTH, 3-1);
        calendarToday.set(Calendar.DAY_OF_MONTH, 23);
        personAnniversary.calculateNextAnniversaryFields(calendarToday);

        assertEquals(new Integer(1), personAnniversary.getNumberOfDaysToNextAnniversary());
    }

    @Test
    public void calculateDaysBetweenTodayAndTheNextAnniversary_3(){
        // Birth date: 24/02/1996.
        Calendar calendarBirthDate = Calendar.getInstance();
        calendarBirthDate.set(Calendar.YEAR, 1996);
        calendarBirthDate.set(Calendar.MONTH, 3-1);
        calendarBirthDate.set(Calendar.DAY_OF_MONTH, 24);
        Date birthDate = calendarBirthDate.getTime();

        ViewExtendedPersonAnniversary personAnniversary = new ViewExtendedPersonAnniversary();
        personAnniversary.setAnniversaryDate(birthDate);

        // Today: 25/02/2018.
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.YEAR, 2018);
        calendarToday.set(Calendar.MONTH, 3-1);
        calendarToday.set(Calendar.DAY_OF_MONTH, 25);
        personAnniversary.calculateNextAnniversaryFields(calendarToday);

        assertEquals(new Integer(364), personAnniversary.getNumberOfDaysToNextAnniversary());
    }

    @Test
    public void calculateDaysBetweenTodayAndTheNextAnniversary_4(){
        // Birth date: 21/02/1996.
        Calendar calendarBirthDate = Calendar.getInstance();
        calendarBirthDate.set(Calendar.YEAR, 1996);
        calendarBirthDate.set(Calendar.MONTH, 2 - 1);
        calendarBirthDate.set(Calendar.DAY_OF_MONTH, 21);
        Date birthDate = calendarBirthDate.getTime();

        ViewExtendedPersonAnniversary personAnniversary = new ViewExtendedPersonAnniversary();
        personAnniversary.setAnniversaryDate(birthDate);

        // Today: 28/05/2018.
        Calendar calendarToday = Calendar.getInstance();
        calendarToday.set(Calendar.YEAR, 2018);
        calendarToday.set(Calendar.MONTH, 6-1);
        calendarToday.set(Calendar.DAY_OF_MONTH, 28);
        personAnniversary.calculateNextAnniversaryFields(calendarToday);

        assertEquals(new Integer(238), personAnniversary.getNumberOfDaysToNextAnniversary());
    }
}