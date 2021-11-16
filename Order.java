
/**
 * Über die Klasse Order können Bestellungen aufgegeben werden.
 * Der Kunde kann die Anzahl Sofa und Stühle eingeben und erhält eine Bestellbestätigung zurück. 
 * 
 * @Fabian Gurtler, Sven Wermuth, Daniel Voegeli, Mark Jakob, Jelena Miletic
 * @2021-11-11-2000
 */
public class Order
{
    // 
    

    /**
     * Nach Bestellungseingang werden die Klassen Warehouse und Factory aufgerufen. 
     * Wenn dort alles stimmt, wird ein Herrstellprozess eingeleitetl.
     */
public static void Order( int amount_sofa, int amount_chair) 
    {
        System.out.print('\u000C');
        Warehouse warehouse = new Warehouse();
        Factory factory = new Factory();
        factory.order(warehouse, amount_sofa, amount_chair);
    }
}
