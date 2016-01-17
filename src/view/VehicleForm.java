package view;

import java.util.Calendar;
import javax.swing.*;
import javax.swing.event.*;
import java.util.EventListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

public class VehicleForm extends JPanel{
  View view;
  int vehicleId;
  JTextField idData, brandData, modelData, yearData, colorData, ownerData, nextRevisionData;
  JButton sendButton;

  public VehicleForm(View view){
    super();
    this.view=view;
    sendButton = new JButton();
    JLabel idLabel = new JLabel("Registro", JLabel.TRAILING);
    JLabel brandLabel = new JLabel("Marca", JLabel.TRAILING);
    JLabel modelLabel = new JLabel("Modelo", JLabel.TRAILING);
    JLabel yearLabel = new JLabel("Ano", JLabel.TRAILING);
    JLabel colorLabel = new JLabel("Cor", JLabel.TRAILING);
    JLabel ownerLabel = new JLabel("Dono", JLabel.TRAILING);
    JLabel nextRevisionLabel = new JLabel("Última Revisão", JLabel.TRAILING);

    idData=new JTextField(8);
    brandData=new JTextField(10);
    modelData=new JTextField(10);
    yearData=new JTextField(4);
    colorData=new JTextField(8);
    ownerData=new JTextField(10);
    nextRevisionData = new JTextField(10);
    this.add(idLabel);
    this.add(idData);
    idLabel.setLabelFor(idData);
    this.add(brandLabel);
    this.add(brandData);
    brandLabel.setLabelFor(brandData);
    this.add(modelLabel);
    this.add(modelData);
    modelLabel.setLabelFor(modelData);
    this.add(yearLabel);
    this.add(yearData);
    yearLabel.setLabelFor(yearData);
    this.add(colorLabel);
    this.add(colorData);
    colorLabel.setLabelFor(colorData);
    this.add(ownerLabel);
    this.add(ownerData);
    ownerLabel.setLabelFor(ownerData);
    this.add(nextRevisionLabel);
    this.add(nextRevisionData);
    nextRevisionLabel.setLabelFor(nextRevisionData);
    this.add(sendButton);
    sendButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e){
        view.sendVehicleData(Integer.parseInt(idData.getText().toString()),
                              Integer.parseInt(nextRevisionData.getText().toString()),
                                             brandData.getText().toString(),
                                             modelData.getText().toString(),
                                             yearData.getText().toString(),
                                             colorData.getText().toString(),
                                             ownerData.getText().toString().toString());
      }
    });
    setAddMode();
    this.setVisible(true);
  }
  public void setEditionMode(int id, int nextRevision, String brand, String model, String year, String color, String owner){
    //this.state=Screen.STATE_EDIT;
    idData.setText(String.valueOf(id));
    nextRevisionData.setText(String.valueOf(nextRevision));
    brandData.setText(brand);
    modelData.setText(model);
    yearData.setText(year);
    colorData.setText(color);
    ownerData.setText(owner);
    sendButton.setText("Editar");
  }
  public void setAddMode(){
  idData.setText("");
  nextRevisionData.setText("");
  brandData.setText("");
  modelData.setText("");
  yearData.setText("");
  colorData.setText("");
  ownerData.setText("");
  sendButton.setText("Adicionar");
  }
}
