package es.unileon.ulebankoffice.domain;

public class Answer {
    private Handler question;
    private Handler option;
    private Handler handler;

    public Answer(Handler question, Handler option) throws Exception {
        if (QuestionStore.getInstance().search(question) == null) {
            throw new Exception("Question handler doesn't match with any question from the store.");
        }

        if (QuestionStore.getInstance().search(question).search(option) == null) {
            throw new Exception("Option handler doesn't match with question's options.");
        }

        this.question = question;
        this.option = option;
        this.handler = new AnswerHandler(this.question.toString(), this.option.toString());
    }

    public Question getQuestion() {
        return QuestionStore.getInstance().search(question);
    }

    public void setQuestion(Handler question) {
        this.question = question;
    }

    public Simple getOption() {
        return (Simple) QuestionStore.getInstance().search(question).search(option);
    }

    public void setOption(Handler option) {
        this.option = option;
    }

    public Handler getHandler() {
        return this.handler;
    }
}