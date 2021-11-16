
/**
 * Beschreibung der Klasse Fabrik.
 * Die Fabrik kann Bestellungen entgegennehmen und eine Auftragsbestätitung zurücksenden.
 * Bevor die Auftragsbestätigung gesendet wird, wird im Lager überprüft, ob genug Rohmaterialien vorhanden sind.
 * Wenn es zu wenig eines oder mehrerer Rohstoffe haben sollte, wird eine Bestellung beim Lieferanten aufgegeben. 
 * Dabei muss die Lieferzeit um 2 Tage verlängert werden.
 * Ansonsten wird die Auftragsbestätigung mit der Standardlieferzeit versendet.
 *
 * @Fabian Gurtler, Sven Wermuth, Daniel Voegeli, Mark Jakob, Jelena Miletic
 * @2021-11-11-2000
 */
public class Factory
{
    private int chair_to_produce;
    private int sofas_to_produce;
    private int delay_time;
    private int normal_delivery_time;
    /**
     * Erstellung der Fabrik mit den Lieferzeiten
     * Bestellungen werden auf 0 initiert
     */
    public Factory()
    {
        // Normale Lieferzeit beträgt 1 Tag, wenn die Ressourcen nicht im Lager sind beträgt die Lieferzeit 3 Tage
        this.normal_delivery_time = 1;
        this.delay_time = 2;
        this.chair_to_produce = 0;
        this.sofas_to_produce = 0; 
    }

    /**
     * Auftrag entgegen nehmen
     *public int order(Warehouse warehouse, int amount_sofa, int amount_chair)
     *
     */
    public int order(Warehouse warehouse, int amount_sofa, int amount_chair)
    {
       
        this.chair_to_produce += amount_chair;
        this.sofas_to_produce += amount_sofa;
        int delivery_time = this.normal_delivery_time;
        
        //Die Ressourcen welche je Möbel benötigt werden
        int necessaryWood = amount_chair * 2 + amount_sofa * 4;
        int necessaryScrew = amount_chair * 10 + amount_sofa * 5;
        int necessaryPillow = amount_sofa * 5;
        int necessaryColor = amount_chair * 2 + amount_sofa;
        int necessaryCardboard = amount_chair + amount_sofa * 5;
        //Prüft im lager die Bestände
        boolean resources_available = true;
        resources_available = resources_available && warehouse.check_resource_availability(Warehouse.Resources.Wood, necessaryWood);
        resources_available = resources_available && warehouse.check_resource_availability(Warehouse.Resources.Screw, necessaryScrew);
        resources_available = resources_available && warehouse.check_resource_availability(Warehouse.Resources.Pillow, necessaryPillow);
        resources_available = resources_available && warehouse.check_resource_availability(Warehouse.Resources.Color, necessaryColor);
        resources_available = resources_available && warehouse.check_resource_availability(Warehouse.Resources.Cardboard, necessaryCardboard);
        //Das Lager wird mit den neuen Lagerbeständen nachgeführt
        warehouse.update_inventory(Warehouse.Resources.Wood, necessaryWood);
        warehouse.update_inventory(Warehouse.Resources.Screw, necessaryScrew);
        warehouse.update_inventory(Warehouse.Resources.Pillow, necessaryPillow);
        warehouse.update_inventory(Warehouse.Resources.Color, necessaryColor);
        warehouse.update_inventory(Warehouse.Resources.Cardboard, necessaryCardboard);
        // Falls die Resource_Available False ist, wird die Verspätung zur normalen Lieferzeit hinzugerechnet
        if(!resources_available)
        { 
            delivery_time += this.delay_time;  
        }
        //Ausgabe der Bestellung und der Lieferzeit
        System.out.println("\n"+"****************"+"\n"+"Bestellungsbestätigung:");
        System.out.println("Vielen Dank für ihre Bestellung");
        System.out.println("Ihre Bestellung beinhaltet: " + amount_chair + " Stühle und "+ amount_sofa +" Sofa"); 
        System.out.println("Ihr Auftrag wurde bestätigt und wird in " +delivery_time +" Tagen geliefert"+ "\n"+"****************");
        return delivery_time;
    }
    
    
    }
   

