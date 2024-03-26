/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coffeemachine;
import java.util.Scanner;
/**
 *
 * @author eltho
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        money_machine money_mach = new money_machine();
        coffee_maker coffee_mak = new coffee_maker();
        menu menu_ = new menu();
        
        Boolean is_on = true;
        
        while(is_on){
            String options = menu_.get_items();
            Scanner choice = new Scanner(System.in);
            System.out.printf("Qual seria seu pedido? \n%s", options);
            String actual_choice = choice.nextLine();
            
            switch(actual_choice){
                case "off":
                    is_on = false;
                    break;
                case "report":
                    coffee_mak.Report();
                    break;
                default:
                    menuItem drink = menu_.Find_drink(actual_choice);
                    if(options.contains(actual_choice)){
                        if(coffee_mak.Is_Resouce_Sufficient(drink) && money_mach.Make_Payment(drink.cost)){
                            coffee_mak.Make_Coffee(drink);
                        }
                    }
                    else{
                        break;
                    }
            }
        }
    }
    
}
