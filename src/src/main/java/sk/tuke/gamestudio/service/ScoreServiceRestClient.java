package sk.tuke.gamestudio.service;

import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.entity.Score;

import java.util.Arrays;
import java.util.List;

public class ScoreServiceRestClient implements ScoreService {
    private static final String URL="http://localhost:8080/api/score";

    private RestTemplate restTemplate = new RestTemplate();
    @Override
    public void addScore(Score score) throws ScoreException {
        restTemplate.postForEntity(URL,score, Score.class);
    }

    @Override
    public List<Score> getBestScores(String game) throws ScoreException {
        return Arrays.asList(restTemplate.getForEntity(URL + "/" + game, Score[].class).getBody());
    }
}
