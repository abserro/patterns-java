package Builder.BusBuilder;

import Builder.Category;
import Builder.Driver;

public class BusDriver extends Driver {
    private static BusDriver busDiver;

    private BusDriver(Category category) {
        super(category);
    }

    public static synchronized BusDriver getInstance() {
        if (busDiver == null) {
            busDiver = new BusDriver(Category.DCategory);
        }
        return busDiver;
    }

    @Override
    public Category getCategory() {
        return super.getCategory();
    }
}
