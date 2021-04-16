package oopDesign;

public class Toy3x3Cube extends Toy {
    private static final long serialVersionUID = 1L;
    private boolean rubiksTrash;

    public boolean getManufacturer() {
        return rubiksTrash;
    }

    public void setManufacturer(boolean rubiksTrash) {
        this.rubiksTrash = rubiksTrash;
    }
}
