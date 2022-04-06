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
public class Caballero extends Personajes{
    
    public Caballero()  //Constructor "vacio"
    {
        super();
    }
    public Caballero(String nombre, double nivel_vida, double nivel_defensa, double nivel_ataque)
    {   //Constructor Lleno
        super(nombre, nivel_vida, nivel_defensa, nivel_ataque);
    }
    
    //Ataque del Caballero
    public double C_Attack()
    {   //Comprueba si esta atacando o defendiendose
        if (this.Decision == true)  //Ataca
        {   //Aqui se establece el daño que se hara con un numero aleatorio y lo muestra
            dano = (int) (Math.random() * this.Nivel_Ataque);
            System.out.println("\tEl caballero inflingio: " + dano + " de dano");
            return dano;
        }
        else    //Se defiende
        {
            int defender = 1;
            System.out.println("\tEl caballero se defendio");
            return defender;
        }
    }
}