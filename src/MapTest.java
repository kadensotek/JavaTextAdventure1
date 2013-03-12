public class MapTest
{
    Location one = new Location("1", "forest");
    Location two = new Location("2", "swamp");
    Location three = new Location("3", "town");
    Location four = new Location("4", "forest");
    Location five = new Location("5", "forest");
    Location six = new Location("6", "town");
    Location seven = new Location("7", "cave");
    Location eight = new Location("8", "desert");
    Location nine = new Location("9", "swamp");

    Item item = null;

    public MapTest()
    {
        one.addConnection('e', two);
        one.addConnection('s', four);
        one.setLocked(true);

        two.addConnection('e', three);
        two.addConnection('s', five);
        two.addConnection('w', one);

        three.addConnection('s', six);
        three.addConnection('w', two);
        three.addChest();

        four.addConnection('n', one);
        four.addConnection('e', five);
        four.addConnection('s', seven);

        five.addConnection('n', two);
        five.addConnection('e', six);
        five.addConnection('s', eight);
        five.addConnection('w', four);
        five.addChest();
        five.addChestItem(1);  /* adds health potion to chest */

        six.addConnection('n', three);
        six.addConnection('s', nine);
        six.addConnection('w', five);

        seven.addConnection('n', four);
        seven.addConnection('e', eight);

        eight.addConnection('n', five);
        eight.addConnection('e', nine);
        eight.addConnection('w', seven);

        nine.addConnection('n', six);
        nine.addConnection('w', eight);
    }
}
