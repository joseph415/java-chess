package chess.domain.RuleStrategy.nonLeapableStrategy;

import chess.domain.position.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BishopRuleTest {

    @Test
    void BishopRuleStrategy_MovableDirection_GenerateInstance() {
        assertThat(new BishopRule()).isInstanceOf(BishopRule.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"a1", "a7", "h8", "g1"})
    void canMove_MovableSourcePositionAndTargetPosition_ReturnTrue(Position targetPosition) {
        BishopRule bishopRuleStrategy = new BishopRule();
        Position sourcePosition = Position.of("d4");

        assertThat(bishopRuleStrategy.canMove(sourcePosition, targetPosition)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"d1", "d8", "h4", "a4"})
    void canMove_NonMovableSourcePositionAndTargetPosition_ReturnFalse(Position targetPosition) {
        BishopRule bishopRuleStrategy = new BishopRule();
        Position sourcePosition = Position.of("d4");

        assertThat(bishopRuleStrategy.canMove(sourcePosition, targetPosition)).isFalse();
    }

}