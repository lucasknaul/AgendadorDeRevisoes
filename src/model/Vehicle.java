package model;

import java.util.Date;
import java.io.Serializable;

class Vehicle implements Serializable{
  private int id;
  private String owner;
  private String brand;
  private String model;
  private String year;
  private String color;
  private int nextRevision;

  public Vehicle(int id, String owner, String brand, String model, String year, String color, int nextRevision){
    this.id=id;
    this.owner=owner;
    this.brand=brand;
    this.model=model;
    this.year=year;
    this.color=color;
    this.nextRevision=nextRevision;
  }

  public String toString(){
    return new StringBuffer(" Id : ").append(this.id)
                    .append(" Owner : ").append(this.owner)
                    .append(" Brand : ").append(this.brand)
                    .append(" Model : ").append(this.model)
                    .append(" Year : ").append(this.year)
                    .append(" Color : ").append(this.color)
                    .append(" NextRevision : ").append(this.nextRevision).toString();
  }
  public void setNextRevision(int newRevision){this.nextRevision=newRevision;}
  public int getId(){return id;}
  public String getOwner(){return owner;}
  public String getBrand(){return brand;}
  public String getModel(){return model;}
  public String getYear(){return year;}
  public String getColor(){return color;}
  public int getNextRevision(){return nextRevision;}
}
