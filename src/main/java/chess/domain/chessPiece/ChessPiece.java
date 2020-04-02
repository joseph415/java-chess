package chess.domain.chessPiece;

import chess.domain.RuleStrategy.RuleStrategy;
import chess.domain.RuleStrategy.nonLeapableStrategy.pawnRuleStrategy.PawnRuleStrategy;
import chess.domain.chessPiece.pieceType.PieceColor;
import chess.domain.position.Position;

import java.util.Objects;

public abstract class ChessPiece implements Movable, Catchable {

    protected final PieceColor pieceColor;
    protected RuleStrategy ruleStrategy;

    public ChessPiece(PieceColor pieceColor) {
        Objects.requireNonNull(pieceColor, "피스 색상이 null입니다.");
        this.pieceColor = pieceColor;
    }

    @Override
    public boolean canLeap() {
        return ruleStrategy.canLeap();
    }

    @Override
    public boolean canMove(Position sourcePosition, Position targetPosition) {
        return ruleStrategy.canMove(sourcePosition, targetPosition);
    }

    @Override
    public boolean canCatch(Position sourcePosition, Position targetPosition) {
        if (ruleStrategy instanceof PawnRuleStrategy) {
            return ((PawnRuleStrategy) ruleStrategy).canMoveToCatch(sourcePosition, targetPosition);
        }
        return ruleStrategy.canMove(sourcePosition, targetPosition);
    }

    public boolean isSamePieceColorWith(ChessPiece chessPiece) {
        return this.pieceColor.equals(chessPiece.pieceColor);
    }

    public boolean isSamePieceColorWith(PieceColor pieceColor) {
        return this.pieceColor.equals(pieceColor);
    }

    public void checkSamePieceColorWith(ChessPiece targetChessPiece) {
        if (isSamePieceColorWith(targetChessPiece)) {
            throw new IllegalArgumentException("체스 피스가 이동할 수 없습니다.");
        }
    }

    public void checkPieceCanCatchWith(Position sourcePosition, Position targetPosition) {
        if (!canCatch(sourcePosition, targetPosition)) {
            throw new IllegalArgumentException("체스 피스가 이동할 수 없습니다.");
        }
    }

    public void checkCanMoveWith(Position sourcePosition, Position targetPosition) {
        if (!canMove(sourcePosition, targetPosition)) {
            throw new IllegalArgumentException("체스 피스가 이동할 수 없습니다.");
        }
    }

    public abstract String getName();

    public abstract double getScore();
}
