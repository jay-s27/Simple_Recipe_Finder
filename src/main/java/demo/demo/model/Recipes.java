package demo.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Recipes {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  
  private int id;
  private String title;
  private String instructions;
  private double ratings;
  private double cooking_time_hrs;
  private String difficulty;

  //setters
  public void setId(int id){
    this.id=id;
  }

  public void setTitle(String title){
    this.title=title;
  }

  public void setInstructions(String instructions){
    this.instructions=instructions;
  }

  public void setRatings(double ratings)
  {
    this.ratings=ratings;
  }

  public void setCookingTimeHrs(double cooking_time_hrs){
    this.cooking_time_hrs=cooking_time_hrs;
  }

  public void setDifficulty(String difficulty)
  {
    this.difficulty=difficulty;
  }

  //getters
  public int getId(){
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getInstructions()
  {
    return instructions;
  }

  public double getRatings(){
    return ratings;
  }

  public double getCookingTimeHrs(){
    return cooking_time_hrs;
  }

  public String getDifficulty(){
    return difficulty;
  }

}