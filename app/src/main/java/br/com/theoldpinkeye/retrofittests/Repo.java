package br.com.theoldpinkeye.retrofittests;

public class Repo {

  @Override
  public String toString() {
    return "Repo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  private int id;
  private String name;

  public Repo() {
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

