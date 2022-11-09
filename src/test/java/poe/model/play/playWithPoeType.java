package poe.model.play;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import poe.model.PoeType;

public class playWithPoeType {
    @Test
    void testLiteralPOEI() {
        PoeType poeType = PoeType.POEI;
        System.out.println(poeType);
    }

    @ParameterizedTest
    @EnumSource(PoeType.class)
    void testAllLiterals(PoeType poeType) {
        System.out.println(poeType);
    }
}
