import java.util.ArrayList;

public class CompositeMenu extends MenuComponent {

    String name;
    String description;
    ArrayList<MenuComponent> children = new ArrayList<>();

    public CompositeMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public void add(MenuComponent menuComponent) {
        children.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        children.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return children.get(i);
    }

    @Override
    public void print(int indent) {
        String pad = "  ".repeat(indent);
        int width = Math.max(10, 40 - indent * 2);
        System.out.println();
        System.out.println(pad + "-".repeat(width));
        System.out.println(pad + "  [MENU] " + name.toUpperCase());
        System.out.println(pad + "  " + description);
        System.out.println(pad + "-".repeat(width));
        for (MenuComponent child : children) {
            child.print(indent + 1);
        }
    }
}
