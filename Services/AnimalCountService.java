package Services;

import Data.Animal;

public class AnimalCountService implements AutoCloseable {
    private boolean completeness = true;
    private static int count = 0;

    public boolean addCount(Animal animals) {
        if (!animals.getName().equals("") && !animals.getBirthDate().equals("")) {
            count++;
            completeness = false;
            return true;
        }
        return false;
    }

    public void removeCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void close() throws AnimalExceptionService {
        if (completeness) throw new AnimalExceptionService("Some animal data didn't fill");
    }
}
