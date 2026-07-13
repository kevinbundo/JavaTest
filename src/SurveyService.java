import java.util.HashMap;
import java.util.Map;

public class SurveyService {

    public AnswerOption findMostGivenAnswer(Survey survey) {

        Map<AnswerOption, Integer> counts = new HashMap<>();

        for (SurveyResponse response : survey.getResponses()) {
            for (AnswerOption answer : response.getAnswers().values()) {
                counts.put(answer, counts.getOrDefault(answer, 0) + 1);
            }
        }

        AnswerOption result = null;
        int max = 0;

        for (Map.Entry<AnswerOption, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public void printSurveyResult(Survey survey) {

        for (Question question : survey.getQuestions()) {

            System.out.println("\nQuestion: " + question.getText());

            Map<AnswerOption, Integer> counts = new HashMap<>();

            for (SurveyResponse response : survey.getResponses()) {

                AnswerOption answer =
                        response.getAnswers().get(question);

                if (answer != null) {
                    counts.put(answer,
                            counts.getOrDefault(answer, 0) + 1);
                }
            }

            for (AnswerOption option : AnswerOption.values()) {
                System.out.println(
                        option + ": "
                                + counts.getOrDefault(option, 0)
                );
            }
        }
    }

    public void findAnswersByCandidate(
            Survey survey,
            Candidate candidate) {

        for (SurveyResponse response : survey.getResponses()) {
            if (response.getCandidate().equals(candidate)) {
                response.getAnswers().forEach(
                        (question, answer) ->
                                System.out.println(
                                        question.getText()
                                                + " -> "
                                                + answer
                                )
                );
            }
        }
    }

    public void removeLowAnsweredQuestions(Survey survey) {

        int totalCandidates = survey.getResponses().size();

        survey.getQuestions().removeIf(question -> {

            int answeredCount = 0;

            for (SurveyResponse response : survey.getResponses()) {
                if (response.getAnswers().containsKey(question)) {
                    answeredCount++;
                }
            }

            double percentage =
                    (double) answeredCount / totalCandidates;

            return percentage < 0.5;
        });
    }
}