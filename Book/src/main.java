import SecondFrameClass.SecondFrameController;
import DataClassManagment.BookData;
import MainFrameClass.MainFrameController;

public class main {
    public static void main(String args[]) {
        new MainFrameController(new BookData());
    }
}

