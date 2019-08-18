/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testQuoteHasAnAuthor() throws FileNotFoundException {
        String filePath = "src/main/resources/randomquotes.json";
        Quote[] quotes = App.getQuotesFromFile(filePath);
        String randomQuote = App.getRandomQuote(quotes).toString();
        assertTrue(randomQuote.contains("Author"));
    }

    @Test
    public void testQuoteHasText() throws FileNotFoundException {
        String filePath = "src/main/resources/randomquotes.json";
        Quote[] quotes = App.getQuotesFromFile(filePath);
        String randomQuote = App.getRandomQuote(quotes).toString();
        assertTrue(randomQuote.contains("Quote"));

    }
    @Test
    public void testRandomNumberGenerator() throws FileNotFoundException {
        String filePath = "src/main/resources/randomquotes.json";
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));
        Quote[] quotes = gson.fromJson(reader, Quote[].class);
        int newRandom = (int) (Math.random() * quotes.length);
        int high = quotes.length - 1;
        int low = 0;
        assertTrue("Error, random is too high", high >= newRandom);
        assertTrue("Error, random is too low",  low  <= newRandom);

    }

    @Test
    public void testgetQuoteFromInternetOrFile() throws IOException {
        String randomQuote = App.getNewQuote();
        assertNotNull("Returns a random quote from Internet or from File", randomQuote);

    }

    @Test
    public void testWriteToFile() throws IOException {
        String filePath = "src/main/resources/randomquotes.json";
        Quote[] quotes = App.getQuotesFromFile(filePath);
        int numberOfQuotes = quotes.length;
        String newQuote = App.getNewQuote();
        Quote[] quotesNew = App.getQuotesFromFile(filePath);
        int currentNumberOfQuotes = quotesNew.length;
        int curr = numberOfQuotes + 1;
        assertEquals("New quote written to file", curr, currentNumberOfQuotes);

    }
    @Test
    public void testQuoteAlreadyInFile() throws IOException {
        String filePath = "src/main/resources/randomquotes.json";
        Quote[] quotes = App.getQuotesFromFile(filePath);
        int numberOfQuotes = quotes.length;
        RandomQuote r = new RandomQuote();
        r.setQuoteText("We are what we repeatedly do. Excellence, then, is not an act, but a habit.");
        r.setQuoteAuthor("Aristotle");
        App.writeQuoteToFile(r);
        Quote[] quotesNew = App.getQuotesFromFile(filePath);
        int currentNumberOfQuotes = quotesNew.length;
        assertEquals("Quote already in file, quote should not be added", numberOfQuotes, currentNumberOfQuotes);
    }

    @Test
    public void testQuoteNotInFile() throws IOException {
        JsonReader reader = new JsonReader(new FileReader("src/main/resources/randomquotes.json"));
        ArrayList<Quote> quotes = new Gson().fromJson(reader, new TypeToken<ArrayList<Quote>>() {
        }.getType());
        boolean isPresent = App.fileHasQuote(quotes,"We are what we repeatedly do.");
        assertFalse("Quote not present", isPresent);
    }

}
