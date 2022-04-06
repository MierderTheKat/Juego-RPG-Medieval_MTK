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
public class Menu {
    
    public Menu(){}
    
    //Menu inicial donde muestra las instrucciones
    public void MenuInicio()
    {
        System.out.println("\t\t Este es un Juego de combates por turnos, donde un Caballero y un Mago pelean contra un Caballero de mayor nivel");
        System.out.println("\n\t\t\t\t\t\t Elegiras entre Atacar (1) o Defenderte (2)");
        System.out.println("\n\t\t\t Ataque.- \n\t\t\t Cuando atacas, generas un numero de daño aleatorio dentro del rango de tu Nivel de Ataque, \n\t\t\t\t el cual le hace un daño total a tu enemigo si este no eligio defenderse.");
        System.out.println("\n\t\t\t Defensa.- \n\t\t\t Cuando te defiendes, el daño que te provoque el enemigo es reducido por tu Nivel de Defensa, \n\t\t\t\t si tu nivel de defensa es mayor a su nivel de ataque, el ataque es anulado.");
        System.out.println("\n\t\t\t Enemigo.- \n\t\t\t El enemigo elige aleatoriamente el Atacar o Defenderse, con las mismas caracteristicas mencionadas.");
        System.out.println("\n\t\t\t Caracteristica Especial del Mago: \n\t\t\t Cada turno el mago recupera 1 de vida.");
        System.out.println("\n\t\t\t El Juego Finaliza cuando el guerrero y el mago aliados Mueren, o cuando derrotan al enemigo.");
        System.out.println("\n\t\t\t\t Jugar ya: 1 \t\t\t\t Editar Características de Personajes: 2\n\n\n");
    }
    
    //Estadisticas de los personajes durante el juego
    public void MostrarSpecs(Personajes caballero, Personajes mago, Personajes enemigo)
    {
        System.out.println(" Caballero " + "\t\t\t\t   Mago" + "\t\t\t\t\t\t Enemigo");
        System.out.println("Vida: " + caballero.getNivel_Vida() + "\t\t\t\tVida: " + mago.getNivel_Vida() + "\t\t\t\t\tVida: " + enemigo.getNivel_Vida());
        System.out.println("Ataque: " + caballero.getNivel_Ataque() + "\t\t\t\tAtaque: " + mago.getNivel_Ataque() + "\t\t\t\t\tAtaque: " + enemigo.getNivel_Ataque());
        System.out.println("Defensa: " + caballero.getNivel_Defensa() + "\t\t\t\tDefensa: " + mago.getNivel_Defensa() + "\t\t\t\t\tDefensa: " + enemigo.getNivel_Defensa());
    }
    
    //Estadisticas de los personajes en la instancia de editar caracteristicas
    public void MostrarSpecs2(Personajes caballero, Personajes mago, Personajes enemigo)
    {
        System.out.println("     1 \t\t\t\t\t      2 \t\t\t      3");
        System.out.println(" Caballero " + "\t\t\t\t     Mago" + "\t\t\t   Enemigo");
        System.out.println("Nombre: " + caballero.getNombre() + "\t\t\t\tNombre: " + mago.getNombre() + "\t\t\tNombre: " + enemigo.getNombre());
        System.out.println("Vida: " + caballero.getNivel_Vida() + "\t\t\t\tVida: " + mago.getNivel_Vida() + "\t\t\tVida: " + enemigo.getNivel_Vida());
        System.out.println("Ataque: " + caballero.getNivel_Ataque() + "\t\t\t\tAtaque: " + mago.getNivel_Ataque() + "\t\t\tAtaque: " + enemigo.getNivel_Ataque());
        System.out.println("Defensa: " + caballero.getNivel_Defensa() + "\t\t\t\tDefensa: " + mago.getNivel_Defensa() + "\t\t\tDefensa: " + enemigo.getNivel_Defensa());
    }
    
    // Hacer espacios
    public void espacio()
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    // "pausar"
    public void pausa()
    {
        System.out.println("\n    Presiona enter para continuar: ");
        new Scanner(System.in).nextLine();
    }
    
    // Editar Caracteristicas de los personajes
    public void EditarCar(Personajes caballero, Personajes mago, Personajes enemigo, Animacion animar)
    {
        int a = 4, b = 1;
        while (a < 1 || a > 2)
        {
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();
            switch (a) {
            //Continuar e ir directamente a jugar
                case 1:
                    break;
            //Editar las caracteristicas
                case 2:
                    while (b >= 1 && b <= 4)
                    {
                        espacio();
                        animar.Estadisticas(); // Muestra a lo personajes
                        MostrarSpecs2(caballero, mago, enemigo); // Muestra las estaditicas de todos
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t"
                        + "Jugar ya: 4\n\t\t¿A que personaje quieres cambiarle sus caracteristicas?");
                        b = scan.nextInt();
                        espacio();
                        switch (b)
                        {
                            case 1:
                                animar.Estadisticas(); // Muestra a lo personajes
                                MostrarSpecs2(caballero, mago, enemigo); // Muestra las estaditicas de todos
                                caballero.setCaracteristicas(); // Establece nuevos atributos
                                break;
                            case 2:
                                animar.Estadisticas(); // Muestra a lo personajes
                                MostrarSpecs2(caballero, mago, enemigo); // Muestra las estaditicas de todos
                                mago.setCaracteristicas(); // Establece nuevos atributos
                                break;
                            case 3:
                                animar.Estadisticas(); // Muestra a lo personajes
                                MostrarSpecs2(caballero, mago, enemigo); // Muestra las estaditicas de todos
                                enemigo.setCaracteristicas(); // Establece nuevos atributos
                                break;
                            case 4:
                                b = 5; // Sale del menu, directo al juego
                                break;
                            default:
                                System.out.println("\n\n\n\t\tIntroduce un numero valido\n\n");
                                pausa();
                                b = 1;
                                break;
                        }
                    }   break;
                default:
                    System.out.println("Introduce un numero valido: ");
                    break;
            }
        }
    }
    
    // se ejecuta para ver si quiere volver a jugar y si acepta se Reinicia el Juego
    public boolean reiniciar(boolean a,Personajes caballero, Personajes mago, Personajes enemigo)
    {
        int b = 3;
        Scanner scan = new Scanner(System.in);
        while (b == 3)
        {
            pausa();
            espacio();
            espacio();
            System.out.println("\t ¿Quieres jugar de nuevo?\n\t\t\t\t Si: 1   No: 2\n\n");
            b = scan.nextInt();
            switch (b) {
            
                case 1: // Entra aqui si acepta volver a jugar
                    // Reestablece la vida de los personajes a la vida Default
                    caballero.setVidaReiniciar(mago, enemigo);
                    a = true;
                    break;
                case 2: //Entra aqui si NO acepta volver a jugar
                    a = false;
                    break;
                default:
                    espacio();
                    System.out.println("\n\n\n\t\tIntroduce un numero valido\n\n");
                    b = 3;
                    break;
            }
        }
        return a;
    }
}