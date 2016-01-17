package model;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;

class DataParser implements Serializable{
  public int currentTime;
  public ArrayList<Vehicle>[] vehicleAgenda;
  public Map vehicles;
  public DataParser(int currentTime, ArrayList<Vehicle>[] vehicleAgenda, Map vehicles){
    this.currentTime=currentTime;
    this.vehicleAgenda=vehicleAgenda;
    this.vehicles=vehicles;
  }

  public String toString(){
    return new StringBuffer(" CurrentTime : ").append(this.currentTime)
                    .append(" VehicleAgenda : ").append(this.vehicleAgenda)
                    .append(" Vehicles : ").append(this.vehicles).toString();
  }
}

public class Model{
  private static final int AGENDA_SIZE = 5000;
  public static final String PATH = "resources/model.data";
  private int currentTime;
  private int revisionTime;
  private ArrayList<Vehicle>[] vehicleAgenda;
  private Map<Integer,Vehicle> vehicles;

  public Model(){
    currentTime=300;
    revisionTime=100;
    vehicleAgenda = new ArrayList[AGENDA_SIZE];
    for(int i=0;i<AGENDA_SIZE;i++){
      vehicleAgenda[i]=new ArrayList<Vehicle>();
    }
    vehicles = new HashMap<Integer, Vehicle>();
  }
  public void addVehicle(int id, String owner, String brand, String model, String year, String color, int nextRevision){
    if(!vehicles.containsKey(id)){
      Vehicle v =new Vehicle(id, owner, brand, model, year, color, nextRevision);
      vehicleAgenda[nextRevision].add(v);
      vehicles.put(id, v);
    }
    else{
      System.out.print("Veículo com esse id já existe no sistema.\n");
    }
  }
  public void removeVehicle(int id){
    Vehicle v=vehicles.get(id);
    vehicleAgenda[v.getNextRevision()].remove(v);
    vehicles.remove(id);
    //System.out.print("\nremoveVehicle: Id: "+v+"\n");
  }
  public void vehicleVerified(int id){
    Vehicle v=vehicles.get(id);
    vehicleAgenda[v.getNextRevision()].remove(v);
    v.setNextRevision(v.getNextRevision()+revisionTime);
    vehicleAgenda[v.getNextRevision()].add(v);
  }
  public Object[][] getRevisionData(){
    ArrayList<Object[]> objects= new ArrayList<Object[]>();
    Object[] o;
    Object[][] o2={};
    for(int i=0; i<AGENDA_SIZE; i++){
      Iterator<Vehicle> it = vehicleAgenda[i].iterator();
      for(Vehicle v : vehicleAgenda[i]){
        o = new Object[]{v.getId(), i, v.getBrand(),v.getModel(),v.getYear(),v.getColor(),v.getOwner()}; //{"Data", "Id", "Marca", "Modelo", "Ano", "Cor", "Dono"};
        objects.add(o);
      }
    }
    if(objects.isEmpty())
      return new Object[][]{};
    else
      return objects.toArray(o2);
  }

  public void saveData(){
    try{
      FileOutputStream fout = new FileOutputStream(PATH);
      ObjectOutputStream oout = new ObjectOutputStream(fout);
      oout.writeObject(new DataParser(currentTime,vehicleAgenda,vehicles));
      oout.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void loadData(){
    try{
        FileInputStream fin = new FileInputStream(model.Model.PATH);
        ObjectInputStream oin = new ObjectInputStream(fin);
        DataParser dp = (DataParser) oin.readObject();
        this.currentTime=dp.currentTime;
        this.vehicleAgenda=dp.vehicleAgenda;
        this.vehicles=dp.vehicles;
        oin.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
