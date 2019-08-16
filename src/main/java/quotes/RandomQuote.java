package quotes;

public class RandomQuote {
    private String quoteText;
    private String quoteAuthor;

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }
    public String toString(){
        String returnString = "";
        returnString = "Author: " + this.quoteAuthor + "\nQuote: " + this.quoteText;
        return returnString;
    }
}
