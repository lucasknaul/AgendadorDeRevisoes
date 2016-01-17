package control;

public class Control{
  model.Model m;
  view.View v;

  public Control(){
    m=new model.Model();
    m.loadData();
    v=new view.View(m.getRevisionData(),this);
  }
  public void addVehicle(int id, int nextRevision, String brand, String model, String year, String color, String owner){
    m.addVehicle(id, owner, brand, model, year, color, nextRevision);
    m.saveData();
    update();
  }
  public void removeVehicle(int id){
    m.removeVehicle(id);
    m.saveData();
    update();
  }
  public void editVehicle(int id, int nextRevision, String brand, String model, String year, String color, String owner){
    m.removeVehicle(id);
    m.addVehicle(id, owner, brand, model, year, color, nextRevision);
    m.saveData();
    update();
  }
  public void vehicleVerified(int id){
    m.vehicleVerified(id);
    m.saveData();
    update();
  }
  public void update(){
    v.updateData(m.getRevisionData());
  }
}
