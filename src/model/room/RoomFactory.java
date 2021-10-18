package model.room;

import java.util.Scanner;

public class RoomFactory {
    private RoomFactory() {}
    public static final Room getRoom(RoomType roomType, String code) {
        switch (roomType) {
            case DELUXERROOM:
                return new RoomDeluxe(code);
            case VIPROOM:
                return new RoomVip(code);
            case KINGROOM:
                return new RoomKing(code);
            default:
                throw new IllegalArgumentException("This type of room is unsupported");
        }
    }

}

