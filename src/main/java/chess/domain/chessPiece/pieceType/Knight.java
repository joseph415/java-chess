package chess.domain.chessPiece.pieceType;

import chess.domain.RuleStrategy.KnightRule;
import chess.domain.chessPiece.ChessPiece;

public class Knight extends ChessPiece {

    public static final String NAME = "N";
    private static final double SCORE = 2.5;

    public Knight(PieceColor pieceColor) {
        super(pieceColor);
        rule = new KnightRule();
    }

    @Override
    public String getName() {
        return pieceColor.convertName(NAME);
    }

    @Override
    public double getScore() {
        return SCORE;
    }

}
