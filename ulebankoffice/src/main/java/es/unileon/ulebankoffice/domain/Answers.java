package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Answers {
    private List<Answer> answers;

    public Answers(){
        this.answers = new ArrayList<>();
    }

    public void add(Answer answer) {
        if (this.search(answer.getHandler()) == null) {
            this.answers.add(answer);
        }
    }

    public Answer search(Handler answerHandler) {
        for(Answer answer: this.answers) {
            if(answer.getHandler().compareTo(answerHandler)) {
                return answer;
            }
        }

        return null;
    }
    public void remove(Handler answerHandler) {
        Answer answer = this.search(answerHandler);
        if(answer != null) {
            this.answers.remove(answer);
        }
    }

    public Iterator<Answer> getIterator() {
        return answers.iterator();
    }
}