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
public class coffee_maker {
    public ArrayList<String> recursos = new ArrayList();
    public ArrayList<Double> quantidade = new ArrayList();
    
    public coffee_maker(){
        this.recursos.add("agua");
        this.recursos.add("leite");
        this.recursos.add("cafe");
        
        this.quantidade.add(300.0);
        this.quantidade.add(200.0);
        this.quantidade.add(100.0);
    }
    
    public void Report(){
        //Imprime a quantidade de recursos
        System.out.printf("Agua: %s ml\n", quantidade.get(0));
        System.out.printf("Leite: %s ml\n", quantidade.get(1));
        System.out.printf("Cafe: %s g\n", quantidade.get(2));
    }
    
    /**
     *
     * @param drink
     * @return
     */
    public Boolean Is_Resouce_Sufficient(menuItem drink){
        boolean can_make = true;
        for(int i = 0; i < drink.quantidade_ingred.size(); i++){
            if(drink.quantidade_ingred.get(i) > this.quantidade.get(i) ){
                System.out.printf("Desculpe, nao temos %s suficiente.\n\n", recursos.get(i));
                can_make = false;
            }
        }
        return can_make;
    }
    
    public void Make_Coffee(menuItem order){
        for(int i = 0; i < order.quantidade_ingred.size(); i++){
            this.quantidade.set(i,this.quantidade.get(i) -order.quantidade_ingred.get(i));
        }
        System.out.printf("Aqui esta seu %s. Aproveite.\n\n", order.name);
    }
}
