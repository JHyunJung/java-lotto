package mission.lotto;

import mission.lotto.view.InputView;
import mission.lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){
        int money = InputView.intputPay();
        Customer customer = new Customer(money);
        customer.buyLotto(new KLottoGenerator());
        OutputView.showLottos(customer.getLottos());
        List<Integer> lastNumbers = InputView.lastWinNumbers();
        customer.checkLottoWin(lastNumbers);
        Map<KLottoRank, Integer> lottoResult = customer.getRankLottos();

        OutputView.LottoResult(lottoResult, money);
    }
}