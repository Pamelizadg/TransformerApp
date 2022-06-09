package cl.desafiolatam.desafiotransformerapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


@RunWith(MockitoJUnitRunner.class)
public class TransformerPresenterImplTest {
    @Mock
    private TransformerView view;
    private TransformerPresenter presenter;
    private final Calendar calendarDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new TransformerPresenterImpl();
        presenter.setView(view);
    }

    @After
    public void tearDown() {
        presenter.removeView();
    }

    @Test
    public void setDate() {
        Assert.assertNull(presenter.getStringDate());
        calendarDate.set(2020,1,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        Mockito.verify(view, Mockito.times(1)).showDateResult();
        Assert.assertNotNull(presenter.getStringDate());

    }
    @Test
    public void getStringDate() {
        calendarDate.set(2019,2,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        presenter.getStringDate();
        assertEquals("jueves, marzo 28, 2019", presenter.getStringDate());
        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        presenter.getStringDate();
        assertEquals("jueves, diciembre 16, 1999", presenter.getStringDate());
    }

    @Test
    public void getDaysOnly() {
        calendarDate.set(2019,2,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("Día del mes: 28",presenter.getDaysOnly());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("Día del mes: 16", presenter.getDaysOnly());
    }

    @Test
    public void getWeeksOnly() {
        calendarDate.set(2019,0,1);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("Semana del año: 1",presenter.getWeeksOnly());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("Semana del año: 51", presenter.getWeeksOnly());
    }

    @Test
    public void getTimeStamp() {
        calendarDate.set(2019,2,28,00,00,00);
        presenter.setDate(calendarDate.getTimeInMillis()/1000);
        assertEquals(1553731200L, presenter.getTimeStamp());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis()/1000);
        assertEquals(945302400L, presenter.getTimeStamp());
    }

    @Test
    public void getDateFormatOne() {
        calendarDate.set(2019,2,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("28/03/2019",presenter.getDateFormatOne());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("16/12/1999",presenter.getDateFormatOne());
    }

    @Test
    public void getDateFormatTwo() {
        calendarDate.set(2019,2,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("28 - 03 - 2019",presenter.getDateFormatTwo());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("16 - 12 - 1999",presenter.getDateFormatTwo());
    }

    @Test
    public void getDateFormatThree() {
        calendarDate.set(2019,1,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("jue., feb. 28, 2019",presenter.getDateFormatThree());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("jue., dic. 16, 1999",presenter.getDateFormatThree());
    }

    @Test
    public void getDateFormatFour() {
        calendarDate.set(2019,2,28);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("jueves 28",presenter.getDateFormatFour());

        calendarDate.set(1999,11,16);
        presenter.setDate(calendarDate.getTimeInMillis());
        assertEquals("jueves 16",presenter.getDateFormatFour());
    }
}