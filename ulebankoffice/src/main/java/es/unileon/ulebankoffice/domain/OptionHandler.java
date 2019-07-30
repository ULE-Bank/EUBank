package es.unileon.ulebankoffice.domain;

import java.util.Date;

import org.springframework.data.annotation.PersistenceConstructor;

public class OptionHandler implements Handler {
    private long milliseconds;

    public OptionHandler(){
        this.milliseconds = new Date().getTime();
    }

    @PersistenceConstructor
    public OptionHandler(long milliseconds){
        this.milliseconds = milliseconds;
    }
    
    
    @Override
    public boolean compareTo(Handler handler) {
        return this.toString().equals(handler.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(this.milliseconds);
    }

}