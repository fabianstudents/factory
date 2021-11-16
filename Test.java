
/**
 * Testmethode
 * Löst eine vordefinierte Bestellung aus.
 *
 * @Fabian Gurtler, Sven Wermuth, Daniel Voegeli, Mark Jakob, Jelena Miletic
 * @2021-11-11-2000
 */
public class Test
{


    //public static void main(String[] args, int amount_sofa, int amoung_chair)

    public static void main( int amount_sofa, int amount_chair) 
    {
        
        System.out.print('\u000C');
        Warehouse warehouse = new Warehouse();
        Factory factory = new Factory();
        factory.order(warehouse, amount_sofa, amount_chair);
    }
}
