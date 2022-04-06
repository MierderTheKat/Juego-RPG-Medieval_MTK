/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.medieval;

import juego.medieval.Personajes;
import juego.medieval.Animacion;

/**
 *
 * @author MierderTheKat
 * @author Francisco Javier Rivera Ing. en Software 2A
 */
public class _Main_Juego_ {

    public static void main(String[] args) {
        
        // Se crean los objetos de las clases y se rellenan
        //                                    Nombre   |Vida|Def|Ataq
        Enemigo Enemigo = new Enemigo       ("Lucifer", 300, 100, 200);
        Caballero Caballero = new Caballero ("Ban"    , 250, 70 , 170);
        Mago Mago = new Mago                ("Merlin" , 190, 90 , 130);
        Animacion animar = new Animacion();
        Menu menu = new Menu();
        
// PELEA, donde se usan los metodos en orden, asi como las animaciones--------------------------------------------------------
        boolean a = true, b = false;
        while (a == true)
        {
            menu.espacio();
            b = false;
            animar.Instrucciones(); // palabra "Instrucciones"
            menu.MenuInicio();  // Menu inicial con las reglas
            //Decide si empezar el juego o editar las caracteristicas de los personajes
            menu.EditarCar(Caballero, Mago, Enemigo, animar);
            
            while (b == false) // Inicia el juego
            {
                if (Mago.getNivel_Vida() <= 0 && Caballero.getNivel_Vida() <= 0 && Enemigo.getNivel_Vida() <= 0)
                {   //Entra aqui si la vida de TODOS llega a 0
                    menu.espacio();
                    animar.Empate();    // Marca un EMPATE
                    b = true;
                    a = menu.reiniciar(a, Caballero, Mago, Enemigo); // Se decide si se quiere reiniciar el juego
                }
                else if (Mago.getNivel_Vida() <= 0 && Caballero.getNivel_Vida() <= 0)
                {   // Entra aqui si el Mago y Caballero mueren
                    menu.espacio();
                    animar.GameOver();  // Marca una DERROTA
                    b = true;
                    a = menu.reiniciar(a, Caballero, Mago, Enemigo); // Se decide si se quiere reiniciar el juego
                }
                else if (Enemigo.getNivel_Vida() <= 0)
                {   // Entra aqui si el Enemigo muere
                    menu.espacio();
                    animar.Winner();    // Marca una VICTORIA
                    b = true;
                    a = menu.reiniciar(a, Caballero, Mago, Enemigo); // Se decide si se quiere reiniciar el juego
                }
                else if (Mago.getNivel_Vida() <= 0 || Caballero.getNivel_Vida() <= 0)
                {   // Entra aqui si Muere el MAGO o el CABALLERO
                    if (Mago.getNivel_Vida() <= 0)
                    {   // Entra aqui si Muere el MAGO
                        animar.Elegir_Caballero_1(); // Animacion de elegir (esta solo el caballero y el enemigo)
                        Mago.Nivel_Vida = 0; // Poner la vida del mago en 0 (fines esteticos)
                        menu.MostrarSpecs(Caballero, Mago, Enemigo); // Muestra las caracteristicas de todos

                        System.out.println("\tDecision del caballero: ");
                        Caballero.Decision();   //Toma la decision del caballero
                        animar.Caballero_1(Caballero.Decision); //Anima la decision del caballero

                        Caballero.C_Attack(); // Si ataca Genera el daño que se hara al enemigo y lo muestra, o se defiende
                        menu.pausa();

                        animar.Caballero_1(Caballero.Decision); //Anima la decision del caballero

                        System.out.println("\tDecision aleatoria del enemigo: ");
                        Enemigo.Decision(); // el Enemigo decide aleatoriamente
                        menu.pausa();
                        animar.Enemigo_Caballero(Enemigo.Decision); // Muestra animada la desicion tomada
                        Enemigo.E_Attack(); // Si ataca se Genera el daño que se hara a los aliados y lo muestra, o se defiende
                        menu.pausa();
                        menu.espacio();

                        animar.Resumen(); //Anima la palabra "Resumen"
                        Mago.Nivel_Vida = 0; // Poner la vida del mago en 0 (fines esteticos)
                        Mago.Ataque_O_Defensa(Caballero, Enemigo); // Se Inflinge el daño dicho antes o se aplica la defensa
                        Mago.Nivel_Vida = 0; // Poner la vida del mago en 0 (fines esteticos)
                        System.out.println("\n\n");
                        menu.MostrarSpecs(Caballero, Mago, Enemigo); // Muestra las caracteristicas de todos
                        System.out.println("\n\n\n\n");
                        menu.pausa();

                    }
                    else if (Caballero.getNivel_Vida() <= 0) //Muere el CABALLERO
                    {   // Entra aqui si Muere el CABALLERO
                        animar.Elegir_Mago_1(); // Animacion de elegir (esta solo el mago y el enemigo)
                        Caballero.Nivel_Vida = 0;   // Poner la vida del caballero en 0 (fines esteticos)
                        menu.MostrarSpecs(Caballero, Mago, Enemigo);// Muestra las caracteristicas de todos

                        System.out.println("\tDecision del mago: ");
                        Mago.Decision();    //Toma la decision del mago
                        animar.Mago_1(Mago.Decision); //Anima la decision del mago

                        Mago.M_Attack();// Si ataca Genera el daño que se hara al enemigo y lo muestra, o se defiende
                        Mago.Curacion();// habilidad unica del mago, se recupera 10 de vida
                        menu.pausa();

                        animar.Mago_1(Mago.Decision); //Anima la decision del mago

                        System.out.println("\tDecision aleatoria del enemigo: ");
                        Enemigo.Decision(); // el Enemigo decide aleatoriamente
                        menu.pausa();
                        animar.Enemigo_Mago(Enemigo.Decision); // Muestra animada la desicion tomada
                        Enemigo.E_Attack(); // Si ataca se Genera el daño que se hara a los aliados y lo muestra, o se defiende
                        menu.pausa();
                        menu.espacio();

                        animar.Resumen(); //Anima la palabra "Resumen"
                        Caballero.Nivel_Vida = 0; // Poner la vida del caballero en 0 (fines esteticos)
                        Mago.Ataque_O_Defensa(Caballero, Enemigo); // Se Inflinge el daño dicho antes o se aplica la defensa
                        Caballero.Nivel_Vida = 0; // Poner la vida del caballero en 0 (fines esteticos)
                        System.out.println("\n\n");
                        menu.MostrarSpecs(Caballero, Mago, Enemigo); // Muestra las caracteristicas de todos
                        System.out.println("\n\n\n\n");
                        menu.pausa();
                    }
                }
                else if (Mago.getNivel_Vida() > 0 && Caballero.getNivel_Vida() > 0) //Ambos estan vivos
                {
                    animar.Elegir_Ambos(); // Animacion de elegir (estan todos)
                    menu.MostrarSpecs(Caballero, Mago, Enemigo); // Muestra las caracteristicas de todos
                    System.out.println("\tDecision del caballero: ");
                    Caballero.Decision();   //Toma la decision del caballero
                    animar.Caballero_2(Caballero.Decision); //Anima la decision del caballero

                    System.out.println("\tDecision del mago: ");
                    Mago.Decision(); //Toma la decision del mago
                    animar.Mago_2(Mago.Decision); //Anima la decision del mago
                    Caballero.C_Attack(); // Si caballero ataca Genera el daño que se hara al enemigo y lo muestra, o se defiende
                    Mago.M_Attack(); // Si mago ataca Genera el daño que se hara al enemigo y lo muestra, o se defiende
                    Mago.Curacion(); // habilidad unica del mago, se recupera 10 de vida
                    menu.pausa();

                    animar.Mago_2(Mago.Decision); //Anima la decision del mago

                    System.out.println("\tDecision aleatoria del enemigo: ");
                    Enemigo.Decision(); // el Enemigo decide aleatoriamente
                    menu.pausa();
                    animar.Enemigo_Ambos(Enemigo.Decision); // Muestra animada la desicion tomada
                    Enemigo.E_Attack(); // Si ataca se Genera el daño que se hara a los aliados y lo muestra, o se defiende
                    menu.pausa();
                    menu.espacio();

                    animar.Resumen(); //Anima la palabra "Resumen"
                    Mago.Ataque_O_Defensa(Caballero, Enemigo); // Se Inflinge el daño dicho antes o se aplica la defensa
                    System.out.println("\n\n");
                    menu.MostrarSpecs(Caballero, Mago, Enemigo); // Muestra las caracteristicas de todos
                    System.out.println("\n\n\n\n");
                    menu.pausa();
                }
            }
        }
    }
}

