package es.unileon.ulebankoffice.domain;

public class AnswerHandler implements Handler {
    private String question;
    private String answer;

    public AnswerHandler(String question, String answer){
        this.question = question;
        this.answer = answer;
    }
    @Override
    public boolean compareTo(Handler handler) {
        return this.toString().equals(handler.toString());
    }

    @Override
    public String toString() {
        return this.question + " " + this.answer;
    }

}