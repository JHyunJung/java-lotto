package lotto.model;

import lotto.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MINIMUM_RANGE = 1;
    private static final int LOTTO_NUMBER_MAXIMUM_RANGE = 6;
    public static final int LOTTO_PRICE = 1000;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int number = LOTTO_NUMBER_MINIMUM_RANGE; number <= LOTTO_NUMBER_MAXIMUM_RANGE; number++) {
            numbers.add(number);
        }

        Collections.shuffle(numbers);
        List<Integer> lottos = numbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottos);
        return lottos;
    }


    @Override
    public int getPrice() {
        return LOTTO_PRICE;
    }
}