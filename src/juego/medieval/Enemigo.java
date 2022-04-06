/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.medieval;

/**
 *
 * @author MierderTheKat
 */
public class Enemigo extends Personajes{
    
    public Enemigo() //Constructor "vacio"
    {
        super();
    }
    public Enemigo(String nombre, double nivel_vida, double nivel_defensa, double nivel_ataque)
    {   //Constructor Lleno
        super(nombre, nivel_vida, nivel_defensa, nivel_ataque);
    }
    
    @Override
    // con polimorfismo edito esta funcion de la clase padre
    public void Decision()
    {   //Aqui el enemigo decide aleatoriamente 50/50 si ataca o se defiende
        int decidir = (int) (Math.random() * 100);
        if (decidir <= 50)  //Atacó
        {
            this.Decision = true;
        }
        else    //Se Defendió
        {
            this.Decision = false;
        }
    }
    
    //Ataque del Enemigo
    public double E_Attack()
    {   //Comprueba si esta atacando o defendiendose
        if (this.Decision == true) //Ataca
        {   //Aqui se establece el daño que se hara con un numero aleatorio y lo muestra
            dano = (int) (Math.random() * this.Nivel_Ataque);
            System.out.println("\tEl enemigo inflingio: " + dano + " de dano");
            return dano;
        }
        else    //Se defiende
        {
            int defender = 1;
            System.out.println("\tEl enemigo se defendio");
            return defender;
        }
    }
}