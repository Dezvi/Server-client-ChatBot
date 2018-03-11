/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_fr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author juanc
 */
public class Cliente_FR {
//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//

    public static void main(String[] args) {

            try {
                DatagramSocket socketUDP = new DatagramSocket();
                byte[] mensaje = "Debes de ir al final".getBytes();
                InetAddress hostServidor = InetAddress.getLocalHost();
                int puertoServidor = 54568;

                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion =
                  new DatagramPacket(mensaje, mensaje.length, hostServidor,
                                     puertoServidor);

                // Enviamos el datagrama
                socketUDP.send(peticion);

                // Construimos el DatagramPacket que contendrá la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta =
                  new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(respuesta);

                // Enviamos la respuesta del servidor a la salida estandar
                System.out.println("Respuesta: " + new String(respuesta.getData()));

                // Cerramos el socket
                socketUDP.close();
            } catch (UnknownHostException e) {
                    System.err.println("Error: Nombre de host no encontrado.");
            } catch (IOException e) {
                    System.err.println("Error de entrada/salida al abrir el socket.");
            }
    }
}
