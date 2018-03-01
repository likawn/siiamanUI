package TemporaryDataProvider;

import java.util.List;

import static java.util.Arrays.asList;

public class TemporaryDataProvider {
    public static String baseUrl = "http://localhost:8080/siiamanTest/";
    public static String expectedUrl = "http://localhost:8080/siiamanTest/login";
    public static String homePageHeader = "aman logowanie:";
    public static String registerPageHeader = "aman rejestracja:";
    public static String login_correct = "automation@pl.sii.eu";
    public static String password_correct = "password";
    //public static String mainPageUrl = baseUrl + "restaurants";
    public static String expectedMainPageFirstHeader = "Otwarte zamówienia:";
    public static String expectedMainPageSecondHeader = "Zamówienia w trakcie realizacji:";
    public static List<String> expectedUrlFromMenuBar = asList("myOrders", "restaurants", "admin", "contributors", "costsTable");

}
