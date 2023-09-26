import AbstractFactory.Board;
import AbstractFactory.BusFactory.BoardBusFactory;
import AbstractFactory.TaxiFactory.BoardTaxiFactory;
import AbstractFactory.Vehicle;

public class Main {
    public static void main(String[] args) {
        int[] taxiTickets = {0, 1, 2, 3};
        int[] busTickets = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        BoardTaxiFactory taxiFactory = new BoardTaxiFactory();
        BoardBusFactory busFactory = new BoardBusFactory();

        Vehicle taxi = Board.boardCar(taxiFactory, taxiTickets);
        Vehicle bus = Board.boardCar(busFactory, busTickets);

        taxi.viewInfo();
        taxi.isReadyToGo();

        bus.viewInfo();
        bus.isReadyToGo();
    }
}