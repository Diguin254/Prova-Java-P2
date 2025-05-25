/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dto.InterfaceDTO;
import javax.swing.JPanel;

/**
 *
 * @author alenc
 */
public abstract class InterfacePainel extends JPanel {
    public abstract InterfaceDTO getDados();
    public abstract void setDados(InterfaceDTO dto);
}
