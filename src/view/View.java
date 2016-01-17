package view;

import javax.swing.*;
import javax.swing.event.*;
import java.util.EventListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
  public static final int STATE_ADD=0;
  public static final int STATE_EDIT=1;;

  private control.Control control;
  private DataTable dataTable;
  private ButtonArea buttonArea;
  private VehicleForm VehicleForm;
  private int state;

  public View(Object[][] data, control.Control control){
    super("Agendador de Revisões");
    this.setLayout(new BorderLayout());
    this.control=control;
    dataTable = new DataTable(data);
    buttonArea = new ButtonArea(this);
    VehicleForm = new VehicleForm(this);
    this.add(dataTable, BorderLayout.PAGE_START);
    this.add(buttonArea);
    this.add(VehicleForm, BorderLayout.PAGE_END);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }
  public void selectedVehicleVerified(){
    control.vehicleVerified(dataTable.getSelectedId());
  }
  public void setAddVehicleMode(){
    VehicleForm.setAddMode();
    state=STATE_ADD;
  }
  public void setEditVehicleMode(){
    Object[] row =dataTable.getSelectedRow();
    if(row!=null){
      VehicleForm.setEditionMode((int)row[0], (int)row[1], (String)row[2], (String)row[3], (String)row[4], (String)row[5], (String)row[6]);
      state=STATE_EDIT;
    }
  }
  public void removeSelectedVehicle(){
    int id =dataTable.getSelectedId();
    if(id>-1){
      control.removeVehicle(id);
      state=STATE_ADD;
    }
  }
  public void sendVehicleData(int id, int nextRevision, String brand, String model, String year, String color, String owner){
    if(state==STATE_ADD){
      control.addVehicle(id,nextRevision, brand, model,year,color,owner);
    }
    if(state==STATE_EDIT){
      control.editVehicle(id,nextRevision, brand, model,year,color,owner);
    }
  }
  public void updateData(Object[][] data){
    dataTable.setData(data);
  }
}
