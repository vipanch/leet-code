//package com.oo;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class Board {
//    Piece[][] board;
//    Side turn = Side.WHITE;
//
//    public Set<Coordinate> getMoves(Coordinate co){
//          Piece piece = board[co.X.getVal()][co.Y.getVal()];
//          if(piece==null)
//              throw new IllegalArgumentException("Choose a piece");
//          if(piece.side!=turn)
//            throw new IllegalArgumentException(turn+"'s move");
//          Set<Coordinate> legalMoves = getMovesGivenAPieceAndACoordinate(co, piece.pieceType);
//    }
//
//    private Set<Coordinate> getMovesGivenAPieceAndACoordinate(Coordinate co, PieceType pieceType) {
//        Set<Coordinate> legalCoordinates = new HashSet<>();
//        switch(pieceType){
//            case KING:
//            {
//                int[][] moves = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
//                for(int[] move: moves){
//                    XCoordinate x = X
//                }
//            }
//        }
//    }
//}
//class Coordinate{
//        XCoordinate X;
//        YCoordinate Y;
//}
//
//enum XCoordinate{
//    X1(1),
//    X2(2),
//    X3(3),
//    X4(4),
//    X5(5),
//    X6(6),
//    X7(7),
//    X8(8);
//
//    int val;
//    static Map<Integer, XCoordinate> map = new HashMap<>();
//    XCoordinate(int i) {
//        this.val = val;
//    }
//    public int getVal(){return this.val;}
//
//    static void setMap(){
//        for(XCoordinate x: XCoordinate.values()){
//            map.put(x.val, x);
//        }
//    }
//
//    public static XCoordinate get(int val){
//        if(val<1 || val>8) return null;
//        return map.get(val);
//    }
//}
//enum YCoordinate{
//  Y1(1),Y2(2),Y3(3),Y4(4),Y5(5),Y6(6),Y7(7),Y8(8);
//   int val;
//   Map<Integer, YCoordinate> map;
//
//   YCoordinate(int val){
//      this.val = val;
//      map = new HashMap<>();
//      setMap();
//   }
//
//   void setMap(){
//       for(YCoordinate v: YCoordinate.values()){
//            map.put(v.val, v);
//       }
//   }
//
//   public YCoordinate get(int val){
//       if(val<1 || val>8) return null;
//       return map.get(val);
//   }
//
//   public int getVal(){return this.val;}
//}
//
//class Piece{
//    PieceType pieceType;
//    Side side;
//}
//
//enum PieceType{
//    KING, QUEEN, ROOK, BISHOP, PAWN
//}
//
//enum Side{
//    WHITE, BLACK;
//}