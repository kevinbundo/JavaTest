public class Main {

    public static void main(String[] args) {

        Survey survey = new Survey(
                "Employee Satisfaction",
                "HR",
                "Annual employee survey"
        );

        Question q1 = new Question("I enjoy my work.");
        Question q2 = new Question("Management communicates clearly.");
        Question q3 = new Question("I am happy with my salary.");

        survey.addQuestion(q1);
        survey.addQuestion(q2);
        survey.addQuestion(q3);

        Candidate c1 = new Candidate(
                "Kevin",
                "Bundo",
                "kevin@test.com",
                "0691234567"
        );

        Candidate c2 = new Candidate(
                "John",
                "Doe",
                "john@test.com",
                "0681111111"
        );

        SurveyResponse r1 = new SurveyResponse(c1);
        r1.answerQuestion(q1, AnswerOption.AGREE);
        r1.answerQuestion(q2, AnswerOption.SLIGHTLY_AGREE);

        SurveyResponse r2 = new SurveyResponse(c2);
        r2.answerQuestion(q1, AnswerOption.AGREE);
        r2.answerQuestion(q2, AnswerOption.DISAGREE);
        r2.answerQuestion(q3, AnswerOption.SLIGHTLY_DISAGREE);

        survey.addResponse(r1);
        survey.addResponse(r2);

        SurveyService service = new SurveyService();

        System.out.println(
                "Most given answer: "
                        + service.findMostGivenAnswer(survey)
        );

        service.printSurveyResult(survey);

        System.out.println("\nAnswers by Kevin:");
        service.findAnswersByCandidate(survey, c1);
        service.findAnswersByCandidate(survey, c2);
    }
}