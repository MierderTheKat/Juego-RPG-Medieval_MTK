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
public class Mago extends Personajes{
    
    public Mago()   //Constructor "vacio"
    {
        super();
    }
    public Mago(String nombre, double nivel_vida, double nivel_defensa, double nivel_ataque)
    {   //Constructor Lleno
        super(nombre, nivel_vida, nivel_defensa, nivel_ataque);
    }
    
    //Ataque del Mago
    public double M_Attack()
    {   //Comprueba si esta atacando o defendiendose
        if (this.Decision == true)  //Ataca
        {   //Aqui se establece el daño que se hara con un numero aleatorio y lo muestra
            dano = (int) (Math.random() * this.Nivel_Ataque);
            System.out.println("\tEl mago inflingio: " + dano + " de dano");
            return dano;
        }
        else    //Se defiende
        {
            int defender = 1;
            System.out.println("\tEl mago se defendio");
            return defender;
        }
    }
    
    //Funcion Salud del mago
    public void Curacion()
    {   //Cada turno el mago eleva 10 puntos en su nivel de vida
        this.Nivel_Vida = this.Nivel_Vida + 10;
    }
}