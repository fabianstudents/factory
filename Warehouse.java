
/**
 * Im Warenhaus befinden sich die Rohmaterialien, welche für die Produktion der Tische und Stühle benötigt werden.
 *
 * @Fabian Gurtler, Sven Wermuth, Daniel Voegeli, Mark Jakob, Jelena Miletic
 * @2021-11-11-2000
 */

public class Warehouse
{
    //enum wird verwendet, um die Aufzählung der unterschiedlichen Ressourcen vorzunehmen
    public enum Resources
    {
        Wood,
        Screw,
        Pillow,
        Color, 
        Cardboard,
        MAX
        // MAX wird hier als letztes aufgezählt, damit die Ressourcen auch erweitert werden können, ohne den ganzen Code anzupassen
    };
    // Erstellung des Inventory Arrays
    private int[] inventory;

    /**
     * Konstruktor für das Warenhaus.
     * Es werden alle Rohmaterialien aufgezählt, welche für die Produktion der Tische und Stühle benötigt werden.
     * Es wird vom maximal Lagerstand ausgegangen. 
     */
    public Warehouse()
    {
        // initierung des Lagers mit dem Grundstock (hier werden alle Ressourcen aus dem Array erstellt)
        // Mit "MAX" können zukünftig einfach neue Ressourcen integriert werden. 
        this.inventory = new int[Resources.MAX.ordinal()];
        this.inventory[Resources.Wood.ordinal()] = 1000;
        this.inventory[Resources.Screw.ordinal()]  = 5000;
        this.inventory[Resources.Pillow.ordinal()]  = 100;
        this.inventory[Resources.Color.ordinal()]  = 1000;
        this.inventory[Resources.Cardboard.ordinal()]  = 1000;
    }

    /**
     * Diese Methode überprüft, ob für die Bestellung genug Ressourcen im Lager vorhanden sind.
     * 
     */
    public boolean check_resource_availability(Resources resource_value, int amount)
    {
        return this.inventory[resource_value.ordinal()] >= amount; 
        
    }
    /** 
     * Bei dieser Methode werden die Ressourcen für die aufgegebene Bestellung vom maximalen Lagerbestand abgezogen.
     * Der neue Lagerbestand wird ausgegeben (wird im Testing geprinted).
     * 
     */
    public void update_inventory(Resources resource_value, int amount)
    {
        if(this.check_resource_availability(resource_value, amount))
        {
            this.inventory[resource_value.ordinal()] -= amount; 
            System.out.println("Neuer Lagerbestand von " + resource_value.name() + ":  " +
            this.inventory[resource_value.ordinal()]);
        } 
        
        
        else
        {
            this.inventory[resource_value.ordinal()] -= amount; 
            // minus = bestellt
            System.out.println("!! ACHTUNG !!"+"\n"+"Resourcen im Lager nicht vorhanden! " + resource_value.name());
            System.out.println("Bestellung an Lieferanten: 100 " + resource_value.name()+"\n");
            
            
        }
    }
}
