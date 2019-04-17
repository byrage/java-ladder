import domain.*;
import view.InputView;
import view.ResultView;

public class LadderMain {
    public static void main (String[] args) {
        Players players = InputView.getNameOfParticipants();
        int depthOfLadders = InputView.getDepthOfLadders();
        Ladder ladder = new Ladder(depthOfLadders, players.getNumber());
        Results results = InputView.getResultOfGame();

        ResultView.printLadders(players, ladder, results);

        LadderGame ladderGame = new LadderGame(ladder);
        LadderGameResult ladderGameResult = ladderGame.playGame(players, results);

        Player player = InputView.getPlayerToShowResult(players);
        if (player.equals(Player.ALL)) {
            ResultView.showAllResults(ladderGameResult);
        } else {
            Result resultOfPlayer = ResultView.getResultOfPlayer(player, ladderGameResult);
            System.out.println("실행 결과\n" + resultOfPlayer.toString());

        }
    }
}