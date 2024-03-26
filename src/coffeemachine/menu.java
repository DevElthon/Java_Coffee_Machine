/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeemachine;
import java.util.ArrayList;
/**
 *
 * @author eltho
 */
class menuItem{
    //Apresente ingredientes a serem utilizados
    ArrayList<String> ingredientes = new ArrayList();
    ArrayList<Double> quantidade_ingred = new ArrayList();
    String name;
    double cost, water, milk, coffee;
    
    public menuItem(String name, double cost, double water, double milk, double coffee){
        this.name = name;
        this.cost = cost;
        
        ingredientes.add("agua");
        ingredientes.add("leite");
        ingredientes.add("cafe");
        
        quantidade_ingred.add(water);
        quantidade_ingred.add(milk);
        quantidade_ingred.add(coffee);
    }
}

public class menu {
    //Apresenta bebidas 
    ArrayList<menuItem> menu = new ArrayList();
    //Itens
    menuItem item_1 = new menuItem("latte \n", 2.5, 200, 150, 24);
    menuItem item_2 = new menuItem("espresso \n", 1.5, 50, 0, 18);
    menuItem item_3 = new menuItem("cappuccino \n", 3, 250, 50, 24);
    
    public menu(){
        menu.add(item_1);
        menu.add(item_2);
        menu.add(item_3);
    }
    
    public String get_items(){
        //retorna os nomes dos itens disponiveis
        String options = "";
        for(int i = 0; i < menu.size(); i++){
            options += menu.get(i).name;
        }
        return options;
    }
    
    public menuItem Find_drink(String order_name){
        //Procura por uma bebida especifica. Se tiver, retorna a mesma se não, retorna nada
        for(int i = 0; i < menu.size(); i++){
            if(menu.get(i).name.contains(order_name)){
                return menu.get(i);
            }
        }
        System.out.println("Desculpe, o item escolhido nao esta disponivel.\n\n");
        return null;
    }
}
