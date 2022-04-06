/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.medieval;

import java.util.Scanner;

/**
 *
 * @author MierderTheKat
 */
public class Personajes {
    
    //Variables protegidas
    protected String Nombre;
    protected double Nivel_Vida;
    protected double Nivel_Ataque;
    protected double Nivel_Defensa;
    protected boolean Decision;
    protected double dano;

    public Personajes() {} //Constructor Vacio
    
    public Personajes(String nombre, double nivel_vida, double nivel_defensa, double nivel_ataque)
    {   //Constructor Lleno
        this.Nombre = nombre;
        this.Nivel_Vida = nivel_vida;
        this.Nivel_Defensa = nivel_defensa;
        this.Nivel_Ataque = nivel_ataque;
    }

//Metodos GET
    public String getNombre()
    {
        return this.Nombre;
    }
    public double getNivel_Vida()
    {
        return this.Nivel_Vida;
    }
    public double getNivel_Defensa()
    {
        return this.Nivel_Defensa;
    }
    public double getNivel_Ataque()
    {
        return this.Nivel_Ataque;
    }
    public boolean getDecision()
    {
        return this.Decision;
    }
    // Un solo Metodo SET para todos
    public void setCaracteristicas()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nIngresa el Nombre: ");
        this.Nombre = scan.nextLine();
        System.out.println("Ingresa el Nivel de Vida: ");
        this.Nivel_Vida = scan.nextDouble();
        System.out.println("Ingresa el Nivel de Defensa: ");
        this.Nivel_Defensa = scan.nextDouble();
        System.out.println("Ingresa el Nivel de Ataque: ");
        this.Nivel_Ataque = scan.nextDouble();
    }

    // Aplico el polimorfismo, esta funcion se usa para el caballero y el mago
    public void Decision()
    {
        int a = 4;
        while (a < 1 || a > 2)
        {
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();
            switch (a) {
                case 1:
                    //Atacar
                    this.Decision = true;
                    break;
                case 2:
                    //Defender
                    this.Decision = false;
                    break;
                default:
                    System.out.println("Introduce un numero valido: ");
                    break;
            }
        }
    }
    
// al Reiniciar el Juego se Ponen la vida DEFAULT De los personajes
    public void setVidaReiniciar(Personajes mago, Personajes enemigo)
    {
        // Vida DEFAULT del Caballero
        this.Nivel_Vida = 250;
        
        // Vida DEFAULT del Mago
        mago.Nivel_Vida = 190;
        
        // Vida DEFAULT del Enemigo
        enemigo.Nivel_Vida = 300;
    }

