import unit4.collectionsLib.Node;

public class henHouse_Node {
    public static void main(String[] args) {
        HenHouse house = new HenHouse(3);

        house.addEgg(0, 101, 55.5, "2025-02-13");
        house.addEgg(0, 102, 52.3, "2025-02-14");
        house.addEgg(1, 201, 60.2, "2025-02-15");

        System.out.println("\nBefore transfer:");
        house.printEggs(0);
        house.printEggs(1);

        house.transferEggs(0, 1);

        System.out.println("\nAfter the transfer:");
        house.printEggs(0);
        house.printEggs(1);
    }
}


class Egg {
    private int id;
    private double weight;
    private String laidDate; 

    /**
     * Constructor for the Egg class
     *
     * @param id       {@code int} unique identifier for the egg
     * @param weight   {@code double} weight of the egg in grams
     * @param laidDate {@code String} date the egg was laid
     */
    public Egg(int id, double weight, String laidDate) {
        this.id = id;
        this.weight = weight;
        this.laidDate = laidDate;
    }

    @Override
    public String toString() {
        return "Egg{" + "ID=" + id + ", weight=" + weight + ", laidDate=" + laidDate + '}';
    }
}

class Hen {
    private int id;
    private Node<Egg> eggsHead;

    /**
     * Constructor for the Hen class
     *
     * @param id {@code int} unique identifier for the hen
     */
    public Hen(int id) {
        this.id = id;
        this.eggsHead = null;
    }

    /**
     * Adds a newly laid egg to the list of eggs
     *
     * @param egg to be added
     */
    public void layEgg(Egg egg) {
        Node<Egg> newNode = new Node<>(egg);
        newNode.setNext(eggsHead);
        eggsHead = newNode;
    }

    /**
     * Prints all eggs laid by this hen
     */
    public void printEggs() {
        System.out.println("Eggs of Hen " + id + ":");
        Node<Egg> current = eggsHead;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    /**
     * Transfers all eggs from this hen to another hen
     *
     * @param otherHen hen that will receive the eggs
     */
    public void transferEggsTo(Hen otherHen) {
        Node<Egg> current = eggsHead;
        while (current != null) {
            otherHen.layEgg(current.getValue());
            current = current.getNext();
        }
        eggsHead = null;
    }
}

class HenHouse {
    private Hen[] hens;

    /**
     * Constructs a HenHouse with a given number of hens
     *
     * @param hen number of hens in the hen house
     */
    public HenHouse(int hen) {
        hens = new Hen[hen];
        for (int i = 0; i < hen; i++) {
            hens[i] = new Hen(i);
        }
    }

    /**
     * Adds an egg to a specific hen
     *
     * @param henId  {@code int} ID of the hen that lays the egg
     * @param eggId  {@code int} unique ID of the egg
     * @param weight {@code double} weight of the egg in grams
     * @param date   {@code String} date the egg was laid
     */
    public void addEgg(int henId, int eggId, double weight, String date) {
        if (henId >= 0 && henId < hens.length) {
            hens[henId].layEgg(new Egg(eggId, weight, date));
        }
    }

    /**
     * Prints all eggs of a specific hen
     *
     * @param henId {@code int} ID of the hen whose eggs should be printed
     */
    public void printEggs(int henId) {
        if (henId >= 0 && henId < hens.length) {
            hens[henId].printEggs();
        }
    }

    /**
     * Transfers all eggs from one hen to another
     *
     * @param fromHenId {@code int} ID of the hen giving the eggs
     * @param toHenId   {@code int} ID of the hen receiving the eggs
     */
    public void transferEggs(int fromHenId, int toHenId) {
        if (fromHenId >= 0 && fromHenId < hens.length && toHenId >= 0 && toHenId < hens.length) {
            hens[fromHenId].transferEggsTo(hens[toHenId]);
        }
    }
}


