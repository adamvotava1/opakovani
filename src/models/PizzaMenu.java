package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PizzaMenu {
    private List<PizzaMenuItem> menuItems;
    private LocalDateTime lastUpdate;

    public PizzaMenu(){
        menuItems = new ArrayList<>();
        setLastUpdate();
    }
    public void addItem(PizzaMenuItem toAdd){
        menuItems.add(toAdd);
        setLastUpdate();
    }

    @Override
    public boolean equals(Object obj) {
        PizzaMenu menuToCompare = (PizzaMenu) obj;
        if(menuItems.size() != menuToCompare.getMenuItems().size())
            return false;

        for (PizzaMenuItem pizza: menuItems){
            for (int i=0; i < menuItems.size();i++){
                PizzaMenuItem pizzaFromCurrentMenu = menuItems.get(i);
                PizzaMenuItem pizzaFromOtherMenu = menuToCompare.getMenuItems().get(i);

                if(!pizzaFromCurrentMenu.equals(pizzaFromOtherMenu)){
                    return false;
                }
            }
            return true;
        }

        return super.equals(obj);
    }

    public PizzaMenu(List<PizzaMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<PizzaMenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<PizzaMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void removeItem(PizzaMenuItem toRemove){
        menuItems.remove((toRemove));
        setLastUpdate();
    }

    private void setLastUpdate(){
        lastUpdate = LocalDateTime.now();
    }
}