// Si atacan o defienden, aqui se aplica cuanto daño se dan, si se defiende el daño inflingido disminuye---------------------------------------------------------
    public void Ataque_O_Defensa(Personajes caballero, Personajes enemigo)
    {
//Ataque o defensa del CABALLERO al Enemigo ---------------------------------------------------------------------------------------
        if (caballero.Decision == true && enemigo.Decision == true && caballero.Nivel_Vida > 0) // No se defendio el enemigo
        {// Entra aqui si la decision del caballero y el enemigo fue atacar y estan vivos
            // Le quita al enemigo la vida dependiendo del daño que hizo el caballero
            enemigo.Nivel_Vida = enemigo.Nivel_Vida - caballero.dano;
            if (enemigo.Nivel_Vida <= 0)
            {   // Si la vida del enemigo es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                enemigo.Nivel_Vida = 0;
            }
            //Muestra la informacion del ataque, diciendo en que vida quedo el enemigo
            System.out.println("\n\tCon el ataque de _" + caballero.getNombre() + "_ el enemigo _" + enemigo.getNombre() + "_ quedo en: " + enemigo.Nivel_Vida);
        }
        else if (caballero.Decision == true && enemigo.Decision == false && caballero.Nivel_Vida > 0) // Se defendio el enemigo 
        {// Entra aqui si la decision del caballero fue atacar y el enemigo se defendio y estan vivos
            // Se resta el daño que hizo el caballero con la defensa
            double a = caballero.dano - enemigo.Nivel_Defensa;
            if (a <= 0) //Entra aqui si la defensa del enemigo es mayor al daño
            {   //El daño se establece en 0
                caballero.dano = 0;
                System.out.println("\n\tLa defensa del enemigo es mayor al ataque del caballero");
            }
            else        //Entra aqui si la defensa del enemigo es menor al daño
            {   //Se resta el daño que queda a la vida del enemigo
                enemigo.Nivel_Vida = enemigo.Nivel_Vida - a;
                if (enemigo.Nivel_Vida <= 0)
                {   // Si la vida del enemigo es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                    enemigo.Nivel_Vida = 0;
                }
                //Muestra la informacion del ataque, diciendo en que vida quedo el enemigo
                System.out.println("\n\tCon el ataque de _" + caballero.getNombre() + "_ el enemigo _" + enemigo.getNombre() + "_ quedo en: " + enemigo.Nivel_Vida);
            }
        }
        
//Ataque o defensa del MAGO al Enemigo ------------------------------------------------------------------------------------------------------------------------------
        if (this.Decision == true && enemigo.Decision == true && this.Nivel_Vida > 0) // No se defendio el enemigo
        {// Entra aqui si la decision del mago y el enemigo fue atacar y estan vivos
            // Le quita al enemigo la vida dependiendo del daño que hizo el mago
            enemigo.Nivel_Vida = enemigo.Nivel_Vida - this.dano;
            if (enemigo.Nivel_Vida <= 0)
            {// Si la vida del enemigo es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                enemigo.Nivel_Vida = 0;
            }
            //Muestra la informacion del ataque, diciendo en que vida quedo el enemigo
            System.out.println("\n\tCon el ataque de _" + this.getNombre() + "_ el enemigo _" + enemigo.getNombre() + "_ quedo en: " + enemigo.Nivel_Vida);
        }
        else if (this.Decision == true && enemigo.Decision == false && this.Nivel_Vida > 0) // Se defendio el enemigo
        {// Entra aqui si la decision del mago fue atacar y el enemigo se defendio y estan vivos
            // Se resta el daño que hizo el mago con la defensa
            double a = this.dano - enemigo.Nivel_Defensa;
            if (a <= 0) //Entra aqui si la defensa del enemigo es mayor al daño
            {   //El daño se establece en 0
                this.dano = 0;
                System.out.println("\n\tLa defensa del enemigo es mayor al ataque del mago");
            }
            else        //Entra aqui si la defensa del enemigo es menor al daño
            {   //Se resta el daño que queda a la vida del enemigo
                enemigo.Nivel_Vida = enemigo.Nivel_Vida - a;
                if (enemigo.Nivel_Vida <= 0)
                {   // Si la vida del enemigo es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                    enemigo.Nivel_Vida = 0;
                }
                //Muestra la informacion del ataque, diciendo en que vida quedo el enemigo
                System.out.println("\n\tCon el ataque de _" + this.getNombre() + "_ el enemigo _" + enemigo.getNombre() + "_ quedo en: " + enemigo.Nivel_Vida);
            }
        }
        
//Ataque o defensa del ENEMIGO al CABALLERO --------------------------------------------------------------------------------------------------------------------------
        if (enemigo.Decision == true)// entra aqui si el enemigo ataca
        {
            if (enemigo.Decision == true && caballero.Decision == true && caballero.Nivel_Vida > 0) // No se defendio el caballero
            {// Entra aqui si la decision del enemigo y el caballero fue atacar y estan vivos
                // Le quita al caballero la vida dependiendo del daño que hizo el enemigo
                caballero.Nivel_Vida = caballero.Nivel_Vida - enemigo.dano;
                if (caballero.Nivel_Vida <= 0)
                {   // Si la vida del caballero es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                    caballero.Nivel_Vida = 0;
                }
                //Muestra la informacion del ataque, diciendo en que vida quedo el caballero
                System.out.println("\n\tCon el ataque de _" + enemigo.getNombre() + "_ el caballero _" + caballero.getNombre() + "_ quedo en: " + caballero.Nivel_Vida);
            }
            else if (enemigo.Decision == true && caballero.Decision == false && caballero.Nivel_Vida > 0) // Se defendio el caballero
            {// Entra aqui si la decision del enemigo fue atacar y el caballero se defendio y estan vivos
                // Se resta el daño que hizo el enemigo con la defensa del caballero
                double a = enemigo.dano - caballero.Nivel_Defensa;
                if (a <= 0) //Entra aqui si la defensa del caballero es mayor al daño
                {   //El daño se establece en 0
                    enemigo.dano = 0;
                    System.out.println("\n\tLa defensa del caballero es mayor al ataque del enemigo");
                }
                else    //Entra aqui si la defensa del caballero es menor al daño
                {   //Se resta el daño que queda a la vida del caballero
                    caballero.Nivel_Vida = caballero.Nivel_Vida - a;
                    if (caballero.Nivel_Vida <= 0)
                    {   // Si la vida del caballero es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                        caballero.Nivel_Vida = 0;
                    }
                    //Muestra la informacion del ataque, diciendo en que vida quedo el caballero
                    System.out.println("\n\tCon el ataque de _" + enemigo.getNombre() + "_ el caballero _" + caballero.getNombre() + "_ quedo en: " + caballero.Nivel_Vida);
                }
            }
            
//Ataque o defensa del ENEMIGO al MAGO --------------------------------------------------------------------------------------------------------------------------------------
            if (enemigo.Decision == true && this.Decision == true && this.Nivel_Vida > 0) // No se defendio el mago
            {// Entra aqui si la decision del enemigo y el mago fue atacar y estan vivos
                // Le quita al mago la vida dependiendo del daño que hizo el enemigo
                this.Nivel_Vida = this.Nivel_Vida - enemigo.dano;
                if (this.Nivel_Vida <= 0)
                {// Si la vida del mago es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                    this.Nivel_Vida = 0;
                }
                //Muestra la informacion del ataque, diciendo en que vida quedo el mago
                System.out.println("\n\tCon el ataque de _" + enemigo.getNombre() + "_ el mago _" + this.getNombre() + "_ quedo en: " + this.Nivel_Vida);
            }
            else if (enemigo.Decision == true && this.Decision == false && this.Nivel_Vida > 0) // Se defendio el mago
            {// Entra aqui si la decision del enemigo fue atacar y el mago se defendio y estan vivos
                // Se resta el daño que hizo el enemigo con la defensa del mago
                double a = enemigo.dano - this.Nivel_Defensa;
                if (a <= 0) //Entra aqui si la defensa del mago es mayor al daño
                {   //El daño se establece en 0
                    enemigo.dano = 0;
                    System.out.println("\n\tLa defensa del mago es mayor al ataque del enemigo");
                }
                else        //Entra aqui si la defensa del mago es menor al daño
                {   //Se resta el daño que queda a la vida del mago
                    this.Nivel_Vida = this.Nivel_Vida - a;
                    if (this.Nivel_Vida <= 0)
                    {// Si la vida del mago es menor o igual a 0 se pone la vida en 0 (fines esteticos)
                        this.Nivel_Vida = 0;
                    }
                    //Muestra la informacion del ataque, diciendo en que vida quedo el mago
                    System.out.println("\n\tCon el ataque de _" + enemigo.getNombre() + "_ el mago _" + this.getNombre() + "_ quedo en: " + this.Nivel_Vida);
                }
            }
        }
    }
}