package CARRERA;

import static java.lang.Math.random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Carrera extends Thread{
    
    private JLabel etiqueta;
    private PRINCIPAL carro;

    public Carrera(JLabel etiqueta, PRINCIPAL carro) {
        this.etiqueta = etiqueta;
        this.carro = carro;
    }
    
    public void run(){
        
        int carro1 = 0;
        int carro2 = 0;
        int carro3 = 0;
    
        while (true) {            
            try {
                
                sleep((int)(Math.random() * 1000));
                carro1 = carro.getPrimerCarro().getLocation().x;
                carro2 = carro.getSegundoCarro().getLocation().x;
                carro3 = carro.getTercerCarro().getLocation().x;
                
                if (carro1 < carro.getMeta().getLocation().x - 50 && carro2 < carro.getMeta().getLocation().x - 50 && carro3 < carro.getMeta().getLocation().x - 50) {
                    etiqueta.setLocation(etiqueta.getLocation().x + 20, etiqueta.getLocation().y);
                    carro.repaint();
                }else {
                    break;
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            if (etiqueta.getLocation().x >= carro.getMeta().getLocation().x - 50) {
                if (carro1 > carro2 && carro1 > carro3) {
                    JOptionPane.showMessageDialog(null, "GANO EL PRIMER CARRO!");
                } else {
                    if (carro2 > carro1 && carro2 > carro3) {
                        JOptionPane.showMessageDialog(null, "GANO EL SEGUNDO CARRO!");
                    } else{
                        if (carro3 > carro1 && carro3 > carro2) {
                            JOptionPane.showMessageDialog(null, "GANO EL TERCER CARRO!");
                        } else{
                            JOptionPane.showMessageDialog(null, "EMPATE!");
                        }
                    }
                }
            }
            
        }
    }
}
