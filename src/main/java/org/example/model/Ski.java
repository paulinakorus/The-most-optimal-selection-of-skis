package org.example.model;

public class Ski {

    private Integer lenght;
    private String type;

    public Ski(){
        this(null, null);
    }
    public Ski(Integer lenght, String type) {
        this.lenght = lenght;
        this.type = type;
    }

    // setters aren't needed

    public int getLenght() {                                                // gettery
        return lenght;
    }

    public String getType() {
        return type;
    }
}



/* java record - obiekty po utworzeniu nie ulegają zmianom

        public record Ski(int lenght, String type){
            // działa tak samo jak powyższe
        }
*/