/*

// Casi todas las animaciones estan aqui

            animar.Caballero_1(true);   //CUANDO MUERE EL MAGO Y ESTA VIVO EL CABALLERO Y ESTA ATACANDO
            animar.Caballero_1(false);  //CUANDO MUERE EL MAGO Y ESTA VIVO EL CABALLERO Y ESTA DEFENDIENDO
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.Caballero_2(true);   //CUANDO AMBOS ESTAN VIVOS Y EL CABALLERO ESTA ATACANDO
            animar.Caballero_2(false);  //CUANDO AMBOS ESTAN VIVOS Y EL CABALLERO ESTA DEFENDIENDO
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.Mago_1(true);        //CUANDO MUERE EL CABALLERO Y ESTA VIVO EL MAGO Y ESTA ATACANDO
            animar.Mago_1(false);       //CUANDO MUERE EL CABALLERO Y ESTA VIVO EL MAGO Y ESTA DEFENDIENDO
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.Enemigo_Ambos(true);         //CUANDO AMBOS ESTAN VIVOS Y EL ENEMIGO ESTA ATACANDO
            animar.Enemigo_Ambos(false);        //CUANDO AMBOS ESTAN VIVOS Y EL ENEMIGO ESTA DEFENDIENDO
            animar.Enemigo_Caballero(true);     //CUANDO SOLO ESTA VIVO EL CABALLERO Y EL ENEMIGO ESTA ATACANDO
            animar.Enemigo_Caballero(false);    //CUANDO SOLO ESTA VIVO EL CABALLERO Y EL ENEMIGO ESTA DEFENDIENDO
            animar.Enemigo_Mago(true);          //CUANDO SOLO ESTA VIVO EL MAGO Y EL ENEMIGO ESTA ATACANDO
            animar.Enemigo_Mago(false);         //CUANDO SOLO ESTA VIVO EL MAGO Y EL ENEMIGO ESTA DEFENDIENDO
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.Elegir_Ambos();          //CUANDO AMBOS ESTAN VIVOS Y ELIGEN CADA UNO ATACAR O DEFENDER
            animar.Elegir_Caballero_1();    //CUANDO SOLO ESTA VIVO EL CABALLERO Y ELIGE ATACAR O DEFENDER
            animar.Elegir_Mago_1();         //CUANDO SOLO ESTA VIVO EL MAGO Y ELIGE ATACAR O DEFENDER
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.Muerte_Enemigo_Ambos();      //CUANDO AMBOS ESTAN VIVOS Y MUERE EL ENEMIGO
            animar.Muerte_Enemigo_Caballero();  //CUANDO SOLO ESTA VIVO EL CABALLERO Y MUERE EL ENEMIGO
            animar.Muerte_Enemigo_Mago();       //CUANDO SOLO ESTA VIVO EL MAGO Y MUERE EL ENEMIGO
System.out.println("\n-----------------------------------------------------------------------------------------------------\n");
            animar.GameOver();  //CUANDO MUEREN AMBOS PERSONAJES
            animar.Winner();    //CUANDO MUERE EL ENEMIGO
        */