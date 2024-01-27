package MenuSettings;

import AnimationSettings.AnimationMenu;

import java.awt.*;
import java.util.ArrayList;
public class Menu {
    private ArrayList<MenuOption> options;
    private ArrayList<AnimationMenu> animations;

    public ArrayList<MenuOption> getOptions() {
        return options;
    }
    public Menu() {
        inicialize();
    }
    public void inicialize(){
        options = new ArrayList<>();
        animations = new ArrayList<>();
    }
    public void addAnimation(AnimationMenu animationMenu){
        animations.add(animationMenu);
    }
    public void addMenuOption(MenuOption menuOption){
        options.add(menuOption);
    }
    private void renderAnimations(Graphics graphics){
        for(AnimationMenu animationMenu: animations){
            animationMenu.render(graphics);
        }
    }
    private void renderOptions(Graphics graphics){
        for(MenuOption menuOption: options){
            menuOption.renderIt(graphics);
        }
    }
    public MenuOption getOption(int index){
        return options.get(index);
    }
    public void renderIt(Graphics graphics){
        renderOptions(graphics);
        renderAnimations(graphics);
    }
    public void updateIt(){
       for(MenuOption menuOption: options){
           menuOption.updateIt();
       }
    }
}
