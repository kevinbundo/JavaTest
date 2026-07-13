import java.util.HashMap;
import java.util.Map;

public class SurveyResponse {

    private Candidate candidate;

    private Map<Question, AnswerOption> answers = new HashMap<>();

    public SurveyResponse(Candidate candidate) {
        this.candidate = candidate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Map<Question, AnswerOption> getAnswers() {
        return answers;
    }

    public void answerQuestion(Question question, AnswerOption answer) {
        answers.put(question, answer);
    }
}