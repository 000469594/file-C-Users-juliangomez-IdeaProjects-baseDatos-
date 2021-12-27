import modelos.Jugador;
import modelos.Pregunta;
import modelos.Respuesta;
import negocio.ConfiguracionJuego;
import negocio.IniciarJuego;
import negocio.RegistroHistorico;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Juego {
    Scanner sn = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {


        Scanner sn = new Scanner(System.in);
        RegistroHistorico registroHistorico = new RegistroHistorico();



                boolean salir = false;
                int opcion; //Guardaremos la opcion del usuario
                do{
                    System.out.println("Escribe una de las opciones");
                    System.out.println("1. Configurar juego");
                    System.out.println("2. Iniciar juego");
                    System.out.println("3. Mostrar historico juego");
                    System.out.println("4. Salir");
                    opcion = sn.nextInt();
                    switch(opcion){
                        case 1:

                            for (int i = 1; i <=5 ; i++) {
                                ConfiguracionJuego configuracionJuego = new ConfiguracionJuego();
                              configuracionJuego.ingresarCategoria();
                              System.out.println("valor id categoria  en el menu" + configuracionJuego.getId_categoria());
                              for (int j= 1; j<=5; j++){
                                  configuracionJuego.ingresarPregunta(j);
                                  for (int m=1;m<=4;m++){
                                      configuracionJuego.ingresarRespuesta(m);
                                  }
                              }


                            }

                            break;
                        case 2:
                            System.out.println("Has seleccionado la opcion 2");
                            IniciarJuego iniciarJuego =  new IniciarJuego();
                            int CantidadRondasJugar = 5;
                            Jugador jugador = new Jugador();
                            Pregunta pregunta;
                            int identificadorCategoria = 0;
                            List<Respuesta> lsRespuestas;
                            boolean resultadoRonda;


                            Scanner snNombreJugador = new Scanner(System.in);
                            snNombreJugador.useDelimiter("\n");
                            System.out.println("Ingrese su nombre de jugador y de enter");
                            String nombreJugador  = snNombreJugador.next();
                            jugador.setNombre(nombreJugador);

                            for (int i = 1; i <=CantidadRondasJugar ; i++){
                                identificadorCategoria = iniciarJuego.obtenerIdentificadorCategoria(i);
                                pregunta = iniciarJuego.obtenerPreguntaAleatoria(identificadorCategoria);
                                lsRespuestas =  iniciarJuego.obtenerRespuestasPregunta(pregunta.getId_pregunta());
                                resultadoRonda = iniciarJuego.rondaJuego(i,pregunta,lsRespuestas);
                                if(resultadoRonda){
                                    jugador.setAcumuladoPuntos(jugador.getAcumuladoPuntos() +10);
                                    System.out.println("puntuacion acumulada: " + jugador.getAcumuladoPuntos() );
                                    if(i!=CantidadRondasJugar){
                                        System.out.println("si desea retirarse escriba: retiro");
                                        System.out.println("si desea continuar   escriba cualquier caracter y de enter");
                                        Scanner snretiro = new Scanner(System.in);
                                        String retiro  = snretiro.next();
                                        if(retiro.equalsIgnoreCase("retiro")){
                                            jugador.setEstadoFinalizacion("retirado");
                                            System.out.println(jugador.getNombre() +" usted se retiro en la ronda: " + i +" con puntuacion de: " + jugador.getAcumuladoPuntos());
                                            break;
                                        }

                                    }
                                    if(i==CantidadRondasJugar){
                                        System.out.println("FELICIDADES" + jugador.getNombre() + " GANASTE  EL JUEGO CON UNA PUNTUACION DE: "+jugador.getAcumuladoPuntos()  );
                                        jugador.setEstadoFinalizacion("ganador completo");
                                    }
                                }else {
                                    System.out.println("Perdiste  " + jugador.getNombre() + " :( tu puntuacion fue:" + jugador.getAcumuladoPuntos());
                                    jugador.setEstadoFinalizacion("perdedor");
                                    break;
                                }

                            }
                            registroHistorico.registrarJugador(jugador);

                            break;
                        case 3:
                            System.out.println("Has seleccionado la opcion 3");
                            List<Jugador> lstJugadores =  registroHistorico.obtenerRegistroHistorico();
                            System.out.println("|nombre| puntos| estado finalizados|");
                            for (Jugador jugadordata : lstJugadores) {
                                System.out.println(jugadordata.getNombre() + " | " + jugadordata.getAcumuladoPuntos() + " | " + jugadordata.getEstadoFinalizacion());
                            }
                            break;
                        case 4:
                            salir=true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                }
                while(!salir);
            }
        }
