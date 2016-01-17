package view;

import javax.swing.*;
import javax.swing.event.*;
import java.util.EventListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

class ButtonArea extends JPanel{
  View view;
  JButton vehicleVerifiedButton, addVehicleButton, editVehicleButton, removeVehicleButton;
  public ButtonArea(View view){
    super();
    this.view=view;
    vehicleVerifiedButton=new JButton("Veículo Vistoriado");
    addVehicleButton=new JButton("Adicionar Veículo");
    removeVehicleButton=new JButton("Remover Veículo");
    editVehicleButton=new JButton("Editar Veículo");
    vehicleVerifiedButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        view.selectedVehicleVerified();
      }
    });
    addVehicleButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        view.setAddVehicleMode();
      }
    });
    editVehicleButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        view.setEditVehicleMode();
      }
    });
    removeVehicleButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        view.removeSelectedVehicle();
      }
    });

    this.add(vehicleVerifiedButton);
    this.add(addVehicleButton);
    this.add(editVehicleButton);
    this.add(removeVehicleButton);
    this.setVisible(true);
  }
}
