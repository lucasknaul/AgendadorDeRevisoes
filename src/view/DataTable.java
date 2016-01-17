package view;

import javax.swing.*;
import javax.swing.event.*;
import java.util.EventListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;

public class DataTable extends JScrollPane{
  private JTable table;
  public DataTable(Object[][] data){
    super();
    setData(data);
    this.setVisible(true);
    /*
    this.getSelectionModel().addListSelectionListener(
      new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent e){
          parent.tableClick((int)getSelectedRow());
        }
      }
    );*/
  }
  public void setData(Object[][] data){
    table = new JTable(data, new String[]{"Registro", "Data de Revisão", "Marca", "Modelo", "Ano", "Cor", "Dono"});
    this.setViewportView(table);
  }
  public int getSelectedId(){
    int selectedRow=table.getSelectedRow();
    if(selectedRow>-1){
      return (int)table.getValueAt(table.getSelectedRow(),0);
    }
    else
      return -1;
  }
  public Object[] getSelectedRow(){
    int selectedRow=table.getSelectedRow();
    int colCount = table.getColumnCount();
    if(selectedRow>-1){
      Object[] o = new Object[colCount];
      for(int i=0; i<colCount;i++){
        o[i]=table.getValueAt(selectedRow, i);
      }
      return o;
    }
    else
      return null;
  }
}
