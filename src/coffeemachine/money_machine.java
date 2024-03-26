/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffeemachine;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eltho
 */
public class money_machine {
    String Currency = "$";
    ArrayList<String> coin = new ArrayList();
    ArrayList<Double> coin_values = new ArrayList();
    
    double profit, money_recieved = 0;
    
    public money_machine(){
        //nomes das moedas
        coin.add("quarters");
        coin.add("dimes");
        coin.add("nickles");
        coin.add("pennies");
        
        //valores das moedas
        coin_values.add(0.25);
        coin_values.add(0.1);
        coin_values.add(0.05);
        coin_values.add(0.01);
    }
    
    public void Report(){
        //imprime o valor do lucro atual
        System.out.printf("Money: %s%s", this.Currency, this.profit);
    }
    
    Double Process_Coins(){
        //retorno o valor total de acordo com as moedas inseridas
        System.out.println("Por favor, insira moedas.");
        for(int i = 0; i < this.coin_values.size(); i++){
            Scanner money = new Scanner(System.in);
            System.out.printf("Quantas %s\n", this.coin.get(i));
            double money_d = money.nextDouble();
            this.money_recieved += money_d * coin_values.get(i);
        }
        return this.money_recieved;
    }
    
    public Boolean Make_Payment(Double cost){
        //Retorna verdadeiro quando o pagamento é aceito ou falso se for insuficiente
        this.Process_Coins();
        if(this.money_recieved >= cost){
            double change = Math.round(this.money_recieved - cost);
            System.out.printf("Aqui esta %s %s como troco.\n", this.Currency, change);
            this.profit += cost;
            this.money_recieved = 0;
            return true;
        }
        else{
            System.out.println("Desculpe, nao eh dinheiro suficiente. Dinheiro devolvido.\n\n");
            this.money_recieved = 0;
            return false;
        }
    }
}
