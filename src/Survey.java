import java.util.ArrayList;
import java.util.List;

public class Survey {

    private String title;
    private String topic;
    private String description;

    private List<Question> questions = new ArrayList<>();
    private List<SurveyResponse> responses = new ArrayList<>();

    public Survey(String title, String topic, String description) {
        this.title = title;
        this.topic = topic;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<SurveyResponse> getResponses() {
        return responses;
    }

    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
    }

    public void removeQuestion(Question question) {
        questions.remove(question);

        for (SurveyResponse response : responses) {
            response.getAnswers().remove(question);
        }
    }

    public void addResponse(SurveyResponse response) {
        responses.add(response);
    }

    public boolean validateSurvey() {

        if (questions.size() < 10) {
            return false;
        }

        if (questions.size() > 40) {
            return false;
        }

        long uniqueQuestions = questions.stream()
                .distinct()
                .count();

        return uniqueQuestions == questions.size();
    }
}