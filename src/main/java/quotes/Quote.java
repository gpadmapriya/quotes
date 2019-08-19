package quotes;

public class Quote {

        private String[] tags;
        private String author;
        private String likes;
        private String text;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String toString(){
        String returnString = "";
        returnString = "Author: " + this.author + "\nQuote: " + this.text;
        return returnString;
    }
}


