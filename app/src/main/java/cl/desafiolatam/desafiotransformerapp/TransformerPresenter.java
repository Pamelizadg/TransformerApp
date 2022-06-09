package cl.desafiolatam.desafiotransformerapp;

public interface TransformerPresenter {
    void setView(TransformerView view);
    void removeView();
    boolean setDate(Long date);
    String getStringDate();
    String getDaysOnly();
    String getWeeksOnly();
    Long getTimeStamp();
    String getDateFormatOne();
    String getDateFormatTwo();
    String getDateFormatThree();
    String getDateFormatFour();
}